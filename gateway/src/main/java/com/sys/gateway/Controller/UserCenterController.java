package com.sys.gateway.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/user")
public class UserCenterController {

    @RequestMapping(value = "/usercenter", method = RequestMethod.GET)
    public String usercenter(){
        return "view/usercenter/usercenter";
    }
}
