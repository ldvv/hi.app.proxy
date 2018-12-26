package com.sys.gateway.controller;

import com.sys.gateway.security.SecurityUser;
import com.sys.gateway.service.IUserService;
import com.sys.gateway.vo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/")
public class ViewController {

    private static final Logger logger = LoggerFactory.getLogger(ViewController.class);

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

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(Model model, @RequestParam(value = "error", required = false) String error) {
        return "index";
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
