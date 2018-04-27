package cn.system.dao.impl;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.system.dao.CustomerDao;
import cn.system.domain.Customer;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {

	@Override
	public void addCustomer(Customer cust) {
		getHibernateTemplate().save(cust);
	}

	@Override
	public List<Customer> getCustomerAllOrByName(DetachedCriteria dc) {
		List<Customer> list = (List<Customer>) getHibernateTemplate().findByCriteria(dc);
		return list;
	}

	@Override
	public Customer getCustomerById(Long cust_id) {
		Customer cust = getHibernateTemplate().execute(new HibernateCallback<Customer>() {

			@Override
			public Customer doInHibernate(Session session) throws HibernateException {
				String hql = "from Customer where cust_id=?";
				Query query = session.createQuery(hql);
				query.setParameter(0, cust_id);
				Customer cust = (Customer) query.uniqueResult();
				return cust;
			}
			
		});
		return cust;
	}

	

}
