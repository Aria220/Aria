<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="commons/head.jsp"%>
<body class="page-body">
	<div class="page-container">
		<%@ include file="commons/left_menu.jsp" %>
		<div class="main-content">
			<%@ include file="commons/top_menu.jsp" %>
			 <div>
			<p>个人信息</p>
			
                <span class="">真实姓名：</span>
                <span class="">${account.realName} </span>
                <input name="username" id="username" class="ed_username" value="" style="display: none;"/>
            
                <span class="">出生年月：</span>
                <span class="">${account.birthday} </span>
                <input name="birthday" id="birthday" class="ed_username" value="" style="display: none;"/>
            
                <span class="">性别：</span>
                <c:if test="${account.gender == 1}">
                	<span class="">男</span>
                	<!-- <input type="radio" name="gender" value="1" checked="checked"/>男
                	<input type="radio" name="gender" value="0"/>女 -->
                </c:if>
                <c:if test="${account.gender == 0}">
                	<span class="">女</span>
                  	<!-- <input type="radio" name="gender" value="1"/>男
                   	<input type="radio" name="gender" value="0" checked="checked"/>女 -->
                </c:if>
                     
                <span class="">学历：</span>
                <c:if test="${account.education == 0}">
                	<span class="">研究生以上</span>
                </c:if>
                <c:if test="${account.education == 1}">
                  	<span class="">研究生 </span>
                </c:if>
                <c:if test="${account.education == 2}">
                	<span class="">本科 </span>
                </c:if>
                <c:if test="${account.education == 3}">
                  	<span class="">大专 </span>
                </c:if>
                <c:if test="${account.education == 4}">
                	<span class="">大专以下 </span>
                </c:if>
                      
                <span class="">手机号码：</span>
                <span class="">${account.mobileNumber} </span>
                <input name="phone" id="phone" class="ed_username" value="" style="display: none;"/>
           
                <span class="">邮箱地址：</span>
                <span class="">${account.eMail} </span>
                <input name="email" id="email" class="ed_username" value="" style="display: none;"/>
           
                <span class="">联系地址：</span>
                <span class="">${account.address} </span>
                <input name="address" id="address" class="ed_username" value="" style="display: none;"/>
            </div> 
            <div class="panel-heading">
							<h3 class="panel-title" >个人履历</h3>
							
            				<div class="panel-options">
									<button class="btn btn-info">编辑</button>						
							</div>
			</div>
            <hr style="background-color:black;height:1px">
            <div class="table-responsive" data-pattern="priority-columns" data-focus-btn-icon="fa-asterisk" data-sticky-table-header="true" data-add-display-all-btn="true" data-add-focus-btn="true">
							
								<table cellspacing="0" style="text-align:center" class="table table-small-font table-bordered table-striped">
									<thead>
										<tr>					
											<th style="text-align:center">公司名称</th>
											<th style="text-align:center">部门</th>
											<th style="text-align:center">职位</th>
											<th style="text-align:center">入职日期</th>
											<th style="text-align:center">离职日期</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="curriculumVitae" items="${curriculumVitaes}">
											<tr>
												<td>${curriculumVitae.company}</td>
												<td>${curriculumVitae.department}</td>
												<td>${curriculumVitae.position}</td>
												<td>${curriculumVitae.hireDate}</td>
												<td>${curriculumVitae.leaveDate}</td>				
											</tr>
										</c:forEach>	
            					</tbody>
								</table>
							
							</div>
            					
            
			
				<%@ include file="commons/footer.jsp"%>
		</div>
	</div>
	<%@ include file="commons/js.jsp"%>
</body>
</html>