package cn.system.a_test;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.DetachedCriteria;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.system.dao.BaseDao;
import cn.system.dao.UserDao;
import cn.system.domain.Customer;
import cn.system.domain.User;
import cn.system.service.CustomerService;
import cn.system.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Demo {
	@Resource(name="sessionFactory")
	private SessionFactory sf;
	@Resource(name="userDao")
	private UserDao ud;
	@Resource(name="userService")
	private UserService us;
	@Resource(name="customerService")
	private CustomerService cs;
	
	@Test
	public void fun1() {
		Configuration cf = new Configuration().configure();
		SessionFactory sf = cf.buildSessionFactory();
		Session session = sf.openSession();
		Transaction ts = session.beginTransaction();
		//-----------------------------
		session.get(User.class, 1);
		
		//-----------------------------
		ts.commit();
		session.close();
	}
	@Test
	public void fun2() {		
		User u = ud.getUserByCode("lxd");
		System.out.println(u);
	}
	@Test
	public void fun3() {	
		User user = new User();
		user.setUser_code("lxd");
		user.setUser_password("123");
		User u = us.getUser(user);
		System.out.println(u);
	}
	@Test
	public void fun4() {	
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		cs.listCustomer(dc);
		
	}
	@Test
	public void fun5() {	
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		List<Customer> list = cs.listCustomer(dc);
		System.out.println(list);
	}
}
