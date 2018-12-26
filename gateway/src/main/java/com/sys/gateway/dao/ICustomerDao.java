package com.sys.gateway.dao;

import com.sys.gateway.vo.CustomerDB;

import java.util.List;

public interface ICustomerDao {

    void updateToDB(List<CustomerDB> cusDbs);
}
