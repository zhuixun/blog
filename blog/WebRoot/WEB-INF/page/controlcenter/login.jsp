<%--
  Created by IntelliJ IDEA.
  User: 49236_000
  Date: 14-2-19
  Time: 下午4:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<!--[if lt IE 7]> <html class="lt-ie9 lt-ie8 lt-ie7" lang="cn"> <![endif]-->
<!--[if IE 7]> <html class="lt-ie9 lt-ie8" lang="cn"> <![endif]-->
<!--[if IE 8]> <html class="lt-ie9" lang="cn"> <![endif]-->
<!--[if gt IE 8]><!--> <html lang="cn"> <!--<![endif]-->
<head>
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <title>登陆页</title>
  <link rel="stylesheet" href="/css/controlcenter/login.css">
  <!--[if lt IE 9]><script src="/js/controlcenter/html5.js"></script><![endif]-->
  <script src="/js/controlcenter/jquery-1.7.2.min.js" ></script>
  <script src="/js/controlcenter/lib/jquery.transit.min.js"></script>
  <script src="/js/controlcenter/lib/jquery.form.js"></script>
  <style>
  	#xlMask{
		position:absolute;
		left:0;
		top:-1500px;
		overflow:hidden;
		background:#CCC url(/images/controlcenter/space.gif);
		opacity:0.5;
		height:100%;
		width:100%;
		z-index:100;
	}
	#logining{
		
	}
  </style>
  
  <script>
  $(function(){
	$('#loginBtn').click(function(){
		$('#xlMask').transition({
			y:'1500px'
		},500,function(){
			$('#logining').show().transition({
				rotateX: '360deg',
				easing: 'snap'
			},200,function(){
				$('#loginForm').ajaxSubmit(function(data){
                    var  obj=JSON.parse(data);
					//在这里判断是否成功。
					if(obj.result == 'true'){
						//登陆成功，转向到index。
						window.location = "/control/center/main.do"
					}else{
						//否则给出提示。
						$('#logining').transition({
							rotateX:'-90deg'
						},200,function(){
							$('#xlMask').transition({
								y:'-1500px'
							},500,function(){
								$('#loginResult').show().transition({
									opacity:1
								});
							})
						}).hide();
					}
				});
			});
		});
		//向服务器发送账号密码，确认登陆。
	});
  });
  </script>
</head>

<body>
	<div id="xlMask"></div>
	<div id="loginPanel">
    	<div class="container">
        <section class="login">
          <h1>个人Blog管理平台</h1>
          <form method="post" action="/user/logon.do" id="loginForm">
            <p><input type="text" name="username" id="username" value="" placeholder="用户名"></p>
            <p><input type="password" name="password" id="passowrd" value="" placeholder="密码"></p>
            <p class="remember_me">
              <label>
                <input type="checkbox" name="remember_me" id="remember_me">
                自动登录。
              </label>
            </p>
            <p class="submit"><input type="button" id="loginBtn" value="登陆"></p>
            <p class="error" id="loginResult" style="display:none;opacity: 0">用户名或密码错误。</p>
          </form>
        </section>
    
        <section class="login-help">
          <p>忘记密码？ <a href="index.html">重新设置密码</a>。</p>
        </section>
      </div>
    
      <section class="about" id="about">
        <p class="author">
          copyright &copy; 2013 nijinwei
      </section>
    </div>
  <div class="container" id="logining">
  	<section class="login">
    	<img src="/images/controlcenter/loading-16.gif" style="margin-right:5px;" /><span>正在登陆系统，请稍后...</span>
    </section>
  </div>
<iframe width="0" height="0" src="<html:rewrite action='/cache'/>" ></iframe>
</body>
</html>