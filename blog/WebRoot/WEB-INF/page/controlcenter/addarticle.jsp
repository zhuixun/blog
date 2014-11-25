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
	<title>文章添加</title>
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
    
	<!-- 代码高亮 -->
	<script src="../../../js/controlcenter/ueditor/ueditor.parse.min.js" type="text/javascript"></script>
	<script src="../../../js/controlcenter/ueditor/third-party/SyntaxHighlighter/shCore.js" type="text/javascript"></script>
	<link href="../../../js/controlcenter/ueditor/third-party/SyntaxHighlighter/shCoreDefault.css" rel="stylesheet" type="text/css">
	
    <!-- 表单验证，表单扩展 -->
    <script type="text/javascript" src="/js/controlcenter/validation/jquery.validate.min.js"></script>
    <script type="text/javascript" src="/js/controlcenter/wisdom/wisdom.form.js" ></script>
</head>
<body>
	<div id="container" class="clearfix">
		<section id="main" class="column">
		  	<article class="module width_full" style="overflow-y:scroll;height:575px;position:relative">
		      	<form class="form-horizontal wisdomForm" _lpchecked="1" action="<html:rewrite action='/control/article/manage'/>?method=add" method="post">
		           <div class="module_content" >
		                  <fieldset>
		                    <legend>文章发布</legend>
		                    <div class="control-group">
		                      <label class="control-label" for="input01">文章标题</label>
		                      <div class="controls">
		                        <input type="text" class="input-xlarge required" id="input01" name='name'>
		                      </div>
		                    </div>
		                    <div class="control-group">
		                      <label class="control-label" for="input02">关键词</label>
		                      <div class="controls">
		                        <input type="text" class="input-xlarge required" id="input02" name='keyword'>
		                      </div>
		                    </div>
		                    <div class="control-group">
		                      <label class="control-label" for="select01">文章栏目</label>
		                      <div class="controls">
		                        <select id="select01" name="typeid">
		                          <option>选择</option>
		                          <c:forEach items="${articletypelist}" var="entry">
		                          <option value="${entry.typeid}">${entry.name}</option>
		                          </c:forEach>
		                        </select>
		                      </div>
		                    </div>
		                    <div class="control-group">
		                    	<label class="control-label" for="textarea">文章内容</label>
		                      <div class="controls">
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