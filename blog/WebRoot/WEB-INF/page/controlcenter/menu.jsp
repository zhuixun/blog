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
	<title>倪伟伟个人博客</title>
    <link rel="stylesheet" href="/css/controlcenter/layout.css" type="text/css" />
    <link rel="stylesheet" href="/js/controlcenter/bootstrap/bootstrap.css" type="text/css" />
    
	<!--[if lt IE 9]><script src="/js/controlcenter/html5.js"></script><![endif]-->
  	<script src="/js/controlcenter/jquery-1.7.2.min.js" ></script>
    <!-- bootstrap -->
    <script type="text/javascript" src="/js/controlcenter/bootstrap/bootstrap.min.js" ></script>
    
    <script src="/js/controlcenter/wisdom/wisdom.plug-in.js"></script>
    <script src="/js/controlcenter/wisdom/system.js"></script>
</head>
<body>
    <div id="container" class="clearfix">
        <aside id="sidebar_menu" class="column">
            <h3>文章功能模块</h3>
            <ul class="toggle">
                <li class="icn_categories"><a href="<html:rewrite action='/control/article/type/list'/> " target="mainframe">文章栏目</a></li>
                <li class="icn_categories"><a href="<html:rewrite action='/control/article/manage'/>?method=list" target="mainframe">文章列表</a></li>
                <li class="icn_new_article"><a href="<html:rewrite action='/control/article/manage'/>?method=addUI" target="mainframe">文章发布</a></li>
            </ul>
            <h3>关于我功能模块</h3>
            <ul class="toggle">
                <li class="icn_new_article"><a href="<html:rewrite action='/control/about/manage'/>?method=addUI" target="mainframe">关于我</a></li>
            </ul>
			<h3>网站设置</h3>
			 <ul class="toggle">
			     <li class="icn_folder"><a href="<html:rewrite action='/control/webset/manage'/>?method=addUI" target="mainframe">网站设置</a></li>
			</ul>
            <footer>
                <hr/>
                <p><strong>Copyright &copy; 2012 niweiwei</strong></p>
                <iframe width="0" height="0" src="<html:rewrite action='/cache'/>" ></iframe>
            </footer>
        </aside><!-- end of sidebar -->
	</div>

</body>
</html>