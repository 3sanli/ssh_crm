package cn.system.service.impl;

import java.util.List;

import cn.system.dao.BaseDictDao;
import cn.system.domain.BaseDict;
import cn.system.service.BaseDictService;

public class BaseDictServiceImpl implements BaseDictService {
	private BaseDictDao bdd;
	@Override
	public List<BaseDict> list(String dict_type_code) {
		List<BaseDict> list = bdd.getByTypeCode(dict_type_code);
		return list;
	}
	public void setBdd(BaseDictDao bdd) {
		this.bdd = bdd;
	}

}
