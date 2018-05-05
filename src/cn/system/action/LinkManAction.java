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
import cn.system.util.PageBean;

public class LinkManAction extends ActionSupport implements Preparable{
	private LinkManService lkms;
	private PageBean pb;
	private Integer currentPage;
	private Integer pageRecord;
	private Integer custIdInput;
	private LinkMan lkm = new LinkMan();
	
	public String add() {
		lkms.addLinkMan(lkm);
		
		return "add";
	}
	
	public String list() {		
		pb = lkms.getPageBean(lkm,currentPage,pageRecord);		
		ActionContext.getContext().put("page", pb);		
		return "list";
	}
	
	public String toEdit() {		
		LinkMan linkMan = lkms.get(lkm);
		ActionContext.getContext().put("linkMan", linkMan);		
		return "edit";
	}
	
	@Override
	public void prepare() throws Exception {
		ActionContext.getContext().getValueStack().push(lkm);
		
	}

	public void setLkms(LinkManService lkms) {
		this.lkms = lkms;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public void setPageRecord(Integer pageRecord) {
		this.pageRecord = pageRecord;
	}

	public void setCustIdInput(Integer custIdInput) {
		this.custIdInput = custIdInput;
	}
	
	
}
