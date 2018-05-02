package cn.system.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface BaseDao<T> {
	//保存实例
	void save(T t);
	//删除实例
	void delete(T t);
	//根据Id删除实例
	void delete(Serializable Id);
	//更新
	void update(T t);
	//查询所有记录
	List list(DetachedCriteria dc,Integer start,Integer pageRecord);
	//查询所有记录数
	Integer getCount(DetachedCriteria dc);
	//根据名字查询
	List getByName(String name);
	//根据id查询
	T getById(Serializable Id);
}
