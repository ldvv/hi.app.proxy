package com.sys.gateway.dao;

import com.sys.gateway.vo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserDao extends SqlMapper<User> {

    List<User> queryUsers();
}
