package cn.sanli.dao.impl;


import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.sanli.bean.Customer;
import cn.sanli.dao.CustomerDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class CustomerDaoImplTest {
	@Resource(name="customerDao")
	private CustomerDao custDao;
	
	@Test
	public void demoTest() {
		Customer cust = custDao.getById(1l);
		System.out.println(cust);
	}
	
	
}
