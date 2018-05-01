package cn.system.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.system.dao.CustomerDao;
import cn.system.dao.LinkManDao;
import cn.system.domain.Customer;
import cn.system.domain.LinkMan;
import cn.system.service.LinkManService;

public class LinkManServiceImpl implements LinkManService {
	private CustomerDao custDao;
	private LinkManDao lkmDao;
	@Override
	public void addLinkMan(LinkMan lkm) {
		Customer cust = (Customer) custDao.getById(lkm.getCust_id());
		lkm.setCust(cust);
		lkmDao.addLinkMan(lkm);
	}

	@Override
	public List<LinkMan> listLinkMan(DetachedCriteria dc) {
		List<LinkMan> list = lkmDao.listLinkManAllOrByname(dc);
		return list;
	}

	public void setLkmDao(LinkManDao lkmDao) {
		this.lkmDao = lkmDao;
	}

	public void setCustDao(CustomerDao custDao) {
		this.custDao = custDao;
	}
	
}
