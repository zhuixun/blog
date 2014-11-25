<%--
  Created by IntelliJ IDEA.
  User: 49236_000
  Date: 14-2-19
  Time: 下午4:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="cn">
<head>
	<title>倪伟伟个人博客</title>
    <link rel="stylesheet" href="/css/controlcenter/layout.css" type="text/css" />
	<!--[if lt IE 9]><script src="/js/controlcenter/html5.js"></script><![endif]-->
</head>
<body>
	<header id="header">
		<hgroup>
			<h1 class="site_title"><a href="index.html"><img alt="logo" src="/images/controlcenter/logo.png" class="logo" /></a></h1>
			<h2 class="section_title">BIG DATA</h2>
		</hgroup>
	</header> <!-- end of header bar -->
	
	<section id="secondary_bar">
        <div class="user">
            <p>${user.username} (<a href="#">3 条消息</a>)</p>
            <a class="logout_user" href="#modelLogoutDialog" data-toggle="modal"  title="Logout">Logout</a>
        </div>
        <div class="breadcrumbs_container">
            <i class="icon-chevron-left" id="toggleMenu"></i>
            <article class="breadcrumbs"><a href="index.html">BIG DATA</a> <div class="breadcrumb_divider"></div> <a class="current">基本表单</a></article>
        </div>
    </section>
    <!-- end of secondary bar -->
    
    <!-- 退出按钮被点击时。 -->
    <div id="modelLogoutDialog" class="modal hide fade" style="display: none; ">
        <div class="modal-header">
          <a class="close" data-dismiss="modal">×</a>
          <h3>请确认</h3>
        </div>
        <div class="modal-body">
          <h4>确认退出</h4>
          <p>
                您确认要退出登录吗？
          </p>
        </div>
        <div class="modal-footer">
          <a href="<html:rewrite action='/user/logout'/>" class="btn btn-primary">确认退出</a>
          <a href="#" class="btn" data-dismiss="modal">不退出</a>
        </div>
      </div>
</body>
</html>