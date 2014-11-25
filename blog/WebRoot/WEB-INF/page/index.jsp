<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/page/share/taglib.jsp" %>
<!DOCTYPE html>
<html lang="cn">
<!--[if lt IE 7]> <html class="lt-ie9 lt-ie8 lt-ie7" lang="cn"> <![endif]-->
<!--[if IE 7]> <html class="lt-ie9 lt-ie8" lang="cn"> <![endif]-->
<!--[if IE 8]> <html class="lt-ie9" lang="cn"> <![endif]-->
<!--[if gt IE 8]><!--> <html lang="cn"> <!--<![endif]-->
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta content="IE=10,IE=9,IE=8,ie=7" http-equiv="X-UA-Compatible">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>${setSettings.title }</title>
	<meta content="${setSettings.keyword }" name="keywords">
	<meta content="${setSettings.description }" name="description">
	<!--[if lt IE 9]>
	<script src="<%=request.getContextPath()%>/js/controlcenter/html5.js"></script>
	<![endif]-->
	<script src="<%=request.getContextPath()%>/js/controlcenter/jquery-1.7.2.min.js" ></script>
	<!-- Bootstrap -->
	<link rel="stylesheet"  href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/blog.css">
	<!-- 响应式css -->
	<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap-responsive.css">
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<link rel="shortcut icon" href="<%=request.getContextPath()%>/favicon.ico" type="image/x-icon">
	<script src="<%=request.getContextPath()%>/js/jquery-1.10.2.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="<%=request.getContextPath()%>/bootstrap/js/bootstrap.min.js"></script>
	<SCRIPT language=JavaScript src="<%=request.getContextPath()%>/js/xmlhttp.js"></SCRIPT>
	<script type="text/javascript">
		 <!--
         	//到指定的分页页面
            function topage(page){
			 	window.location.href="index.html"+"?page="+page;
        	}
        	
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
			//$.post()方式： 
			function getViewCount(articleid){ 
					$.ajax({
						type:"post", //使用GET还是POST方法
						data:{articleid:articleid}, //要传送给服务器端的参数，可以是纯文本，也可以是XML字符串
						url: "<html:rewrite action='/article/switch'/>?method=viewCount", //服务端的url
						dataType: "text",
	                    async: false
					});
			};
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
				<li><a href="<%=request.getContextPath()%>/html/about/about.shtml" title="${setSettings.description}">关于</a></li>
			</ul>
		</div>
	</div>
</div>
<!-- nav-margin-bottom --> 
<div class="nav-margin"></div>
<!-- body -->
<div class="container">
	<div class="row-fluid">
		<!-- content -->
		<div class="span9">
		<c:forEach  items="${pageView.records}" var="entry">
		<div class="well well-large blog-content">
			<div class="title-box">
				<ul class="date-b">
					<li class="date-m" id="month">${fn:substring(entry.createdate,5,7)}月</li>
					<li class="date-d">${fn:substring(entry.createdate,8,10)}日</li>
				</ul>
				<h1 class="title">
					<a onclick="getViewCount(${entry.id})"  title="${entry.name}" href="<%=request.getContextPath()%>/html/article/${entry.articletype.typeid}/${entry.id}.shtml">${entry.name}</a>
				</h1>
			</div>
			<div class="content clearfix">
				<article> 
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${entry.description}
				</article>
				<span class="read-article pull-right"><a href="<%=request.getContextPath()%>/html/article/${entry.articletype.typeid}/${entry.id}.shtml" title="${entry.name}" onclick="getViewCount(${entry.id})">阅读全文>></a></span>
			</div>
			<div class="diag"></div>
			<div class="meta">
				<a><i class="icon-comment" title="${entry.name}"></i>没有评论</a>
				<a><i class="icon-eye-open" title="${entry.clickcount}人阅读"></i>${entry.clickcount} 人阅读</a>
				<a><i class="icon-calendar" title="${entry.createdate}"></i>${entry.createdate}</a>
				<a><i class="icon-user" title="${entry.editor}"></i>${entry.editor}</a>
				<a><i class="icon-book" title="${entry.keyword}"></i>${entry.keyword}</a>
			</div>
		</div>
		</c:forEach>
		
		<!-- 分页 -->
		<div class="pagination pagination-mini">
    		${pageView.totalrecord}条数据	共${pageView.totalpage}页
			<c:forEach begin="${pageView.pageindex.startindex}" end="${pageView.pageindex.endindex}" var="wp">
				<ul>
					<c:if test="${pageView.currentpage==wp}">
					<li class="active"><a href="javascript:topage('${wp}')" title="${wp}页">上一页</a></li>
					</c:if>
					<c:if test="${pageView.currentpage==wp}">
					<li class="active"><a href="javascript:topage('${wp}')" title="${wp}页">${wp}</a></li>
					</c:if>
					<c:if test="${pageView.currentpage!=wp}">
					<li class="disabled"><a href="javascript:topage('${wp}')" title="${wp}页">${wp}</a></li>
					</c:if>
			  </ul>
		  </c:forEach>
		</div>
		
		</div>
		<!-- Sidebar content -->
		<div class="span3" style="position:static;top:20px;">
			<!-- 日志分类 -->
			<div class="article-classify" >
				<h3 class="classify-title">文章分类</h3>
				<ul class="classify-list pull-left" >
				<c:forEach items="${classifyLists}" var="entry" varStatus="statu">
				<li>
				<a href="<%=request.getContextPath()%>${entry.category}" title="${entry.name}"> ${entry.name} (${entry.count})</a>
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
			</div>
		</div>
	</div>
</div>
<!-- footer -->
<div>
	<footer class="footer">
		<div class="container-fluid">
			<p>
				<script type="text/javascript">
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
<script src="<%=request.getContextPath()%>/js/scrolltopcontrol.js" type="text/javascript">
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
</body>
</html>