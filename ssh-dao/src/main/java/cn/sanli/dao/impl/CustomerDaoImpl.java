package cn.sanli.dao.impl;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.sanli.bean.Customer;
import cn.sanli.dao.CustomerDao;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {

	@Override
	public Customer getById(Long cust_id) {		
		return getHibernateTemplate().get(Customer.class, cust_id);
	}

}
