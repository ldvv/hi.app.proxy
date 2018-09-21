package com.sys.gateway.Controller;

import com.sys.gateway.service.IUserService;
import com.sys.gateway.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class ViewController {

    @Autowired
    IUserService iUserService;

    @RequestMapping("")
    public String index(){

        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody String login(@RequestBody User user){
        System.out.print(user.getName());
        return iUserService.queryUsers().toString();
    }

    @RequestMapping("/logout")
    public String logout(){
        return "logout";
    }

}
