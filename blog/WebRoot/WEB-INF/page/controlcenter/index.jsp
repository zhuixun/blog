<%--
  Created by IntelliJ IDEA.
  User: 49236_000
  Date: 14-2-19
  Time: 下午4:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/page/share/taglib.jsp" %>
<!doctype html>
<html lang="cn">
<head>
	<title>倪伟伟个人博客-管理平台</title>
</head>

<frameset framespacing="0" border="0" rows="85,*" frameborder="0">
    <frame name="banner" scrolling="no" noresize target="topframe" src="<html:rewrite action='/control/center/top'/>" marginwidth="0" marginheight="0">
    <frameset cols="246,*">
    <frame name="menuframe" target="menuframe" src="<html:rewrite action='/control/center/left'/>" scrolling="no" marginwidth="0" marginheight="0">
    <frame name="mainframe" target="mainframe" scrolling="auto" noresize src="<html:rewrite action='/control/center/right'/>" marginwidth="0" marginheight="0">
  	</frameset>
</frameset>
<body>
    <noframes>
    	<body>您的浏览器不支持框架！</body>
    </noframes>
</body>
</html>