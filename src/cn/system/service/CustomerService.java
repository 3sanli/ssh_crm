package cn.system.service;


import cn.system.domain.Customer;
import cn.system.util.PageBean;

public interface CustomerService {
	//添加客户
	void addCustomer(Customer cust);
	//列出客户名单,封装到pageBean中返回
	PageBean getPageBean(Customer cust,Integer currentPage,Integer pageRecord);

}