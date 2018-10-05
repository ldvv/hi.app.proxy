package com.sys.gateway.controller;

import com.sys.gateway.service.IUserService;
import com.sys.gateway.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/")
public class ViewController {

    @Autowired
    IUserService iUserService;

    @RequestMapping("")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody Map<String, String> login(@RequestBody User user){
        Map<String, String> result = new HashMap<>();
        result.put("code", "200");
        result.put("message", "success");
        return result;
    }

    @RequestMapping(value = "/overview", method = RequestMethod.GET)
    public String overview(){
        return "view/overview/overview";
    }

}
