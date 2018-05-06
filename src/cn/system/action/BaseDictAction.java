package cn.system.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.system.domain.BaseDict;
import cn.system.service.BaseDictService;
import net.sf.json.JSONArray;

public class BaseDictAction extends ActionSupport {
	private String dict_type_code;
	private BaseDictService bds;
	@Override
	public String execute() throws Exception {
		List<BaseDict> list = bds.list(dict_type_code);
		JSONArray json = JSONArray.fromObject(list);
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().print(json);
		//返回值为空指action对此返回值不做处理
		return null;
	}
	
	public String getDict_type_code() {
		return dict_type_code;
	}
	public void setDict_type_code(String dict_type_code) {
		this.dict_type_code = dict_type_code;
	}

	public void setBds(BaseDictService bds) {
		this.bds = bds;
	}
	
}
