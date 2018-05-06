<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>客户列表</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/myJs.js"></script>

<script type="text/javascript">
	function selectOK(cust_id,cust_name) {
		window.opener.document.getElementById("custIdInput").value=cust_id;
		window.opener.document.getElementById("custNameInput").value=cust_name;
		window.close();	
	}
</script>

<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>	
		
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
								<TD class=manageHead>当前位置：客户管理 &gt; 客户列表</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						<TABLE borderColor=#cccccc cellSpacing=0 cellPadding=0
							width="100%" align=center border=0>
							<TBODY>
								<TR>
									<TD height=25>
									<FORM id="customerForm" name="customerForm"
										action="${pageContext.request.contextPath }/CustomerAction_list"
										method=post>
										<TABLE cellSpacing=0 cellPadding=2 border=0>
											<TBODY>
												<TR>
													<TD>客户名称：</TD>
													
													<TD><INPUT class=textbox id=sChannel2
														style="WIDTH: 80px" maxLength=50 name="cust_name"></TD>
														<input id="currentPage" type="hidden" name="currentPage"/>
														<input id="pageRecord" type="hidden" name="pageRecord"/>
														<input type="hidden" name="select" value="<s:property value="#parameters.select"/>" />
													<TD><INPUT class=button id=sButton2 type=submit
														value=" 筛选 " name=sButton2></TD>
												</TR>
											</TBODY>
										</TABLE>
									</FORM>
									</TD>
								</TR>
							    
								<TR>
									<TD>
										<TABLE id=grid
											style="BORDER-TOP-WIDTH: 0px; FONT-WEIGHT: normal; BORDER-LEFT-WIDTH: 0px; BORDER-LEFT-COLOR: #cccccc; BORDER-BOTTOM-WIDTH: 0px; BORDER-BOTTOM-COLOR: #cccccc; WIDTH: 100%; BORDER-TOP-COLOR: #cccccc; FONT-STYLE: normal; BACKGROUND-COLOR: #cccccc; BORDER-RIGHT-WIDTH: 0px; TEXT-DECORATION: none; BORDER-RIGHT-COLOR: #cccccc"
											cellSpacing=1 cellPadding=2 rules=all border=0>
											<TBODY>
												<TR
													style="FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
													<TD>客户名称</TD>
													<TD>客户级别</TD>
													<TD>客户来源</TD>
													<TD>客户所属行业</TD>
													<TD>电话</TD>
													<TD>手机</TD>
													<TD>操作</TD>											
												
												<s:iterator value="#page.list" var="customer">
												<TR
													style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
													
													<TD><s:property value="#customer.cust_name"/></TD>
													<TD><s:property value="#customer.cust_level.dict_item_name"/></TD>
													<TD><s:property value="#customer.cust_source.dict_item_name"/></TD>
													<TD><s:property value="#customer.cust_industry.dict_item_name"/></TD>
													<TD><s:property value="#customer.cust_phone"/></TD>
													<TD><s:property value="#customer.cust_mobile"/></TD>
													<s:if test="#parameters.select" >
														<td>
															<input type="button" value="选择" onclick="selectOK('<s:property value="#customer.cust_id" />','<s:property value="#customer.cust_name" />')" />
														</td>
													</s:if>
													<s:else>
														<TD>
														<a href="${pageContext.request.contextPath }/CustomerAction_toEdit?cust_id=<s:property value='#customer.cust_id'/>">修改</a>
														&nbsp;&nbsp;
														<a href="${pageContext.request.contextPath }/CustomerAction_delete">删除</a>
														</TD>
													</s:else>
												</TR>
												</s:iterator>
											</TBODY>
										</TABLE>
									</TD>
								</TR>
								
								<TR>
									<TD><SPAN id=pagelink>
											<DIV
												style="LINE-HEIGHT: 20px; HEIGHT: 20px; TEXT-ALIGN: right">
												共[<B><s:property value="#page.recordSize" /></B>]条记录,[<B><s:property value="#page.pageSize" /></B>]页
												,每页显示
												<select id="pageSize" name="pageSize" onchange="changePage($('#page').val(),$(this).val())">
												
												<option value="3" <s:property value="#page.pageRecord==3?'selected':''" /> >3</option>
												<option value="5" <s:property value="#page.pageRecord==5?'selected':''" /> >5</option>
												</select>
												条
												[<A href="javaScript:void(0)" onclick="changePage(${page.currentPage}-1,$('#pageSize').val())">前一页</A>]
												
												[<A href="javaScript:void(0)" onclick="changePage(${page.currentPage}+1,$('#pageSize').val())">后一页</A>] 
												到
												<input type="text" size="3" id="page" value=<s:property value="#page.currentPage" /> />
												页
												
												<input type="button" value="Go" onclick="changePage($('#page').val(),$('#pageSize').val())"/>
											</DIV>
									</SPAN></TD>
								</TR>
							</TBODY>
						</TABLE>
					</TD>
					<TD width=15 background="${pageContext.request.contextPath }/images/new_023.jpg"><IMG
						src="${pageContext.request.contextPath }/images/new_023.jpg" border=0></TD>
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
		<s:debug></s:debug>
</BODY>
</HTML>
