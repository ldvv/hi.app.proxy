package com.tools.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ToolsService {

    private static final Logger logger = LoggerFactory.getLogger(ToolsService.class);

    private DecimalFormat df=(DecimalFormat) NumberFormat.getInstance();


    /**
     * jsp文件国际化方法
     *
     * @param jspFile jsp文件路径
     * @param propertyFile property文件路径
     * @param resultPath jsp, property结果保存路径
     *
     * */
    public void internationalization(String jspFile, String resultPath, String propertyFile){
        logger.info("D9999: Begin operate jsp file------------------------->" + jspFile.substring(jspFile.lastIndexOf("\\"), jspFile.length()));

        StringBuffer content = new StringBuffer("");

        List<String> chinese = new ArrayList<>();
        Pattern pattern = Pattern.compile("[\\u4e00-\\u9fa5]+");
        Pattern patternNotes = Pattern.compile("\\/\\*([^\\*^\\/]*|[\\*^\\/*]*|[^\\**\\/]*)*\\*\\/");
        df.applyPattern("0000");

        File file = new File(jspFile);
        BufferedReader reader = null;
        FileInputStream in = null;
        try {
            /*******************读取jsp文件流*************************/
            logger.info("D9999: Read jsp file!");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                if(tempString.contains("//")){
                    tempString = tempString.replaceFirst("(/\\*([^*]|[\\r\\n]|(\\*+([^*/]|[\\r\\n])))*\\*+/|[ \\t]*//.*)", "");
                }
                content.append(tempString).append(System.getProperty("line.separator"));
            }

            String contentStr = content.toString();

            /*******************删除所有注释，避免多余的国际化*************************/
            logger.info("D9999: Delete Notes!");
            Matcher matcherNotes = patternNotes.matcher(contentStr);
            while(matcherNotes.find()){
                contentStr = contentStr.replaceFirst("\\/\\*([^\\*^\\/]*|[\\*^\\/*]*|[^\\**\\/]*)*\\*\\/", "");
                matcherNotes = patternNotes.matcher(contentStr);
            }

            /*******************筛选所有的中文*************************/
            logger.info("D9999: Get All Chinese!");
            Matcher matcher = pattern.matcher(content);
            while(matcher.find()){
                chinese.add(matcher.group());
            }

            /*******************读取property文件并新增新的数据*************************/
            logger.info("D9999: Get Old properties!");
            Properties pro = new Properties();
            Properties proNew = new Properties(); //用于更新property文件
            in = new FileInputStream(propertyFile);
            pro.load(in);
            int num = pro.size();

            logger.info("D9999: update properties and jsp!");
            for (String ch: chinese) {
                if(pro.containsValue(ch)){
                    contentStr = contentStr.replaceFirst(ch, "\\${cs:getText('"+ getKey(pro, ch) + "')}");
                    continue;
                }
                pro.setProperty("crm.global."+df.format(num),ch);
                proNew.setProperty("crm.global."+df.format(num),ch);
                contentStr = contentStr.replaceFirst(ch, "\\${cs:getText('crm.global."+df.format(num)+ "')}");
                num++;
            }

            /*******************保存property文件*************************/
            logger.info("D9999: update properties file!");
            FileOutputStream propertyResultFile = new FileOutputStream(resultPath + "\\property.properties", true);//true表示追加打开
            proNew.store(propertyResultFile, jspFile.substring(jspFile.lastIndexOf("\\"), jspFile.length()));
            propertyResultFile.flush();
            propertyResultFile.close();

            /*******************保存jsp文件*************************/
            logger.info("D9999: update jsp file!");
            FileOutputStream jspResultFile = new FileOutputStream(
                    resultPath + jspFile.substring(jspFile.lastIndexOf("\\"), jspFile.length()),
                    false);//true表示追加打开
            jspResultFile.write(contentStr.getBytes());
            jspResultFile.flush();
            jspResultFile.close();
        } catch (Exception e) {
            logger.error("D9999: execute error::::::::", e);
            return;
        }finally {
            logger.info("D9999: End to operate jsp file------------------------->" + jspFile.substring(jspFile.lastIndexOf("\\"), jspFile.length()));
            if(reader!=null){
                try {
                    reader.close();
                }catch (IOException e1){
                    e1.printStackTrace();
                }
            }
            if(in!=null){
                try {
                    in.close();
                }catch (IOException e2){
                    e2.printStackTrace();
                }
            }
        }
    }

    private String getKey(Properties pro, String ch) {
        Enumeration enum1 = pro.propertyNames();//得到配置文件的名字
        while(enum1.hasMoreElements()) {
            String strKey = (String) enum1.nextElement();
            String strValue = pro.getProperty(strKey);
            if(strValue.equals(ch)){
                return strKey;
            }
        }
        return null;
    }
}
