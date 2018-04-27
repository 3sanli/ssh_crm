package cn.system.action;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

import cn.system.domain.LinkMan;
import cn.system.service.LinkManService;

public class LinkManAction extends ActionSupport implements Preparable{
	private LinkManService lkms;
	private LinkMan lkm = new LinkMan();
	
	public String add() {
		lkms.addLinkMan(lkm);
		
		return "add";
	}
	
	public String list() {
		DetachedCriteria dc = DetachedCriteria.forClass(LinkMan.class);
		
		if(StringUtils.isNotEmpty(lkm.getLkm_name())) {
			dc.add(Restrictions.like("lkm_name", "%"+lkm.getLkm_name()+"%"));
		}
		
		List<LinkMan> list = lkms.listLinkMan(dc);
		ActionContext.getContext().put("list", list);
		return "list";
	}
	
	@Override
	public void prepare() throws Exception {
		ActionContext.getContext().getValueStack().push(lkm);
		
	}

	public void setLkms(LinkManService lkms) {
		this.lkms = lkms;
	}
	
	
}
