﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE><s:property value="#customer==null?'添加':'修改'" />客户</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript">
	function loadSelect(dict_type_code,postionId,selectName,selectId) {
		var $select = $("<select name="+selectName+"><select/>");
		$select.append($("<option value=''>---请选择---</option>"));
		
		$.post("${pageContext.request.contextPath }/BaseDictAction", { dict_type_code: dict_type_code},
				   function(data){
						$.each( data, function(i, json){
								var $option = $("<option value="+json["dict_id"]+">"+json["dict_item_name"]+"</option>");
							
								if(json["dict_id"]==selectId){
									$option.attr("selected","selected");
								}
								$select.append($option);
							});
				   });
		
		
				
		
		$("#"+postionId).append($select);	
	}
	$(document).ready(function(){
		loadSelect("002","cust_source_id","cust_source.dict_id","<s:property value='#customer.cust_source.dict_id' />");
		loadSelect("001","cust_industry_id","cust_industry.dict_id","<s:property value='#customer.cust_industry.dict_id' />");
		loadSelect("006","cust_level_id","cust_level.dict_id","<s:property value='#customer.cust_level.dict_id' />");
	});
</script>

<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<FORM id=form1 name=form1
		action="${pageContext.request.contextPath }/CustomerAction_add"
		method=post>
		

		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_019.jpg"
						border=0></TD>
					<TD width="100%" background="${pageContext.request.contextPath }/images/new_020.jpg"
						height=20></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_021.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15 background=${pageContext.request.contextPath }/images/new_022.jpg><IMG
						src="${pageContext.request.contextPath }/images/new_022.jpg" border=0></TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR>
								<TD class=manageHead>当前位置：客户管理 &gt; <s:property value="#customer==null?'添加':'修改'" />客户</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						
						<TABLE cellSpacing=0 cellPadding=5  border=0>
						  
						    
							<TR>
								<input type="hidden" name="cust_id" value="<s:property value='#customer.cust_id' />" />
								<td>客户名称：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="cust_name" value="<s:property value='#customer.cust_name' />" >
								</td>
								<td>客户级别 ：</td>
								<td id="cust_level_id">
								
								</td>
							</TR>
							
							<TR>
								
								<td>信息来源 ：</td>
								<td id="cust_source_id">
								
								</td>
								<td>客户所属行业</td>
								<td id="cust_industry_id">
								
								</td>
							</TR>
							
							<TR>
								
								
								<td>固定电话 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="cust_phone" value="<s:property value='#customer.cust_phone' />" >
								</td>
								<td>移动电话 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="cust_mobile" value="<s:property value='#customer.cust_mobile' />" >
								</td>
							</TR>
						
							<tr>
								<td rowspan=2>
								<INPUT class=button id=sButton2 type=submit
														value=" 保存 " name=sButton2>
								</td>
							</tr>
						</TABLE>
						
						
					</TD>
					<TD width=15 background="${pageContext.request.contextPath }/images/new_023.jpg">
					<IMG src="${pageContext.request.contextPath }/images/new_023.jpg" border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_024.jpg"
						border=0></TD>
					<TD align=middle width="100%"
						background="${pageContext.request.contextPath }/images/new_025.jpg" height=15></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_026.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
	</FORM>
</BODY>
</HTML>
