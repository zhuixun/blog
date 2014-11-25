<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/page/share/taglib.jsp" %>
<!doctype html>
<html lang="cn">
<head>
	<title>倪伟伟个人博客-message提示</title>
    <!--[if lt IE 9]><script src="/js/controlcenter/html5.js"></script><![endif]-->
    <!-- bootstrap -->
    <script type="text/javascript" src="/js/controlcenter/bootstrap/bootstrap.min.js" ></script>
    <link rel="stylesheet" href="/js/controlcenter/bootstrap/bootstrap.css" type="text/css" />
</head>
<body>
	<div class="modal">
	  <div class="modal-header">
	    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	    <h3>信息提示</h3>
	  </div>
	  <div class="modal-body">
	    <p><c:out value="${message}" escapeXml="false"/></p>
	  </div>
	  <div class="modal-footer">
	    <button class="btn btn-primary"  onclick="javascript:window.location.href='${urladdress}'" >确定</button>
	  </div>
	</div>
</body>
</html>