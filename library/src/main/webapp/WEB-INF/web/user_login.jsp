<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<%@ include file="commons/head.jsp"%>
<body class="page-body login-page">


	<div class="login-container">

		<div class="row">

			<div class="col-sm-6">



				<!-- Errors container -->
				<div class="errors-container"></div>

				<!-- Add class "fade-in-effect" for login form effect -->
				<form method="post" role="form" id="login" class="login-form" >

					<div class="login-header">
						<a href="dashboard-1.html" class="logo"> <img
							src="${ctx}/assets/images/logo@2x.png" alt="" width="80" /> <span>log
								in</span>
						</a>

						<p>Dear user, log in to access the admin area!</p>
					</div>


					<div class="form-group">
						<label for="username">用户名：</label> 
						<input type="text" class="form-control input-dark" name="username"
							id="username" autocomplete="off" placeholder="请输入用户名："/>
					</div>

					<div class="form-group">
						<label for="password">密码：</label> 
						<input type="password" class="form-control input-dark" name="password"
							id="password" autocomplete="off" placeholder="请输入密码："/>
					</div>

					<div class="form-group">
						<button type="button" class="btn btn-dark  btn-block text-left" id="submit">
							<i class="fa-lock"></i> 登录
						</button>
					</div>

					<div class="login-footer">
						<a href="#">忘记密码？</a>
					</div>

				</form>

				
				

			</div>

		</div>
	
	</div>
	<script type="text/javascript">
	$("#submit").click(function(){
	  	var url = "handle_login";
	  	var username = $("#username").val();
	  	var password = $("#password").val();
	  	//提交的数据
	  	var data = "username="+username+"&password="+password;
	  	//输出
	  	console.log("提交的数据:"+data)
		//提交ajax请求并处理结果
		$.ajax({
			"url":url,
			"data":data,
			"type":"POST",
			"dataType":"json",
			"success":function(obj){
				if(obj.state == 1){
					alert("登录成功!")
				} else {
					alert("登录失败!"+obj.message);
				}			
			}
		})
    });
	
	</script>
	<%@ include file="commons/js.jsp"%>
</body>
</html>