package cn.system.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.system.domain.LinkMan;

public interface LinkManDao {

	void addLinkMan(LinkMan lkm);

	List<LinkMan> listLinkManAllOrByname(DetachedCriteria dc);

}
