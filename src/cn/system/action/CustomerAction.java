package cn.system.action;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

import cn.system.domain.Customer;
import cn.system.domain.LinkMan;
import cn.system.service.CustomerService;
import cn.system.util.PageBean;

public class CustomerAction extends ActionSupport implements Preparable{
	private Customer cust = new Customer();
	private PageBean pb;
	private Integer currentPage;
	private Integer pageRecord;
	private CustomerService cs;
	
	
	public String add() {
		cs .addCustomer(cust);		
		return "add";
	}
	
	public String toEdit() {		
		Customer customer = cs.get(cust);
		ActionContext.getContext().put("customer", customer);		
		return "edit";
	}
	
	public String list() {				
		pb = cs.getPageBean(cust,currentPage,pageRecord);		
		ActionContext.getContext().put("page", pb);		
		return "list";
	}
	
	@Override
	public void prepare() throws Exception {
		ActionContext.getContext().getValueStack().push(cust);
	}

	
	
	
	public void setCs(CustomerService cs) {
		this.cs = cs;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageRecord() {
		return pageRecord;
	}

	public void setPageRecord(Integer pageRecord) {
		this.pageRecord = pageRecord;
	}

}
