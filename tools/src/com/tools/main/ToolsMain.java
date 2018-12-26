package com.tools.main;

import com.tools.service.ToolsService;

public class ToolsMain {

    private static ToolsService toolsService = new ToolsService();

    //查询文件中所有的中文
    public static void main(String[] args) {
        String jspFile = "E:\\myproject\\tterp_crm_web\\src\\main\\webapp\\WEB-INF\\views\\modules\\customer\\customer_list.jsp";
        String result = "F:\\mytools";
        String propertyFile = "F:\\mytools\\property.properties";
        toolsService.internationalization(jspFile, result, propertyFile);
    }
}
