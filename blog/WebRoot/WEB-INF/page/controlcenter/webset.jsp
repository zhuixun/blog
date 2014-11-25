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
	<title>网站设置</title>
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
	<div id="container" class="clearfix">
        <section id="main" class="column"  >
        	<article class="module width_full" style="overflow-y:scroll;height:575px;position:relative">
            	<form class="form-horizontal wisdomForm" _lpchecked="1" action="<html:rewrite action='/control/webset/manage'/>?method=add" method="post">
	                <div class="module_content" >
                        <fieldset>
                          <legend>网站设置</legend>
                          <div class="control-group">
                            <label class="control-label" for="input01">网站标题</label>
                            <div class="controls">
                              <input type="text" class="input-xlarge required" id="input01" name='title'>
                            </div>
                          </div>
                          <div class="control-group">
                            <label class="control-label" for="input02">网站关键词</label>
                            <div class="controls">
                              <input type="text" class="input-xlarge required" id="input02" name='keyword'>
                            </div>
                          </div>
                          <div class="control-group">
                            <label class="control-label" for="input03">网站描述</label>
                            <div class="controls">
                              <input type="text" class="input-xlarge required" id="input03" name='description'>
                            </div>
                          </div>
                          <div class="control-group">
                          	<label class="control-label" for="textarea">热门标签</label>
                            <div class="controls">
                              <input type="text" class="input-xlarge required" id="input04" name='hotTitle'>
                            </div>
                          </div>
                          <div class="control-group">
                          	<label class="control-label" for="textarea">网站底部</label>
                            <div class="controls">
                              <input type="text" class="input-xlarge required" id="input05" name='footer'>
                            </div>
                          </div>
                        </fieldset>
                	</div>
                    <footer>
                        <div class="submit_link">
                            <input type="submit" value="保存文章" class="btn btn-primary" name="submit">
                            <input type="reset" value="重置" class="btn" name="reset">
                        </div>
                    </footer>
                </form>
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
</body>
</html>