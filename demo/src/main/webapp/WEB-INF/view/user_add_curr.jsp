<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="commons/head.jsp"%>
<body class="page-body">
	<div class="page-container">
		<%@ include file="commons/left_menu.jsp"%>
		<div class="main-content">
			<%@ include file="commons/top_menu.jsp"%>
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">个人简历</h3>
					<div class="panel-options">
						<a href="#" data-toggle="panel"> <span class="collapse-icon">&ndash;</span>
							<span class="expand-icon">+</span>
						</a> <a href="#" data-toggle="remove"> &times; </a>
					</div>
				</div>
				<div class="panel-body">

					<form role="form" class="form-horizontal" id="curr-form" action="add_curr" method="post">

						<div class="form-group">
							<label class="col-sm-2 control-label" for="company">公司名称:</label>

							<div class="col-sm-10">
								<input type="text" class="form-control" id="company" name="company"
									placeholder="公司 ">
							</div>
						</div>

						<div class="form-group-separator"></div>
						<div class="form-group">
							<label class="col-sm-2 control-label" for="department">部门:</label>

							<div class="col-sm-10">
								<input type="text" class="form-control" id="department" name="department"
									placeholder="部门 ">
							</div>
						</div>

						<div class="form-group-separator"></div>
						<div class="form-group">
							<label class="col-sm-2 control-label" for="position">职位:</label>

							<div class="col-sm-10">
								<input type="text" class="form-control" id="position" name="position"
									placeholder="职位 ">
							</div>
						</div>

						<div class="form-group-separator"></div>
						<div class="form-group">
							<label class="col-sm-2 control-label" for="hireDate">入职时间:</label>

							<div class="col-sm-10">
								<input type="date" class="form-control" id="hireDate" name="hireDate"
									placeholder="入职时间">
							</div>
						</div>

						<div class="form-group-separator"></div>
						<div class="form-group">
							<label class="col-sm-2 control-label" for="leaveDate">离职日期:</label>
							<div class="col-sm-10">		
								<input type="date" class="form-control" id="leaveDate"
									name="leaveDate" placeholder="离职日期 ">
							</div> 
						</div>

						<div class="form-group-separator"></div>
						<div class="panel-options" style="margin:0 auto;">
							<button class="btn btn-info" >保存</button>
						</div>
						
<!-- 					
						<div class="form-group">
							<label class="col-sm-2 control-label" for="field-2">Password</label>

							<div class="col-sm-10">
								<input type="password" class="form-control" id="field-2"
									placeholder="Placeholder (Password)">
							</div>
						</div>

						<div class="form-group-separator"></div>

						<div class="form-group">
							<label class="col-sm-2 control-label">Disabled input</label>

							<div class="col-sm-10">
								<input type="text" class="form-control"
									placeholder="Placeholder" disabled>
							</div>
						</div>

						<div class="form-group-separator"></div>
 -->
						
						<!-- div class="form-group">
									<label class="col-sm-2 control-label" for="field-3">Email field</label>
									
									<div class="col-sm-10">
										<input type="email" class="form-control" id="field-3" placeholder="Enter your email&hellip;">
										<p class="help-block">Example block-level help text here. Emails inputs are validated on native HTML5 forms.</p>
									</div>
								</div> -->


					</form>

				</div>
			</div>

			<%@ include file="commons/footer.jsp"%>
		</div>
	</div>
	<%@ include file="commons/js.jsp"%>
	<!-- <script type="text/javascript">
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

    }); -->


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