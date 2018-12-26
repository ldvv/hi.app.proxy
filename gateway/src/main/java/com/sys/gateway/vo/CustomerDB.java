package com.sys.gateway.vo;

public class CustomerDB {

    private String id;
    private String baseInfo;
    private String labels;
    private String orderInfo;
    private String otherInfo;
    private String time;

    public CustomerDB(){}

    public CustomerDB(CustomersVO vo){
        this.id = vo.getId()+"";
        this.baseInfo = "客户名称 :" + vo.getCustomerName() + "\\n" +
                "姓名 :" + vo.getName() + "\\n" +
                "昵称 :" + vo.getNickName() + "\\n" +
                "性别 :" + vo.getSex() + "\\n" +
                "国家 :" + vo.getCountry() + "\\n" +
                "州省 :" + vo.getStateProvince() + "\\n" +
                "城市 :" + vo.getCity() + "\\n" +
                "语言 :" + vo.getLanguage() + "\\n" +
                "货币 :" + vo.getCurrency() + "\\n" +
                "地址 :" + vo.getAddress() + "\\n" +
                "邮编 :" + vo.getPost() + "\\n" +
                "手机 :" + vo.getMobilePhone() + "\\n" +
                "固定电话 :" + vo.getTelephone() + "\\n" +
                "邮箱 :" + vo.getEmail() + "\\n" +
                "Facebook :" + vo.getFacebook() + "\\n" +
                "Twitter :" + vo.getTwitter() + "\\n" +
                "Google+ :" + vo.getGooglePlus() + "\\n" +
                "生日 :" + vo.getBirthday();
        this.orderInfo = "订单总数/总金额 :" + vo.getOrderSum() + "/" + vo.getOrderAmount() + "\\n" +
                "平均订单价 :" + vo.getOrderPriceAvg() + "" +
                "退款订单数/金额 :" + vo.getOrderRefundCount() + "/" + vo.getOrderRefundPrice() + "\\n" +
                "购买频率(天) :" + vo.getFrequency() + "\\n" +
                "下单商品总数 :" + vo.getPlaceOrderSkuSum() + "\\n" +
                "营销次数 :" + vo.getServiceCount() + "\\n" +
                "SKU :" + vo.getSku() + "\\n" +
                "商品类别 :" + vo.getSkuCategoryId() + "\\n" +
                "最近购买店铺标识 :" + vo.getPlatformAccount() + "\\n" +
                "最近购买店铺Symbol :" + vo.getSymbol();
        this.otherInfo = "客户类型 :" + "订单客户" +
                "渠道类型 :" + vo.getChannelType() + "\\n" +
                "推销状态 :" + (vo.getForbidSalePromotion() == 1? "禁止" : "允许");
        this.time = "第一次下单时间 :" + vo.getFirstPlaceOrderDate() + "\\n" +
                "最后一次下单时间 :" + vo.getLastPlaceOrderDate() + "\\n" +
                "创建时间 :" + vo.getCreateDate() + "\\n" +
                "更新时间 :" + vo.getUpdateDate();
        this.labels = "";
    }

    public String getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(String baseInfo) {
        this.baseInfo = baseInfo;
    }

    public String getLabels() {
        return labels;
    }

    public void setLabels(String labels) {
        this.labels = labels;
    }

    public String getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(String orderInfo) {
        this.orderInfo = orderInfo;
    }

    public String getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
