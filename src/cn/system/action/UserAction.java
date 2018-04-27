package cn.system.action;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

import cn.system.domain.User;
import cn.system.service.UserService;

public class UserAction extends ActionSupport implements Preparable{
	private UserService us;
	
	private User user = new User();
	public String login() throws Exception {
		User u = us.getUser(user);		
		ActionContext.getContext().put("user", u);
		return "login";
	}
	@Override
	public void prepare() throws Exception {
		ActionContext.getContext().getValueStack().push(user);
		
	}
	public void setUs(UserService us) {
		this.us = us;
	}
	
}
