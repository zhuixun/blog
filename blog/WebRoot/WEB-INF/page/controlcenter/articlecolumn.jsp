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
    <!-- 分页 -->
    <script language="JavaScript">
        <!--
            //到指定的分页页面
            function topage(page){
		        var form = document.forms[0];
				form.page.value=page;
				form.submit();
        	}
         //-->
    </script>
</head>
<body>
<html:form action="control/article/type/list.do" method="post">
<html:hidden property="page"/>
	<div id="container" class="clearfix">
		<section id="main" class="column">
		     <article class="module width_full">
		         <header><h3>文章栏目</h3></header>
		         <div class="module_content">
		             <table class="table table-bordered table-hover table-striped" style="margin-bottom:0;">
		                 <thead>
		                     <tr>
		                         <th>类别ID</th>
		                         <th>文章类别名称</th>
		                         <th>所属父类</th>
		                         <th>备注</th>
		                         <th>操作</th>
		                     </tr>
		                 </thead>
		                 <tbody class="nth-child">
		                     <c:forEach items="${pageView.records}" var="entry">
		                         <tr>
		                             <td>${entry.typeid }</td>
		                             <td>${entry.name}</td>
		                             <td>${entry.parent}</td>
		                             <td>${entry.note}</td>
		                             <td>
		                                 <button class="btn btn-small btn-primary" type="button">创建子类</button>
		                                 <button class="btn btn-small btn-primary" type="button">修改</button>
		                             </td>
		                         </tr>
		                     </c:forEach>
		                 </tbody>
		             </table><!-- end table -->
		         </div>
		         <div class="pagination pagination-centered">
		                 <c:forEach begin="${pageView.pageindex.startindex}" end="${pageView.pageindex.endindex}" var="wp">
		                     <ul>
		                         <li><a href="javascript:topage('${wp}')">${wp}</a></li>
		                     </ul>
		                 </c:forEach>
		         </div>
		         <!-- 分页结束 -->
		     </article>
		</section>
	</div>
    
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
          <a href="#" class="btn btn-primary">确认退出</a>
          <a href="#" class="btn" data-dismiss="modal">不退出</a>
        </div>
      </div>
</html:form>
</body>
</html>