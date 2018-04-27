package cn.system.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.system.domain.Customer;

public interface CustomerDao {

	void addCustomer(Customer cust);
	
	List<Customer> getCustomerAllOrByName(DetachedCriteria dc);
	
	Customer getCustomerById(Long cust_id);

}
