package cn.system.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.system.domain.Customer;

public interface CustomerService {
	//添加客户
	void addCustomer(Customer cust);
	//列出客户名单
	List<Customer> listCustomer(DetachedCriteria dc);

}
