package com.sys.gateway.controller;

import com.sys.gateway.service.IUserService;
import com.sys.gateway.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, @RequestParam(value = "error", required = false) String error) {
        if (error != null) {
            model.addAttribute("error", "用户名或密码错误");
        }
        return "index";
    }

    @RequestMapping(value = "/overview", method = RequestMethod.GET)
    public String overview(){
        return "view/overview/overview";
    }

}
