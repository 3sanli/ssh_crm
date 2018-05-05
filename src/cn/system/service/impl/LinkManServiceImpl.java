package cn.system.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import cn.system.dao.CustomerDao;
import cn.system.dao.LinkManDao;
import cn.system.domain.Customer;
import cn.system.domain.LinkMan;
import cn.system.service.LinkManService;
import cn.system.util.PageBean;

public class LinkManServiceImpl implements LinkManService {
	private LinkManDao lkmDao;
	
	@Override
	public void addLinkMan(LinkMan lkm) {
		lkmDao.saveOrUpdate(lkm);
	}

	@Override
	public PageBean getPageBean(LinkMan lkm,Integer currentPage,Integer pageRecord) {
		DetachedCriteria dc = DetachedCriteria.forClass(LinkMan.class);
		
		if(lkm.getCust().getCust_id()!=null) {
			dc.add(Restrictions.eq("cust", lkm.getCust()));
		}
		
		if(StringUtils.isNotBlank(lkm.getLkm_name())) {
			dc.add(Restrictions.like("lkm_name", "%"+lkm.getLkm_name()+"%"));
		}
		
		Integer recordSize = lkmDao.getCount(dc);
		PageBean pb = new PageBean(recordSize, currentPage, pageRecord);
				
		List <LinkMan> list = lkmDao.list(dc,pb.getStart(),pb.getPageRecord());
	
		pb.setList(list);
		return pb;
	}

	public void setLkmDao(LinkManDao lkmDao) {
		this.lkmDao = lkmDao;
	}

	@Override
	public LinkMan get(LinkMan lkm) {
		LinkMan linkMan = lkmDao.getById(lkm.getLkm_id());
		return linkMan;
	}


}
