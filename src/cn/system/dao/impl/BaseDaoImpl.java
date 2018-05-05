package cn.system.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.system.dao.BaseDao;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {
	private Class hostclass;	
	
	
	public BaseDaoImpl() {
		ParameterizedType Superclass = (ParameterizedType) this.getClass().getGenericSuperclass();
		hostclass = (Class) Superclass.getActualTypeArguments()[0];
	}
	
	@Override
	public void saveOrUpdate(T t) {
		getHibernateTemplate().saveOrUpdate(t);
		
	}
	
	@Override
	public void save(T t) {
		getHibernateTemplate().save(t);
	}

	@Override
	public List list(DetachedCriteria dc,Integer start,Integer pageRecord) {
		List list = getHibernateTemplate().findByCriteria(dc, start, pageRecord);
		return list;
	}

	@Override
	public Integer getCount(DetachedCriteria dc) {
		dc.setProjection(Projections.rowCount());
		List<Long> count =  (List<Long>) getHibernateTemplate().findByCriteria(dc);
		//清空查询条件
		dc.setProjection(null);
		if(count != null && count.size()!=0){
			Long num = count.get(0);
			return num.intValue();
		}
		return null;
	}

	@Override
	public List getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T getById(Serializable Id) {
		T t =  (T) getHibernateTemplate().get(hostclass, Id);
		return t;
	}

	@Override
	public void delete(T t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Serializable Id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(T t) {
		
		
	}

	

}
