package cn.system.dao;

import java.util.List;

import cn.system.domain.BaseDict;

public interface BaseDictDao extends BaseDao<BaseDict>{
	//根据typecode列出数据库中所有符合条件的数据
	List<BaseDict> getByTypeCode(String dict_type_code);

}
