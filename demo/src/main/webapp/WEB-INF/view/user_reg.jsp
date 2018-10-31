<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<%@ include file="commons/head.jsp" %>
<body class="page-body login-page">


<div class="login-container">

    <div class="row">

        <div class="col-sm-6">


            <!-- Errors container -->
            <div class="errors-container"></div>

            <!-- Add class "fade-in-effect" for login form effect -->
            <form method="post" role="form" id="login" class="login-form">

                <div class="login-header">
                    <a href="#" class="logo"> <img
                            src="${ctx}/assets/images/logo@2x.png" alt="" width="80"/> <span>reg
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
					<label for="captcha">验证码：</label>
					<input type="text" class="form-control input-dark" name="captcha"
						   id="captcha" autocomplete="off" placeholder="验证码"/>
				</div>
				
				<div class="form-group">
					<img src="${ctx}/user/captcha" onclick="this.src='${ctx}/user/captcha?time='+Math.random()">
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
<%@ include file="commons/js.jsp" %>
<script type="text/javascript">

    $(document).ready(function () {
        jQuery.validator.addMethod("isUserName", function (value, element) {
            var length = value.length;
            var regularUserName = /^[A-Za-z][A-Za-z0-9_]{5,15}$/;
            return this.optional(element) || (regularUserName.test(value));
        }, "用户名只能包含英文字母、数字及“_”，必须以英文字母开头，区分大小写");
		
        jQuery.validator.addMethod("isPassword", function (value, element) {
            var length = value.length;
            var regularPassword = /^[A-Z][A-Za-z0-9]{6,18}$/;
            return this.optional(element) || (regularPassword.test(value));
        }, "密码只能包含英文字母及数字，必须以大写的英文字母开头，区分大小写");
        
        $("#login").validate({
            rules: {
                username: {
                    required: true,
                    rangelength: [5, 15],
                    isUserName: true
                },
                password: {
                    required: true,
                    rangelength: [6, 18],
                    isPassword: true
                },
                pwd: {
                    required: true,
                    equalTo: "#password"
                },
                captcha: {
                	required: true
                }
            },
            messages: {
                username: {
                    required: "请输入用户名",
                    rangelength: $.validator.format("用户名长度必须在 {0} 到 {1} 之间"),
                    isUserName:"用户名只能包含英文字母、数字及“_”，必须以英文字母开头，区分大小写"
                },
                password: {
                    required: "请输入密码",
                    rangelength: $.validator.format("密码长度必须在 {0} 到 {1} 之间"),
                    isPassword: "密码只能包含英文字母及数字，必须以大写的英文字母开头，区分大小写"
                },
                pwd: {
                    required: "请再次输入密码",
                    equalTo: "两次输入的密码不一致"
                },
                captcha: {
                	required: "请输入验证码"
                }
                
            },
            errorElement: "em",
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
		
        /* $("body").keydown(function() {
             if (event.keyCode == "13") {//keyCode=回车键
                 $("#submit").click();
             }
         }) */

        	$("#submit").click(function () {
	        	if($("#login").valid()){
	                var url = "handle_reg";
	                /* var formData = new FormData($("#login")[0]); */
	                var userName = $("#username").val();
	                var password = $("#password").val();
	                var captcha = $("#captcha").val();
	                var data = "userName=" + userName + "&password=" + password+"&captcha="+captcha;
	                //输出
	                console.log("提交的数据:" + data)
	                //提交ajax请求并处理结果
	                $.ajax({
	                    "url": url,
	                    "data": data,
	                    "type": "POST",
	                    "dataType": "json",
	                    /* "processData":false,
	                    "contentType":false, */
	                    "success": function (obj) {
	                        if (obj.message) {
	                            alert(obj.message)
	                        }
	                        if (obj.url) {
	                            location.href = obj.url;
	                        }
	                    }
	                })
	        	} else {
	            	alert("请填入正确的信息!")
	            }
            });
        	
        
        
        
    });
</script>

</body>
</html>