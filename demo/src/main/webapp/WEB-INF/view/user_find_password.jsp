<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
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

						<p>重置密码</p>
						<hr>
					<input type="radio" value="0" id="radio_phone" name="radio" checked="checked">使用手机号
					<input type="radio" value="1" id="radio_email" name="radio" >使用邮箱
					</div>
					
					
					<c:if test=""></c:if>
					<div class="form-group">
						<label for="phone">手机号码：</label> 
						<input type="text" class="form-control input-dark" name="phone"
							id="phone" autocomplete="off" placeholder="请输入手机号码：" readonly="readonly" onmouseover="this.readOnly=false"/>
					</div>

					<div class="form-group">
						<label for="password">验证码：</label> 
						<input type="text" class="form-control input-dark" name="code"
							id="code" autocomplete="off" placeholder="请输入密码：" readonly="readonly" onmouseover="this.readOnly=false"/>
					</div>

					<div class="form-group">
						<button type="button" class="btn btn-dark  btn-block text-left" id="next">
							<i class="fa-lock"></i> 下一步
						</button>
					</div>

				

				</form>

				
				

			</div>

		</div>
	
	</div>
	<script type="text/javascript">
	$("#submit").click(function(){
	  	var url = "handle_login";
	  	var userName = $("#username").val();
	  	var password = $("#password").val();
	  	//提交的数据
	  	var data = "userName="+userName+"&password="+password;
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
	<%@ include file="commons/js.jsp"%>
</body>
</html>