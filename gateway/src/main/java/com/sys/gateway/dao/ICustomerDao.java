package com.sys.gateway.dao;

import com.sys.gateway.vo.CustomerDB;
import com.sys.gateway.vo.ErrorInfo;

import java.util.List;

public interface ICustomerDao {

    void updateToDB(List<CustomerDB> cusDbs);

    void insertError(ErrorInfo errorInfo);
}
