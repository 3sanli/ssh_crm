package cn.system.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.system.dao.LinkManDao;
import cn.system.domain.LinkMan;

public class LinkManDaoImpl extends HibernateDaoSupport implements LinkManDao {

	@Override
	public void addLinkMan(LinkMan lkm) {
		getHibernateTemplate().save(lkm);
		
	}

	@Override
	public List<LinkMan> listLinkManAllOrByname(DetachedCriteria dc) {
		List<LinkMan> list = (List<LinkMan>) getHibernateTemplate().findByCriteria(dc);
		return list;
	}

}
