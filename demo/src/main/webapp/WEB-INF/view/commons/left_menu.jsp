<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div class="sidebar-menu toggle-others fixed">

			<div class="sidebar-menu-inner">

				<header class="logo-env"> <!-- logo -->
				<div class="logo">
					<a href="dashboard-1.html" class="logo-expanded"> <img
						src="${ctx}/assets/images/logo@2x.png" width="80" alt="" />
					</a> <a href="dashboard-1.html" class="logo-collapsed"> <img
						src="${ctx}/assets/images/logo-collapsed@2x.png" width="40" alt="" />
					</a>
				</div>

				<!-- This will toggle the mobile menu and will be visible only on mobile devices -->
				<div class="mobile-menu-toggle visible-xs">
					<a href="#" data-toggle="user-info-menu"> <i class="fa-bell-o"></i>
						<span class="badge badge-success">7</span>
					</a> <a href="#" data-toggle="mobile-menu"> <i class="fa-bars"></i>
					</a>
				</div>

				<!-- This will open the popup with user profile settings, you can use for any purpose, just be creative -->
				<div class="settings-icon">
					<a href="#" data-toggle="settings-pane" data-animate="true"> <i
						class="linecons-cog"></i>
					</a>
				</div>


				</header>
			<%-- 主菜单 --%>
<ul id="main-menu" class="main-menu">

    <li class="">
        <a href="#">
            <i class="linecons-user"></i>
            <span class="title">个人中心</span>
        </a>
        <ul>
            <li>
                <a href="${ctx}/main/index">
                    <span class="title">个人信息</span>
                </a>
            </li>

        </ul>
    </li>
    <li class="">
        <a href="#">
            <i class="linecons-cog"></i>
            <span class="title">个人设置</span>
        </a>
        <ul>
            <li>
                <a href="${ctx}/user/binding">
                    <span class="title">绑定用户</span>
                </a>
            </li>
            <li>
                <a href="${ctx}/user/change_password">
                    <span class="title">修改密码</span>
                </a>
            </li>

        </ul>
    </li>

</ul>

			</div>

		</div>
