<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="commons/head.jsp"%>
<body class="page-body">
	<!-- <div class="copyrights">Collect from <a href="http://www.cssmoban.com/"  title="网站模板">网站模板</a></div> -->
	<div class="page-container">
		<!-- add class "sidebar-collapsed" to close sidebar by default, "chat-visible" to make chat appear always -->

		<!-- Add "fixed" class to make the sidebar fixed always to the browser viewport. -->
		<!-- Adding class "toggle-others" will keep only one menu item open at a time. -->
		<!-- Adding class "collapsed" collapse sidebar root elements and show only icons. -->
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


				<c:forEach var="menu1" items="${menus}">
				
					<li class="${menu1.active}">
						<a href="${menu1.href}">
						<i class="${menu1.icons}"></i>
						<span class="title">${menu1.title}</span>
						</a>
					</li>
					
					<c:if var="menu2" test="${menu2.children!=null}">
					
						<c:forEach var="menu2" items="${menu1.children}">
							<li class="${menu2.active}">
								<a href="${menu2.href}">
								<i class="${menu2.icons}"></i>
								<span class="title">${menu2.title}</span>
								</a>
							</li>
						</c:forEach>
						
					</c:if>
				</c:forEach>
				<ul id="main-menu" class="main-menu">
					<!-- add class "multiple-expanded" to allow multiple submenus to open -->
					<!-- class "auto-inherit-active-class" will automatically add "active" class for parent elements who are marked already with class "active" -->
					<li class="active opened active"><a href="dashboard-1.html">
							<i class="linecons-cog"></i> <span class="title">个人资料设置</span>
					</a>
						<ul>
							<li class="active"><a href="dashboard-1.html"> <span
									class="title">修改个人信息</span>
							</a></li>
							<li><a href="dashboard-2.html"> <span class="title">修改密码
										</span>
							</a></li>
							<li><a href="dashboard-3.html"> <span class="title">Dashboard
										3</span>
							</a></li>
							<li><a href="dashboard-4.html"> <span class="title">Dashboard
										4</span>
							</a></li>
							<li><a href="skin-generator.html"> <span class="title">Skin
										Generator</span>
							</a></li>
						</ul></li>
					<li><a href="layout-variants.html"> <i
							class="linecons-desktop"></i> <span class="title">Layouts</span>
					</a>
						<ul>
							<li><a href="layout-variants.html"> <span class="title">Layout
										Variants &amp; API</span>
							</a></li>
							<li><a href="layout-collapsed-sidebar.html"> <span
									class="title">Collapsed Sidebar</span>
							</a></li>
							<li><a href="layout-static-sidebar.html"> <span
									class="title">Static Sidebar</span>
							</a></li>
							<li><a href="layout-horizontal-menu.html"> <span
									class="title">Horizontal Menu</span>
							</a></li>
							<li><a href="layout-horizontal-plus-sidebar.html"> <span
									class="title">Horizontal &amp; Sidebar Menu</span>
							</a></li>
							<li><a href="layout-horizontal-menu-click-to-open-subs.html">
									<span class="title">Horizontal Open On Click</span>
							</a></li>
							<li><a href="layout-horizontal-menu-min.html"> <span
									class="title">Horizontal Menu Minimal</span>
							</a></li>
							<li><a href="layout-right-sidebar.html"> <span
									class="title">Right Sidebar</span>
							</a></li>
							<li><a href="layout-chat-open.html"> <span class="title">Chat
										Open</span>
							</a></li>
							<li><a
								href="layout-horizontal-sidebar-menu-collapsed-right.html">
									<span class="title">Both Menus &amp; Collapsed</span>
							</a></li>
							<li><a href="layout-boxed.html"> <span class="title">Boxed
										Layout</span>
							</a></li>
							<li><a href="layout-boxed-horizontal-menu.html"> <span
									class="title">Boxed &amp; Horizontal Menu</span>
							</a></li>
							<li><a href="http://www.cssmoban.com"> <span
									class="title">weidea.net</span>
							</a></li>
						</ul></li>
					<li><a href="ui-panels.html"> <i class="linecons-note"></i>
							<span class="title">UI Elements</span>
					</a>
						<ul>
							<li><a href="ui-panels.html"> <span class="title">Panels</span>
							</a></li>
							<li><a href="ui-buttons.html"> <span class="title">Buttons</span>
							</a></li>
							<li><a href="ui-tabs-accordions.html"> <span
									class="title">Tabs &amp; Accordions</span>
							</a></li>
							<li><a href="ui-modals.html"> <span class="title">Modals</span>
							</a></li>
							<li><a href="ui-breadcrumbs.html"> <span class="title">Breadcrumbs</span>
							</a></li>
							<li><a href="ui-blockquotes.html"> <span class="title">Blockquotes</span>
							</a></li>
							<li><a href="ui-progressbars.html"> <span class="title">Progress
										Bars</span>
							</a></li>
							<li><a href="ui-navbars.html"> <span class="title">Navbars</span>
							</a></li>
							<li><a href="ui-alerts.html"> <span class="title">Alerts</span>
							</a></li>
							<li><a href="ui-pagination.html"> <span class="title">Pagination</span>
							</a></li>
							<li><a href="ui-typography.html"> <span class="title">Typography</span>
							</a></li>
							<li><a href="ui-other-elements.html"> <span
									class="title">Other Elements</span>
							</a></li>
						</ul></li>
					<li><a href="ui-widgets.html"> <i class="linecons-star"></i>
							<span class="title">Widgets</span>
					</a></li>
					<li><a href="mailbox-main.html"> <i class="linecons-mail"></i>
							<span class="title">Mailbox</span> <span
							class="label label-success pull-right">5</span>
					</a>
						<ul>
							<li><a href="mailbox-main.html"> <span class="title">Inbox</span>
							</a></li>
							<li><a href="mailbox-compose.html"> <span class="title">Compose
										Message</span>
							</a></li>
							<li><a href="mailbox-message.html"> <span class="title">View
										Message</span>
							</a></li>
						</ul></li>
					<li><a href="tables-basic.html"> <i
							class="linecons-database"></i> <span class="title">Tables</span>
					</a>
						<ul>
							<li><a href="tables-basic.html"> <span class="title">Basic
										Tables</span>
							</a></li>
							<li><a href="tables-responsive.html"> <span
									class="title">Responsive Table</span>
							</a></li>
							<li><a href="tables-datatables.html"> <span
									class="title">Data Tables</span>
							</a></li>
						</ul></li>
					<li><a href="forms-native.html"> <i
							class="linecons-params"></i> <span class="title">Forms</span>
					</a>
						<ul>
							<li><a href="forms-native.html"> <span class="title">Native
										Elements</span>
							</a></li>
							<li><a href="forms-advanced.html"> <span class="title">Advanced
										Plugins</span>
							</a></li>
							<li><a href="forms-wizard.html"> <span class="title">Form
										Wizard</span>
							</a></li>
							<li><a href="forms-validation.html"> <span class="title">Form
										Validation</span>
							</a></li>
							<li><a href="forms-input-masks.html"> <span
									class="title">Input Masks</span>
							</a></li>
							<li><a href="forms-file-upload.html"> <span
									class="title">File Upload</span>
							</a></li>
							<li><a href="forms-editors.html"> <span class="title">Editors</span>
							</a></li>
							<li><a href="forms-sliders.html"> <span class="title">Sliders</span>
							</a></li>
						</ul></li>
					<li><a href="extra-gallery.html"> <i
							class="linecons-beaker"></i> <span class="title">Extra</span> <span
							class="label label-purple pull-right hidden-collapsed">New
								Items</span>
					</a>
						<ul>
							<li><a href="extra-icons-fontawesome.html"> <span
									class="title">Icons</span> <span
									class="label label-warning pull-right">4</span>
							</a>
								<ul>
									<li><a href="extra-icons-fontawesome.html"> <span
											class="title">Font Awesome</span>
									</a></li>
									<li><a href="extra-icons-linecons.html"> <span
											class="title">Linecons</span>
									</a></li>
									<li><a href="extra-icons-elusive.html"> <span
											class="title">Elusive</span>
									</a></li>
									<li><a href="extra-icons-meteocons.html"> <span
											class="title">Meteocons</span>
									</a></li>
								</ul></li>
							<li><a href="extra-maps-google.html"> <span
									class="title">Maps</span>
							</a>
								<ul>
									<li><a href="extra-maps-google.html"> <span
											class="title">Google Maps</span>
									</a></li>
									<li><a href="extra-maps-advanced.html"> <span
											class="title">Advanced Map</span>
									</a></li>
									<li><a href="extra-maps-vector.html"> <span
											class="title">Vector Map</span>
									</a></li>
								</ul></li>
							<li><a href="extra-gallery.html"> <span class="title">Gallery</span>
							</a></li>
							<li><a href="extra-calendar.html"> <span class="title">Calendar</span>
							</a></li>
							<li><a href="extra-profile.html"> <span class="title">Profile</span>
							</a></li>
							<li><a href="extra-login.html"> <span class="title">Login</span>
							</a></li>
							<li><a href="extra-lockscreen.html"> <span class="title">Lockscreen</span>
							</a></li>
							<li><a href="extra-login-light.html"> <span
									class="title">Login Light</span>
							</a></li>
							<li><a href="extra-timeline.html"> <span class="title">Timeline</span>
							</a></li>
							<li><a href="extra-timeline-center.html"> <span
									class="title">Timeline Centerd</span>
							</a></li>
							<li><a href="extra-notes.html"> <span class="title">Notes</span>
							</a></li>
							<li><a href="extra-image-crop.html"> <span class="title">Image
										Crop</span>
							</a></li>
							<li><a href="extra-portlets.html"> <span class="title">Portlets</span>
							</a></li>
							<li><a href="blank-sidebar.html"> <span class="title">Blank
										Page</span>
							</a></li>
							<li><a href="extra-search.html"> <span class="title">Search</span>
							</a></li>
							<li><a href="extra-invoice.html"> <span class="title">Invoice</span>
							</a></li>
							<li><a href="extra-not-found.html"> <span class="title">404
										Page</span>
							</a></li>
							<li><a href="extra-tocify.html"> <span class="title">Tocify</span>
							</a></li>
							<li><a href="extra-loader.html"> <span class="title">Loading
										Progress</span>
							</a></li>
							<li><a href="extra-page-loading-ol.html"> <span
									class="title">Page Loading Overlay</span>
							</a></li>
							<li><a href="extra-notifications.html"> <span
									class="title">Notifications</span>
							</a></li>
							<li><a href="extra-nestable-lists.html"> <span
									class="title">Nestable Lists</span>
							</a></li>
							<li><a href="extra-scrollable.html"> <span class="title">Scrollable</span>
							</a></li>
						</ul></li>
					<li><a href="charts-main.html"> <i class="linecons-globe"></i>
							<span class="title">Charts</span>
					</a>
						<ul>
							<li><a href="charts-main.html"> <span class="title">Chart
										Variants</span>
							</a></li>
							<li><a href="charts-range.html"> <span class="title">Range
										Selector</span>
							</a></li>
							<li><a href="charts-sparklines.html"> <span
									class="title">Sparklines</span>
							</a></li>
							<li><a href="charts-map.html"> <span class="title">Map
										Charts</span>
							</a></li>
							<li><a href="charts-gauges.html"> <span class="title">Circular
										Gauges</span>
							</a></li>
							<li><a href="charts-bar-gauges.html"> <span
									class="title">Bar Gauges</span>
							</a></li>
						</ul></li>
					<li><a href="#"> <i class="linecons-cloud"></i> <span
							class="title">Menu Levels</span>
					</a>
						<ul>
							<li><a href="#"> <i class="entypo-flow-line"></i> <span
									class="title">Menu Level 1.1</span>
							</a>
								<ul>
									<li><a href="#"> <i class="entypo-flow-parallel"></i>
											<span class="title">Menu Level 2.1</span>
									</a></li>
									<li><a href="#"> <i class="entypo-flow-parallel"></i>
											<span class="title">Menu Level 2.2</span>
									</a>
										<ul>
											<li><a href="#"> <i class="entypo-flow-cascade"></i>
													<span class="title">Menu Level 3.1</span>
											</a></li>
											<li><a href="#"> <i class="entypo-flow-cascade"></i>
													<span class="title">Menu Level 3.2</span>
											</a>
												<ul>
													<li><a href="#"> <i class="entypo-flow-branch"></i>
															<span class="title">Menu Level 4.1</span>
													</a></li>
												</ul></li>
										</ul></li>
									<li><a href="#"> <i class="entypo-flow-parallel"></i>
											<span class="title">Menu Level 2.3</span>
									</a></li>
								</ul></li>
							<li><a href="#"> <i class="entypo-flow-line"></i> <span
									class="title">Menu Level 1.2</span>
							</a></li>
							<li><a href="#"> <i class="entypo-flow-line"></i> <span
									class="title">Menu Level 1.3</span>
							</a></li>
						</ul></li>
				</ul>

			</div>

		</div>

		<div class="main-content">
 <nav class="navbar user-info-navbar" role="navigation">

        <!-- Left links for user info navbar -->
        <ul class="user-info-menu left-links list-inline list-unstyled">

            <li class="hidden-sm hidden-xs">
                <a href="#" data-toggle="sidebar">
                    <i class="fa-bars"></i>
                </a>
            </li>

            <li class="dropdown hover-line">
                <a href="#" data-toggle="dropdown">
                    <i class="fa-envelope-o"></i>
                    <span class="badge badge-green">15</span>
                </a>

                <ul class="dropdown-menu messages">
                    <li>

                        <ul class="dropdown-menu-list list-unstyled ps-scrollbar">

                            <li class="active"><!-- "active" class means message is unread -->
                                <a href="#">
                                        <span class="line">
                                            <strong>Luc Chartier</strong>
                                            <span class="light small">- yesterday</span>
                                        </span>

                                    <span class="line desc small">
                                            This ain’t our first item, it is the best of the rest.
                                        </span>
                                </a>
                            </li>

                            <li class="active">
                                <a href="#">
                                        <span class="line">
                                            <strong>Salma Nyberg</strong>
                                            <span class="light small">- 2 days ago</span>
                                        </span>

                                    <span class="line desc small">
                                            Oh he decisively impression attachment friendship so if everything.
                                        </span>
                                </a>
                            </li>

                            <li>
                                <a href="#">
                                        <span class="line">
                                            Hayden Cartwright
                                            <span class="light small">- a week ago</span>
                                        </span>

                                    <span class="line desc small">
                                            Whose her enjoy chief new young. Felicity if ye required likewise so doubtful.
                                        </span>
                                </a>
                            </li>

                            <li>
                                <a href="#">
                                        <span class="line">
                                            Sandra Eberhardt
                                            <span class="light small">- 16 days ago</span>
                                        </span>

                                    <span class="line desc small">
                                            On so attention necessary at by provision otherwise existence direction.
                                        </span>
                                </a>
                            </li>

                            <!-- Repeated -->

                            <li class="active"><!-- "active" class means message is unread -->
                                <a href="#">
                                        <span class="line">
                                            <strong>Luc Chartier</strong>
                                            <span class="light small">- yesterday</span>
                                        </span>

                                    <span class="line desc small">
                                            This ain’t our first item, it is the best of the rest.
                                        </span>
                                </a>
                            </li>

                            <li class="active">
                                <a href="#">
                                        <span class="line">
                                            <strong>Salma Nyberg</strong>
                                            <span class="light small">- 2 days ago</span>
                                        </span>

                                    <span class="line desc small">
                                            Oh he decisively impression attachment friendship so if everything.
                                        </span>
                                </a>
                            </li>

                            <li>
                                <a href="#">
                                        <span class="line">
                                            Hayden Cartwright
                                            <span class="light small">- a week ago</span>
                                        </span>

                                    <span class="line desc small">
                                            Whose her enjoy chief new young. Felicity if ye required likewise so doubtful.
                                        </span>
                                </a>
                            </li>

                            <li>
                                <a href="#">
                                        <span class="line">
                                            Sandra Eberhardt
                                            <span class="light small">- 16 days ago</span>
                                        </span>

                                    <span class="line desc small">
                                            On so attention necessary at by provision otherwise existence direction.
                                        </span>
                                </a>
                            </li>

                        </ul>

                    </li>

                    <li class="external">
                        <a href="blank-sidebar.html">
                            <span>All Messages</span>
                            <i class="fa-link-ext"></i>
                        </a>
                    </li>
                </ul>
            </li>

            <li class="dropdown hover-line">
                <a href="#" data-toggle="dropdown">
                    <i class="fa-bell-o"></i>
                    <span class="badge badge-purple">7</span>
                </a>

                <ul class="dropdown-menu notifications">
                    <li class="top">
                        <p class="small">
                            <a href="#" class="pull-right">Mark all Read</a>
                            You have <strong>3</strong> new notifications.
                        </p>
                    </li>

                    <li>
                        <ul class="dropdown-menu-list list-unstyled ps-scrollbar">
                            <li class="active notification-success">
                                <a href="#">
                                    <i class="fa-user"></i>

                                    <span class="line">
                                            <strong>New user registered</strong>
                                        </span>

                                    <span class="line small time">
                                            30 seconds ago
                                        </span>
                                </a>
                            </li>

                            <li class="active notification-secondary">
                                <a href="#">
                                    <i class="fa-lock"></i>

                                    <span class="line">
                                            <strong>Privacy settings have been changed</strong>
                                        </span>

                                    <span class="line small time">
                                            3 hours ago
                                        </span>
                                </a>
                            </li>

                            <li class="notification-primary">
                                <a href="#">
                                    <i class="fa-thumbs-up"></i>

                                    <span class="line">
                                            <strong>Someone special liked this</strong>
                                        </span>

                                    <span class="line small time">
                                            2 minutes ago
                                        </span>
                                </a>
                            </li>

                            <li class="notification-danger">
                                <a href="#">
                                    <i class="fa-calendar"></i>

                                    <span class="line">
                                            John cancelled the event
                                        </span>

                                    <span class="line small time">
                                            9 hours ago
                                        </span>
                                </a>
                            </li>

                            <li class="notification-info">
                                <a href="#">
                                    <i class="fa-database"></i>

                                    <span class="line">
                                            The server is status is stable
                                        </span>

                                    <span class="line small time">
                                            yesterday at 10:30am
                                        </span>
                                </a>
                            </li>

                            <li class="notification-warning">
                                <a href="#">
                                    <i class="fa-envelope-o"></i>

                                    <span class="line">
                                            New comments waiting approval
                                        </span>

                                    <span class="line small time">
                                            last week
                                        </span>
                                </a>
                            </li>
                        </ul>
                    </li>

                    <li class="external">
                        <a href="#">
                            <span>View all notifications</span>
                            <i class="fa-link-ext"></i>
                        </a>
                    </li>
                </ul>
            </li>

        </ul>


        <!-- Right links for user info navbar -->
        <ul class="user-info-menu right-links list-inline list-unstyled">

            <li class="search-form"><!-- You can add "always-visible" to show make the search input visible -->

                <form method="get" action="extra-search.html">
                    <input type="text" name="s" class="form-control search-field" placeholder="Type to search..."/>

                    <button type="submit" class="btn btn-link">
                        <i class="linecons-search"></i>
                    </button>
                </form>

            </li>

            <li class="dropdown user-profile">
                <a href="#" data-toggle="dropdown">
                    <img src="${ctx}/assets/images/user-4.png" alt="user-image"
                         class="img-circle img-inline userpic-32" width="28"/>
                   <span>
                           ${user.username}<i class="fa-angle-down"></i>
                    </span> 
                </a>

                <ul class="dropdown-menu user-profile-menu list-unstyled">
                    <li>
                        <a href="#edit-profile">
                            <i class="fa-edit"></i>
                            New Post
                        </a>
                    </li>
                    <li>
                        <a href="#settings">
                            <i class="fa-wrench"></i>
                            Settings
                        </a>
                    </li>
                    <li>
                        <a href="#profile">
                            <i class="fa-user"></i>
                            Profile
                        </a>
                    </li>
                    <li>
                        <a href="#help">
                            <i class="fa-info"></i>
                            Help
                        </a>
                    </li>
                    <li class="last">
                        <a class="btn-logout" href="http://localhost:8080/oa-library/user/login" onclick=alert("退出成功!")>
                            <i class="fa-lock"></i>
                            Logout
                        </a>
                    </li>
                </ul>
            </li>

            <li>
                <a href="#" data-toggle="chat">
                    <i class="fa-comments-o"></i>
                </a>
            </li>

        </ul>

    </nav>
	


			<!-- Main Footer -->
			<!-- Choose between footer styles: "footer-type-1" or "footer-type-2" -->
			<!-- Add class "sticky" to  always stick the footer to the end of page (if page contents is small) -->
			<!-- Or class "fixed" to  always fix the footer to the end of page -->
			<%@ include file="commons/footer.jsp"%>
		</div>

	</div>


	<div class="page-loading-overlay">
		<div class="loader-2"></div>
	</div>
		<!-- User Info, Notifications and Menu Bar -->
   


	<%@ include file="commons/js.jsp"%>

</body>
</html>