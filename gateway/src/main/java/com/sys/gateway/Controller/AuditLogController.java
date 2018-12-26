package com.sys.gateway.controller;

import com.alibaba.fastjson.JSON;
import com.sys.gateway.dao.ICustomerDao;
import com.sys.gateway.utils.HttpUtils;
import com.sys.gateway.vo.CustomerDB;
import com.sys.gateway.vo.CustomersVO;
import com.sys.gateway.vo.Label;
import org.apache.commons.lang.StringUtils;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.search.MultiMatchQuery;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.sort.SortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.FileOutputStream;
import java.util.*;

@Controller
@RequestMapping("/log")
public class AuditLogController {

    private static final Logger logger = LoggerFactory.getLogger(AuditLogController.class);

    @Autowired
    private ICustomerDao iCustomerDao;

    @Autowired
    private TransportClient client;

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String logView(){
        return "view/log/logview";
    }

    @RequestMapping(value = "/dataList", method = RequestMethod.GET)
    public @ResponseBody
    String dataList(@RequestParam String id, @RequestParam String cookie){
        logger.info("D9999: Id is "+ id + ",        Cookie is "+ cookie);
        if(StringUtils.isNotBlank(id) && StringUtils.isNotBlank(cookie)){
            return exportCustomers(id, cookie);
        }
        return "Id or cookie is null!!";
    }

    private String exportCustomers(String id, String cookie) {
        Map<String, String> requestHeader = new HashMap<>();
        requestHeader.put("Cookie", cookie);
        Map<String, String> allLabels = queryLabels(requestHeader);
        while(true){
            logger.info("D9999:Execute MIN id is: " + id);
            String resultJson = "";
            try {
                /*resultJson = HttpUtils.doGet("http://192.168.0.233:84/customer/dataListComplete?customerType=10&pageNumber=1&id=" + id, requestHeader);
                Map<String, Object> map = JSON.parseObject(resultJson, Map.class);
                Map<String, Object> datas = JSON.parseObject(JSON.toJSONString(map.get("result")), Map.class);*/
                List<CustomersVO> customers = JSON.parseArray(JSON.toJSONString(dataListComplete(Integer.parseInt(id))), CustomersVO.class);
                if(customers == null || customers.size() == 0){
                    logger.info("D9999:Data is null");
                    logger.info("D9999: " + resultJson);
                    return "Data is null";
                }

                List<CustomerDB> cusDbs = new ArrayList<>();
                for (CustomersVO customer:customers) {
                    id = customer.getId()+"";
                    CustomerDB customerDB = new CustomerDB(customer);
                    //添加标签
                    if(customer.getLabels() != null && customer.getLabels().size()>0){
                        for (Integer labelId: customer.getLabels()) {
                            customerDB.setLabels(customerDB.getLabels() + allLabels.get(labelId+"") + ", ");
                        }
                    }
                    cusDbs.add(customerDB);
                }

                logger.info("D9999:Data count is : " + cusDbs.size());
                iCustomerDao.updateToDB(cusDbs);
            }catch (Exception e){
                logger.error("D9999:Execute error at *********************************************" + id, e);
                try{
                    FileOutputStream logFile = new FileOutputStream("F:\\mytools\\log.log",false);//true表示追加打开
                    logFile.write((e.toString() + "#####################" +id + "######################").getBytes() );
                    logFile.flush();
                    logFile.close();
                }catch (Exception e1){
                    e.printStackTrace();
                }finally {
                    continue;
                }
//                return "Execute error at " + id;
            }
        }
    }

    public List<Map<String,Object>> dataListComplete(@RequestParam int id) {
        Map<String,Object> query = new HashMap<>();
        query.put("customerType", 10);

        Map<String,Object> idRange = new HashMap<>();
        idRange.put("$lt", id);
        query.put("id", idRange);

        Map<String,Object> sort = new LinkedHashMap<>(); //排序有先后顺序，所以用LinkHashMap
        sort.put("id", -1);
        System.out.println(query.toString());
        List<Map<String, Object>> datas = new ArrayList<>();
        try{
            datas = searchMessageByPage(query, sort, 100, 1);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

        return datas;
    }

    private Map<String,String> queryLabels(Map<String,String> header) {
        Map<String,String> result = new HashMap<>();
        String resultJson = "";
        try {
            resultJson = HttpUtils.doGet("http://192.168.0.233:84/label/listData?pageSize=100000", header);
            Map<String, Object> map = JSON.parseObject(resultJson, Map.class);
            List<Label> labels = JSON.parseArray(JSON.toJSONString(map.get("datas")), Label.class);
            if(labels == null || labels.size() == 0){
                return result;
            }
            for (Label label: labels) {
                result.put(label.getId()+"", label.getName());
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 根据关键词查询  分页查询
     * @param query 搜索关键词Map key 是要搜索的字段 value是关键词
     * @return
     * @throws Exception
     */
    public List<Map<String, Object>> searchMessageByPage(Map<String, Object> query, Map<String, Object> sort, Integer pageSize, Integer pageNumber) throws Exception{
        List<Map<String, Object>> dataList = new ArrayList<>();

        QueryBuilder queryBuilder = getQueryBuilder(query);
        SortBuilder sortBuilder = getSort(sort);
        //query
        SearchResponse response = client.prepareSearch("customer")
                .setPostFilter(queryBuilder)
                .addSort(sortBuilder)
                .setFrom(pageSize*(pageNumber-1))
                .setSize(pageSize)
                .execute()
                .actionGet();
        for (SearchHit searchHit : response.getHits()) {
            try {
                dataList.add(searchHit.getSource());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return dataList;
    }

    public static SortBuilder getSort(Map<String, Object> requestArgs) {
        String sortField = "id";
        String sortDirection = "-1";
        HashMap sort = (HashMap) requestArgs.get("sort");
        if (null != sort) {
            Iterator localIterator = sort.keySet().iterator();
            if (localIterator.hasNext()) {
                String key = (String) localIterator.next();
                sortDirection = sort.get(key).toString();
                sortField = key;
            }

        }
        if ("-1".equals(sortDirection))
            return SortBuilders.fieldSort(sortField).order(SortOrder.DESC);
        else {
            return SortBuilders.fieldSort(sortField).order(SortOrder.ASC);
        }
    }

    private BoolQueryBuilder getQueryBuilder(Map<String, Object> query) {

        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
        if (null != query) {
            for (String key : query.keySet()) {
                Object value = query.get(key);
                boolQuery.must(_parseCriteria(key, value));
            }
        }
        return boolQuery;
    }


    private static BoolQueryBuilder _parseCriteria(String key, Object value) {
        if ("id".equals(key)) {
            key = "id";
        }
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
        Map<String,Object> compareValue = null;
        if ((value instanceof Map)) {
            compareValue = (Map)value;
            for (String compare : compareValue.keySet()) {
                Object _compareValue = compareValue.get(compare);
                if ("$ge".equals(compare)){
                    queryBuilder.must(QueryBuilders.rangeQuery(key).gte(_compareValue));
                }else if ("$le".equals(compare)){
                    queryBuilder.must(QueryBuilders.rangeQuery(key).lte(_compareValue));
                }else if ("$gt".equals(compare)){
                    queryBuilder.must(QueryBuilders.rangeQuery(key).gt(_compareValue));
                }else if ("$lt".equals(compare)){
                    queryBuilder.must(QueryBuilders.rangeQuery(key).lt(_compareValue));
                }else if ("$in".equals(compare)){
                    queryBuilder.must(QueryBuilders.termsQuery(key, (Collection)_compareValue));
                    // criterias.add(Criteria.where(key).in((Collection)_compareValue));
                }else if ("$like".equals(compare)){
                    queryBuilder.must(QueryBuilders.matchPhraseQuery(key, _compareValue+""));
                }else if ("$left_like".equals(compare)){
                    queryBuilder.must(QueryBuilders.matchPhraseQuery(key, compareValue.get((String)_compareValue)));
                }else if ("$right_like".equals(compare)){
                    queryBuilder.must(QueryBuilders.matchPhraseQuery(key, compareValue.get((String)_compareValue)));
                }else if ("$not_like".equals(compare)){
                    ;
                    //queryBuilder.must(QueryBuilders.matchPhraseQuery(key, compareValue.get((String)_compareValue)));
                }else if ("$left_like".equals(compare)){
                    queryBuilder.must(QueryBuilders.matchPhraseQuery(key, compareValue.get((String)_compareValue)));
                }else if ("$not_right_like".equals(compare)){
                    queryBuilder.must(QueryBuilders.matchPhraseQuery(key, compareValue.get((String)_compareValue)));
                }else if ("$ne".equals(compare)){
                    queryBuilder.mustNot(QueryBuilders.matchPhraseQuery(key,_compareValue));;
                }else if ("$null".equals(compare)){
                    queryBuilder.mustNot(QueryBuilders.existsQuery(key));
                }else if ("$not_null".equals(compare)){
                    ;
                }else if ("$not_in".equals(compare)){
                    queryBuilder.mustNot(QueryBuilders.termsQuery(key, (Collection)_compareValue));;
                }else if ("$where".equals(compare)){
                    queryBuilder.must(QueryBuilders.matchPhraseQuery(key, value));
                }
            }
        }
        else {
            if(value!=null || value.equals("")){
                queryBuilder.must(QueryBuilders.matchPhraseQuery(key, value));
            }
        }

        return queryBuilder;
    }

}
