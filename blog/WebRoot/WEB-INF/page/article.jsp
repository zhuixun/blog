<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/page/share/taglib.jsp" %>
<!DOCTYPE html>
<html lang="cn">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta content="IE=10,IE=9,IE=8,ie=7" http-equiv="X-UA-Compatible">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>${title}|小倪的博客</title>
	<meta content="${keyword}" name="keywords">
	<meta content="${description}" name="description">
	<!--[if lt IE 9]><script src="<%=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()%>/js/controlcenter/html5.js"></script><![endif]-->
	<!-- Bootstrap -->
	<link rel="stylesheet"  href="<%=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()%>/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="<%=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()%>/css/blog.css">
	<!-- 响应式css -->
	<link rel="stylesheet" href="<%=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()%>/bootstrap/css/bootstrap-responsive.css">
	<link rel="shortcut icon" href="<%=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()%>/favicon.ico" type="image/x-icon">
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="<%=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()%>/js/jquery-1.10.2.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="<%=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()%>/bootstrap/js/bootstrap.min.js"></script>
	<SCRIPT language=JavaScript src="<%=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()%>/js/xmlhttp.js"></SCRIPT>
	<script type="text/javascript">
		 <!--
        	function getArticleList(){
				var newestArticle = document.getElementById('newestArticle');		
				if(newestArticle){
					newestArticle.innerHTML= "数据正在加载...";
					send_request(function(value){newestArticle.innerHTML=value},
							 "<html:rewrite action="/article/switch"/>?method=newestArticle", true);
				}
			}
			
			function pageInit(){
				getArticleList();
			}
         //-->
	</script>
</head>

<body onload="javascript:pageInit()">
<!-- nav -->
<div class="navbar navbar-fixed-top navbar-inverse" >
	<div class="navbar-inner">
		<div class="container">
			<a class="brand" href="/" title="${title}|小倪的博客">小倪的博客</a>
			<ul class="nav">
				<li><a href="/" title="${setSettings.title }">首页</a></li>
				<li><a href="<%=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()%>/html/about/about.shtml" title="${setSettings.description }">关于</a></li>
			</ul>
		</div>
	</div>
</div>
<!-- nav-margin-bottom --> 
<div class="nav-margin"></div>
<!-- body -->
<div class="container-fluid">
	<div class="row-fluid">
		<!-- content -->
		<div class="span9">
			<div class="well well-large blog-content">
				<div class="title-box">
				<ul class="date-b">
					<li class="date-m">${fn:substring(article.createdate,5,7)}月</li>
					<li class="date-d">${fn:substring(article.createdate,8,10)}日</li>
				</ul>
				<h1 class="article-title">
					${article.name}
				</h1>
				</div>
				<div class="article-content">
					${article.description}
				</div>
				<!-- 多说评论框 start -->
				<div class="ds-thread" data-thread-key="${article.id}" data-title="${article.name}" data-url="/html/article/${entry.articletype.typeid}/${entry.id}.shtml"></div>
				<!-- 多说评论框 end -->
			</div>
		</div>
		<!-- Sidebar content -->
		<div class="span3">
			<!--  
			<div class="blog-search pull-right">
			<form class="form-search">
				<input type="text" class="search-input" placeholder="Search...">
				<input type="submit" class="btn btn-success search-submit" value="搜索" >
			</form>
			</div>
			-->
			<!-- 日志分类 -->
			<div class="article-classify">
				<h3 class="classify-title">文章分类</h3>
				<ul class="classify-list pull-left">
				<c:forEach items="${pageView.records}" var="entry" varStatus="statu">
				<li>
				${statu.count}.<a href="<html:rewrite action='<%=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()%>/article/view'/>?url=${entry.url}" target="_blank" title="${entry.name}">${fn:substring(entry.name,0,15)}<span class="article-date">${entry.createdate}</span></a>
				</li>
				</c:forEach>
				</ul>
			</div>
			<!-- 最新文章 -->
			<div class="new-article">
				<h3 class="classify-title">最新文章</h3>
				<ul class="article-list pull-left" id="newestArticle">
				</ul>
			</div>
			<!-- 友情链接 -->
			<div class="Links" >
				<div class="Links-title">友情链接</div>
				<a href="http://hadoop.apache.org/" title="hadoop" >Hadoop</a>
				<a href="http://spark.apache.org/" title="spark" >spark</a>
			</div>
		</div>
	</div>
</div>
<!-- footer -->
<div>
	<footer class="footer">
		<div class="container-fluid">
			<p><script type="text/javascript">
	var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
	document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3F7c47f7e806d056550e697bf8d76f7cf1' type='text/javascript'%3E%3C/script%3E"));
			</script>
			格物致知 宁静致远
			</p>
			<p>Designed and Developed by xiao ni.</p>
			<p>Copyright © 2013 xnbigdata.com. All Rights Reserved.</p>
		</div>
	</footer>
</div>
<!-- 回到顶部 -->
<script src="<%=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()%>/js/scrolltopcontrol.js" type="text/javascript">
<div class="rollto">
<button class="btn btn-inverse" title="回顶部" data-type="totop">
<i class="icon-eject icon-white"></i>
</button>
</div>
<script type="text/javascript">
	// <![CDATA[
	$.fn.smartFloat = function() {
	var position = function(element) {
	var top = element.position().top, pos = element.css("position");
	$(window).scroll(function() {
	var scrolls = $(this).scrollTop();
	if (scrolls > top) {
	if (window.XMLHttpRequest) {
	element.css({
	position: "fixed",
	top: 47
	});
	} else {
	element.css({
	top: scrolls
	});
	}
	}else {
	element.css({
	position: pos,
	top: top
	});
	}
	});
	};
	return $(this).each(function() {
	position($(this));
	});
	};
	//绑定
	$("#blad").smartFloat();
	// ]]>
</script>
<div id="topcontrol" style="position: fixed; bottom:150px; right:0px; opacity: 1; cursor: pointer;" title="返回顶部">
<div class="totop">Top</div>
</div>
<!-- 多说公共JS代码 start (一个网页只需插入一次) -->
<script type="text/javascript">
	var duoshuoQuery = {short_name:"xnbigdata"};
	(function() {
		var ds = document.createElement('script');
		ds.type = 'text/javascript';ds.async = true;
		ds.src = (document.location.protocol == 'https:' ? 'https:' : 'http:') + '//static.duoshuo.com/embed.js';
		ds.charset = 'UTF-8';
		(document.getElementsByTagName('head')[0] 
		 || document.getElementsByTagName('body')[0]).appendChild(ds);
	})();
</script>
<!-- 多说公共JS代码 end -->
</body>
</html>
