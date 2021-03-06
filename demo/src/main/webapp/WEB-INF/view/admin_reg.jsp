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
							src="${ctx}/assets/images/logo@2x.png" alt="" width="80" /> <span>reg
								in</span>
						</a>

						<p>Dear user, reg in to access the admin area!</p>
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
						<label for="pwd">确认密码：</label> 
						<input type="password" class="form-control input-dark" name="pwd"
							id="pwd" autocomplete="off" placeholder="请再次输入密码："/>
					</div>
					<div class="form-group">
						<label for="verification_code">验证码：</label> 
						<input type="text" class="form-control input-dark" name="verification_code"
							id="verification_code" autocomplete="off" placeholder="请输入验证码："/>
					</div>
					
					
					<div class="form-group">
						<button type="button" class="btn btn-dark  btn-block text-left" id="submit">
							<i class="fa-lock"></i> 确定
						</button>
					</div>

					<div class="login-footer">
						<a href="#">已有账户,返回登录</a>
					</div>

				</form>

				
				

			</div>

		</div>
	
	</div>
	<script type="text/javascript">
	$("#submit").click(function(){
	  	var url = "handle_reg";
	  	var formData = new FormData($("#login")[0]);
	  	//输出
	  	console.log("提交的数据:"+formData)
		//提交ajax请求并处理结果
		$.ajax({
			"url":url,
			"data":formData,
			"type":"POST",
			"dataType":"json",
			"processData":false,
			"contentType":false,
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
	<%@ include file="commons/js.jsp"%>
</body>
</html>