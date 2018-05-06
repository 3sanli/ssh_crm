package cn.system.service;

import java.util.List;

import cn.system.domain.BaseDict;

public interface BaseDictService {
	//根据typecode列出数据库中所有符合条件的数据
	List<BaseDict> list(String dict_type_code);

}
