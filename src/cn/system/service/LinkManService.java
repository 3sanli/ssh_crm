package cn.system.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.system.domain.LinkMan;

public interface LinkManService {
	//添加联系人
	void addLinkMan(LinkMan lkm);
	//列出联系人
	List<LinkMan> listLinkMan(DetachedCriteria dc);

}
