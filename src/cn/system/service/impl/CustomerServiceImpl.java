package cn.system.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import cn.system.dao.CustomerDao;
import cn.system.domain.Customer;
import cn.system.domain.LinkMan;
import cn.system.service.CustomerService;
import cn.system.util.PageBean;

public class CustomerServiceImpl implements CustomerService {
	private CustomerDao cd;
	@Override
	public void addCustomer(Customer cust) {
		cd.saveOrUpdate(cust);
	}
	@Override
	public PageBean getPageBean(Customer cust,Integer currentPage,Integer pageRecord) {
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		if(StringUtils.isNotBlank(cust.getCust_name())) {
			dc.add(Restrictions.like("cust_name", "%"+cust.getCust_name()+"%"));
		}
		
		Integer recordSize = cd.getCount(dc);
		PageBean pb = new PageBean(recordSize, currentPage, pageRecord);
				
		List <Customer> list = cd.list(dc,pb.getStart(),pb.getPageRecord());
	
		pb.setList(list);
		return pb;
	}
	public void setCd(CustomerDao cd) {
		this.cd = cd;
	}
	@Override
	public Customer get(Customer cust) {
		Customer custmoer = cd.getById(cust.getCust_id());
		return custmoer;
	}
	
}
