<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>${setSettings.title }</title>
	<meta content="${setSettings.keyword}" name="keywords">
	<meta content="${setSettings.description}" name="description">
  </head>
  <body> 
  <jsp:forward page="/index.html"/>
  	<!--  
	<script type="text/javascript">
		var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
		document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3F7c47f7e806d056550e697bf8d76f7cf1' type='text/javascript'%3E%3C/script%3E"));
	</script>
	-->
  </body>
</html>
