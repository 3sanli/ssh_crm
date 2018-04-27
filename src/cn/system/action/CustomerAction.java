package cn.system.action;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

import cn.system.domain.Customer;
import cn.system.service.CustomerService;

public class CustomerAction extends ActionSupport implements Preparable{
	private Customer cust = new Customer();
	private CustomerService cs;
	
	public String add() {
		cs .addCustomer(cust);		
		return "add";
	}
	
	public String list() {
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		
		if(StringUtils.isNotEmpty(cust.getCust_name())) {
			dc.add(Restrictions.like("cust_name", "%"+cust.getCust_name()+"%"));
		}
		
		List <Customer> custs = cs.listCustomer(dc);
		
		System.out.println(custs);
		
		ActionContext.getContext().put("list", custs);
		return "list";
	}
	@Override
	public void prepare() throws Exception {
		ActionContext.getContext().getValueStack().push(cust);
		
	}

	public void setCs(CustomerService cs) {
		this.cs = cs;
	}

}
