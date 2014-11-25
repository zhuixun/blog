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
	<title>about</title>
    <link rel="stylesheet" href="/css/controlcenter/layout.css" type="text/css" />
    <link rel="stylesheet" href="/js/controlcenter/bootstrap/bootstrap.css" type="text/css" />

    <!--[if lt IE 9]><script src="/js/controlcenter/html5.js"></script><![endif]-->
    <script src="/js/controlcenter/jquery-1.7.2.min.js" ></script>
    <!-- bootstrap -->
    <script type="text/javascript" src="/js/controlcenter/bootstrap/bootstrap.min.js" ></script>

    <script src="/js/controlcenter/wisdom/wisdom.plug-in.js"></script>
    <script src="/js/controlcenter/wisdom/system.js"></script>
    
    <!-- 富文本编辑器 -->
    <script type="text/javascript" src="/js/controlcenter/ueditor/ueditor.config.js"></script>
	<script type="text/javascript" src="/js/controlcenter/ueditor/ueditor.all.js"></script>
    <link rel="stylesheet" type="text/css" href="/js/controlcenter/ueditor/themes/default/css/ueditor.css">

    <!-- 表单验证，表单扩展 -->
    <script type="text/javascript" src="/js/controlcenter/validation/jquery.validate.min.js"></script>
    <script type="text/javascript" src="/js/controlcenter/wisdom/wisdom.form.js" ></script>
</head>
<body>
<html:form action="/control/about/manage?method=add" enctype="multipart/form-data" method="post">
<input type="hidden" name="method" value="edit">
	<div id="container" class="clearfix">
		<section id="main" class="column">
		  	<article class="module width_full" style="overflow-y:scroll;height:575px;position:relative">
		           <div class="module_content" >
		                  <fieldset>
		                    <legend>About</legend>
		                    <div class="control-group">
		                      <div class="controls">
		                      	<!--  
		                          <script type="text/plain"  id="myEditor" name="myContent"></script>
		                          -->
									<script type="text/plain"  id="myEditor" name="myContent"></script>
									<script type="text/javascript">
		                              var editor = new baidu.editor.ui.Editor();
										//在高度计算完毕后，同步列高度
										editor.addListener('autoheightchanged',function(){
											$('.column').equalHeight();
										});
		                              editor.render("myEditor");
		                          </script>
		                      </div>
		                    </div>
		                  </fieldset>
		          	</div>
		              <footer>
		                  <div class="submit_link">
		                      <input type="submit" value="保存" class="btn btn-primary" name="edit">
		                      <input type="reset" value="重置" class="btn" name="reset">
		                  </div>
		              </footer>
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