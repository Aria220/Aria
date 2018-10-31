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
			<%--个人信息 begin--%>
			<div class="row">
				<div class="col-sm-12">

					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">个人信息</h3>
							<div class="panel-options">
								<button class="btn btn-info" id="user-info-edit">编辑</button>
								<button class="btn btn-secondary" id="user-info-save"
									style="display: none">保存</button>
							</div>
						</div>
						<div class="panel-body">

							<form action="${ctx}/account/change_info" id="user-info-form"
								method="post">
								<div class="row col-margin user-info">

									<div class="col-xs-3">
										<label for="realName">真实姓名:</label> <input type="text"
											class="form-control" id="realName" name="realName"
											value="${account.realName}" />
									</div>

									<div class="col-xs-3">
										<label for="birthday">出生年月:</label> <input type="text"
											class="form-control" id="birthday" name="birthday"
											value="${account.birthday}" placeholder="yyyyMM" />
									</div>

									<div class="col-xs-3">
										<label for="gender">性别:</label> <select type="text"
											class="form-control" id="gender" name="gender">
											<%-- <option value="null" ${account.gender==null?"selected":""}>保密</option> --%>
											<option value="0" ${account.gender==0?"selected":""}>女</option>
											<option value="1" ${account.gender==1?"selected":""}>男</option>
										</select>
									</div>

									<div class="col-xs-3">
										<label for="education">学历:</label> <select type="text"
											class="form-control" id="education" name="education">
											<%-- <option value="null" ${account.education==null?"selected":""}>保密</option> --%>
											<option value="0" ${account.education==0?"selected":""}>研究生以上</option>
											<option value="1" ${account.education==1?"selected":""}>研究生</option>
											<option value="2" ${account.education==2?"selected":""}>本科生</option>
											<option value="3" ${account.education==3?"selected":""}>大专</option>
											<option value="4" ${account.education==4?"selected":""}>大专以下</option>
										</select>
									</div>

									<div class="col-xs-3">
										<label for="mobileNumber">手机号码:</label> <input type="text"
											class="form-control" id="mobileNumber" name="mobileNumber"
											value="${account.mobileNumber}" />
									</div>

									<div class="col-xs-3">
										<label for="eMail">邮箱地址:</label> <input type="text"
											class="form-control" id="eMail" name="eMail"
											value="${account.eMail}" />
									</div>

									<div class="col-xs-6">
										<label for="address">联系地址:</label> <input type="text"
											class="form-control" id="address" name="address"
											value="${account.address}" />
									</div>

								</div>
							</form>

						</div>
					</div>

				</div>
			</div>
			<div class="panel panel-default">

				<div class="panel-heading">
					<h3 class="panel-title">个人履历</h3>
					<div class="panel-options">
						<button class="btn btn-info" onclick="location.href='${ctx}/curr/add_info'">添加</button>
					</div>
				</div>
				<hr style="background-color: black; height: 1px">
				<div class="table-responsive" data-pattern="priority-columns"
					data-focus-btn-icon="fa-asterisk" data-sticky-table-header="true"
					data-add-display-all-btn="true" data-add-focus-btn="true">

					<table cellspacing="0" style="text-align: center"
						class="table table-small-font table-bordered table-striped">
						<thead>
							<tr>
								<th style="text-align: center">公司名称</th>
								<th style="text-align: center">部门</th>
								<th style="text-align: center">职位</th>
								<th style="text-align: center">入职日期</th>
								<th style="text-align: center">离职日期</th>
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

			</div>

			<%@ include file="commons/footer.jsp"%>
		</div>
	</div>
	<%@ include file="commons/js.jsp"%>
	<script type="text/javascript">
	$(document).ready(function () {
        jQuery.validator.addMethod("isBirthday", function (value, element) {
            var length = value.length;
            var regularBirthday = /^[0-9]{6}$/;
            return this.optional(element) || (regularBirthday.test(value));
        }, "请输入正确的生日,格式yyyyMM,例:199012");
		
        jQuery.validator.addMethod("isMobileNumber", function (value, element) {
            var length = value.length;
            var regularMobileNumber = /^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$/;
            return this.optional(element) || (regularMobileNumber.test(value));
        }, "请输入正确的手机号码");
        
        jQuery.validator.addMethod("iseMail", function (value, element) {
            var length = value.length;
            var regulareMail = /^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$/;
            return this.optional(element) || (regulareMail.test(value));
        }, "请输入正确的邮箱地址");
        
        $("#user-info-form").validate({
            rules: {
                realName: {
                    required: true,
                    rangelength: [0, 20],     
                },
                birthday: {
                    required: true,
                    isBirthday: true
                },
                mobileNumber: {
                    required: true,
                    isMobileNumber: true
                },
                eMail: {
                	required: true,
                	iseMail: true
                },
                address: {
                	required: true,
                	rangelength: [0,100]
                }
            },
            messages: {
                realName: {
                    required: "请输入用户名",
                    rangelength: $.validator.format("用户名长度必须在 {0} 到 {1} 之间"),
                },
                birthday: {
                    required: "请输入生日",
                    isBirthday: "请输入正确的生日,格式yyyyMM,例:199012"
                },
                mobileNumber: {
                    required: "请输入手机号码",
                   	isMobileNumber:"请输入正确的手机号码"
                },
                eMail: {
                	required: "请输入邮箱",
                	iseMail: "请输入正确的邮箱地址"
                },
                address: {
                	required: "请输入地址",
                	rangelength:"长度必须在{0}到{1}之间"
                	
                }
                
            },
            //errorElement: "em",
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
	})
	
    $(function () {
        $(".user-info>div>input").attr("disabled", "disabled");
        $(".user-info>div>select").attr("disabled", "disabled");

        $("#user-info-edit").on("click", function () {
            $(".user-info>div>input").removeAttrs("disabled");
            $(".user-info>div>select").removeAttrs("disabled");
            $("#user-info-edit").hide();
            $("#user-info-save").show();
        });

        $("#user-info-save").on("click", function () {
            console.log($("#user-info-form").serialize());
            $("#user-info-form").submit();
        });
		
    });


</script>
</body>
</html>