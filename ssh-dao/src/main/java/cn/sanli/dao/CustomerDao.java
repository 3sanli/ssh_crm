package cn.sanli.dao;

import cn.sanli.bean.Customer;

public interface CustomerDao {
	/*
	 * 根据客户id查询客户信息
	 */
	Customer getById(Long cust_id);
}
