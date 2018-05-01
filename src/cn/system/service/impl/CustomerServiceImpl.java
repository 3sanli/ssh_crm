package cn.system.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.system.dao.CustomerDao;
import cn.system.domain.Customer;
import cn.system.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
	private CustomerDao cd;
	@Override
	public void addCustomer(Customer cust) {
		cd.save(cust);
	}
	@Override
	public List<Customer> listCustomer(DetachedCriteria dc) {
		List <Customer> custs = cd.list(dc);
		return custs;
	}
	public void setCd(CustomerDao cd) {
		this.cd = cd;
	}
	
}
