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
			<div style="width:300px;height:400px">
				<form method="post" role="form" id="login" >
					
					<div class="login-header">
						<a href="dashboard-1.html" class="logo">
							<img src="assets/images/logo-white-bg@2x.png" alt="" width="80" />
							<span>重置密码</span>
						</a>
						
						<p>Reset Password</p>
					</div>
	

					<div class="form-group">
						<label class="control-label" for="passwd">原密码:</label>
						<input type="password" class="form-control" name="password" id="password" autocomplete="off" />
					</div>
					<div class="form-group">
						<label class="control-label" for="passwd">新密码:</label>
						<input type="password" class="form-control" name="pwd" id="pwd" autocomplete="off" />
					</div>
					<div class="form-group">
						<label class="control-label" for="passwd">确认新密码:</label>
						<input type="password" class="form-control" name="pword" id="pword" autocomplete="off" />
					</div>
					
					<div class="form-group">
						<button type="submit" class="btn btn-primary  btn-block text-left" id="submit">
							<i class="fa-lock"></i>
							确定
						</button>
					</div>				
				</form>
				</div>
			
				<%@ include file="commons/footer.jsp"%>
		</div>
	</div>
	<%@ include file="commons/js.jsp"%>
	<script type="text/javascript">
	$("#submit").click(function(){
	  	var url = "handle_change_password";
	  	var password = $("#password").val();
	  	var newPassword = $("#pwd").val();
	  	//提交的数据
	  	var data = "password="+password+"&newPassword="+newPassword;
	  	//输出
	  	console.log("提交的数据:"+data)
		//提交ajax请求并处理结果
		$.ajax({
			"url":url,
			"data":data,
			"type":"POST",
			"dataType":"json",
			"success":function(obj){
				if(obj.message){
					alert(obj.message)
				} 
				if(obj.url){
					location.href = obj.url;
				}			
			}
		})
    });
	
		
	</script>
</body>
</html>