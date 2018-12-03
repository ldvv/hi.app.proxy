package com.sys.gateway.controller;

import com.sys.gateway.security.SecurityUser;
import com.sys.gateway.service.IUserService;
import com.sys.gateway.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/")
public class ViewController {

    @Autowired
    IUserService iUserService;

    @RequestMapping("")
    public String index(){
        return "view/overview/overview";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, @RequestParam(value = "error", required = false) String error) {
        if (error != null && error.equals("1")) {
            model.addAttribute("error", "用户名或密码错误");
        }
        if (error != null && error.equals("2")) {
            model.addAttribute("error", "账号在其他地方登陆");
        }
        return "index";
    }

    @RequestMapping(value = "/overview", method = RequestMethod.GET)
    public String overview(){
        return "view/overview/overview";
    }

    @RequestMapping(value = "/usercenter", method = RequestMethod.GET)
    public String usercenter(){
        return "view/usercenter/usercenter";
    }

    @RequestMapping(value = "/me", method = RequestMethod.GET)
    public @ResponseBody
    User userCenter(HttpServletRequest request){
        SecurityUser securityUser = (SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        //查询用户信息
        User me = iUserService.selectByPrimaryKey(securityUser.getId());

        if(me != null){
            me.setPassword("*******");
        }
        return me;
    }

}
