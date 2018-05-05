package cn.system.service;


import cn.system.domain.LinkMan;
import cn.system.util.PageBean;

public interface LinkManService {
	//添加联系人
	void addLinkMan(LinkMan lkm);
	//列出联系人名单,封装到pageBean中返回
	PageBean getPageBean(LinkMan lkm,Integer currentPage,Integer pageRecord);

}
