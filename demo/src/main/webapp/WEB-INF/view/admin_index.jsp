<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="commons/head.jsp"%>
<body class="page-body">
	<div class="page-container">
		<%@ include file="admin_commons/left_menu.jsp" %>
		<div class="main-content">
			<%@ include file="admin_commons/top_menu.jsp" %>
				<div class="table-responsive" data-pattern="priority-columns" data-focus-btn-icon="fa-asterisk" data-sticky-table-header="true" data-add-display-all-btn="true" data-add-focus-btn="true">
							
								<table cellspacing="0" style="text-align:center" class="table table-small-font table-bordered table-striped">
									<thead>
										<tr>					
											<th style="text-align:center">账户ID</th>
											<th style="text-align:center">真实姓名</th>
											<th style="text-align:center">出生年月</th>
											<th style="text-align:center">性别</th>
											<th style="text-align:center">手机号码</th>
											<th style="text-align:center">手机号码</th>
											<th style="text-align:center">邮箱地址</th>
											<th style="text-align:center">学历</th>
											<th style="text-align:center">是否禁用</th>
											<th style="text-align:center">是否删除</th>
											<th style="text-align:center">创建人</th>
											<th style="text-align:center">创建时间</th>
											<th style="text-align:center">更新人</th>
											<th style="text-align:center">更新时间</th>
											<th style="text-align:center">备注</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="account" items="${accounts}">
											<tr>
												<td>${account.id}</td>
												<td>${account.realName}</td>
												<td>${account.birthday}</td>
												<td>${account.gender}</td>
												<td>${account.mobileNumber}</td>
												<td>${account.eMail}</td>
												<td>${account.address}</td>
												<c:if test="${account.education == 0}">
												<td>研究生以上</td>
												</c:if>
												<c:if test="${account.education == 1}">
												<td>研究生</td>
												</c:if>
												<c:if test="${account.education == 2}">
												<td>本科</td>
												</c:if>
												<c:if test="${account.education == 3}">
												<td>大专</td>
												</c:if>
												<c:if test="${account.education == 4}">
												<td>大专以下</td>
												</c:if>
												<c:if test="${account.state == 1}">
												<td>启用</td>
												</c:if><c:if test="${account.state == 0}">
												<td>禁用</td>
												</c:if>
												<c:if test="${account.cancel == 1}">
												<td>使用</td>
												</c:if>
												<c:if test="${account.cancel == 0}">
												<td>删除</td>
												</c:if>
												
												<td>${account.inputUser}</td>
												<td>${account.inputTime}</td>
												<td>${account.updateUser}</td>
												<td>${account.updateTime}</td>
												<td>${account.remarks}</td>					
											</tr>
										</c:forEach>	
            					</tbody>
								</table>
							
							</div>
           
				<%@ include file="admin_commons/footer.jsp"%>
		</div>
	</div>
	<%@ include file="admin_commons/js.jsp"%>
</body>
</html>