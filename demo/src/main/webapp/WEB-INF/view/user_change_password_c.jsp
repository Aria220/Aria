<%--
  Created by IntelliJ IDEA.
  User: cloud0072
  Date: 2018/10/28
  Time: 17:00
  To change this template use File | Settings | File Templates.
  修改密码页面
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<%@ include file="commons/head.jsp" %>
<body class="page-body">

<div class="page-container">

    <div class="sidebar-menu toggle-others fixed">

        <div class="sidebar-menu-inner">

            <%@ include file="commons/left_menu.jsp" %>

        </div>

    </div>

    <div class="main-content">

        <%@ include file="commons/top_menu.jsp" %>

        <%--页面标题 begin--%>
        <div class="page-title">

            <div class="title-env">
                <h1 class="title">修改密码</h1>
            </div>

            <div class="breadcrumb-env">

                <ol class="breadcrumb bc-1">
                    <li>
                        <a href="${ctx}/user/changePassword"><i class="fa-home"></i>个人设置</a>
                    </li>
                    <li class="active">

                        <strong>修改密码</strong>
                    </li>
                </ol>

            </div>

        </div>
        <%--页面标题 end--%>

        <%--修改密码 begin--%>
        <div class="row">
            <div class="col-sm-12">

                <div class="panel panel-default">

                    <div class="panel-heading">
                        <h3 class="panel-title">修改密码</h3>
                        <div class="panel-options">
                            <a href="#" data-toggle="panel">
                                <span class="collapse-icon">&ndash;</span>
                                <span class="expand-icon">+</span>
                            </a>
                            <a href="#" data-toggle="remove">
                                &times;
                            </a>
                        </div>
                    </div>

                    <div class="panel-body">

                        <form action="${ctx}/user/handle_change_password" method="post" role="form" class="form-horizontal" id="main_form" >
                            <input type="hidden" name="doChange" value="true">

                            <div class="form-group">
                                <label class="col-sm-2 control-label" for="password">原密码</label>

                                <div class="col-sm-10">
                                    <input type="password" class="form-control" id="password" name="password"
                                           placeholder="原密码">
                                </div>
                            </div>

                            <div class="form-group-separator"></div>

                            <div class="form-group">
                                <label class="col-sm-2 control-label" for="newPassword">新密码</label>

                                <div class="col-sm-10">
                                    <input type="password" class="form-control" id="newPassword" name="newPassword"
                                           placeholder="新密码">
                                </div>
                            </div>

                            <div class="form-group-separator"></div>

                            <div class="form-group">
                                <label class="col-sm-2 control-label" for="newPasswordCheck">确认密码</label>

                                <div class="col-sm-10">
                                    <input type="password" class="form-control" id="newPasswordCheck" name="newPasswordCheck"
                                           placeholder="确认密码">
                                </div>
                            </div>

                            <button class="btn btn-info btn-icon center-block">
                                <span>提交</span>
                            </button>
                        </form>

                    </div>
                </div>

            </div>
        </div>
        <%--修改密码 end--%>

        <%@ include file="commons/footer.jsp" %>

    </div>

</div>

<div class="page-loading-overlay">
    <div class="loader-2"></div>
</div>

<%@ include file="commons/js.jsp" %>
<script type="text/javascript">
    $(document).ready(function () {
        $("#main_form").validate({
            rules: {
                password: {
                    required: true,
                    rangelength: [5, 20]
                },
                newPassword: {
                    required: true,
                    rangelength: [5, 20]
                },
                newPasswordCheck: {
                    required: true,
                    equalTo: "#newPassword"
                }
            },
            messages: {
                password: {
                    required: "请输入原密码",
                    rangelength: $.validator.format("密码长度必须在 {0} 到 {1} 之间")
                },
                newPassword: {
                    required: "请输入原密码",
                    rangelength: $.validator.format("密码长度必须在 {0} 到 {1} 之间")
                },
                newPasswordCheck: {
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
</body>
</html>
