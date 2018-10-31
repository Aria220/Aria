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
						
							<span>重置密码</span>
						
						
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
						<button type="submit" class="btn btn-primary  btn-block text-left" id="submit" style="width:65px;display:block;margin:0 auto">
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
    $(document).ready(function () {
    	jQuery.validator.addMethod("isPassword", function (value, element) {
            var length = value.length;
            var regularPassword = /^[A-Z][A-Za-z0-9]{6,18}$/;
            return this.optional(element) || (regularPassword.test(value));
        }, "密码只能包含英文字母及数字，必须以大写的英文字母开头，区分大小写");
    	
        $("#login").validate({
            rules: {
                password: {
                    required: true,
                    rangelength: [6, 18]
                },
                pwd: {
                    required: true,
                    rangelength: [6, 18],
                	isPassword: true
                },
                pword: {
                    required: true,
                    equalTo: "#pwd"
                }
            },
            messages: {
                password: {
                    required: "请输入原密码",
                    rangelength: $.validator.format("密码长度必须在 {0} 到 {1} 之间")
                },
                pwd: {
                    required: "请输入原密码",
                    rangelength: $.validator.format("密码长度必须在 {0} 到 {1} 之间"),
               		isPassWord: "密码只能包含英文字母及数字，必须以大写的英文字母开头，区分大小写"
                },
                pword: {
                    required: "请再次输入密码",
                    equalTo: "两次输入密码不一致"
                }
            },
            // errorElement: "em",
            /* 更改错误信息显示的位置 */
            errorPlacement: function (error, element) {
                // Add the `help-block` class to the error element
                error.addClass("help-block");

                if (element.prop("type") === "checkbox") {
                    error.insertAfter(element.parent("label"));
                } else {
                    error.insertAfter(element);
                }
            },
            highlight: function (element, errorClass, validClass) {
                $(element).parents(".col-sm-5").addClass("has-error").removeClass("has-success");
            },
            unhighlight: function (element, errorClass, validClass) {
                $(element).parents(".col-sm-5").addClass("has-success").removeClass("has-error");
            }
        })

    });


</script>
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
				console.log(obj.message);
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