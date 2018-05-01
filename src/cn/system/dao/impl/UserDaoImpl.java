package cn.system.dao.impl;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.system.dao.UserDao;
import cn.system.domain.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
	
	@Override
	public User getUserByCode(String user_code) {		
		return getHibernateTemplate().execute(new HibernateCallback<User>() {

			@Override
			public User doInHibernate(Session session) throws HibernateException {
				String hql = "from User where user_code=?";
				Query query = session.createQuery(hql);
				query.setParameter(0, user_code);
				User u = (User) query.uniqueResult();
				return u;
			}
			
		});
	}

}
