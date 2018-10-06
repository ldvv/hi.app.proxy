package com.sys.gateway.service;

import com.sys.gateway.vo.User;

import java.util.List;
import java.util.Map;

public interface IUserService{

    Map<String, String> login(User user);
}
