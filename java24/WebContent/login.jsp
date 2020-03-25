<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<html lang="en">
<head>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>私人FM</title>
<meta name="description" content="" />
<meta name="keywords" content="" />
<link href="skin/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="skin/css/style.css" rel="stylesheet" type="text/css" media="all" />

<style type="text/css">
	.content {
	    width: 100%;
	    height: 220px;
	    background-repeat: no-repeat; /*图片不能让嗯填充满的时候， 不重复显示*/
	}
	
	.main {
	    width: 360px;
	    height: 300px;
	    float: right; /*将div标签向右对齐*/
	    margin-right: 120px;
	    margin-top: -120px;
	    padding: 20px 20px 30px 20px; /*内边距: 上右下左*/
	    background: white;
	    text-align: center;
	
	}
	
	#registerText {
	    font-size: 20px;
	    font-weight: bold;
	
	}
	
	
	#loginText {
	    float: right; /*div向右偏移*/
	    display: inline; /*块级元素变为行内元素*/
	}
	
	.main input {
	    margin-top: 20px;
	    height: 40px;
	    width: 300px;
	    border: 1px solid darkgray;
	    border-radius: 10px;
	    text-align: left;
	    padding-left: 20px;
	}
	
	
	.main .code {
	    width: 140px;
	}
	
	
	/*  .main input[type='checkbox'] {
	    width: 2px;
	    height: 2px;
	} */
	 
	.main input[type='submit'] {
	    background:black;
	    color: white;
	    border: 1px solid ghostwhite
	    margin-top: 30px;
	    text-align: center;
	}
	
	
	.main a {
	    text-decoration: none;
	    color: #1d94d1;
	    font-size: 13px;
	}
	
	.main #loginText a {
	    color:#1d94d1 ;
	    font-size: 15px;
	}
	
	.footer {
	    width: 100%;
	    height: 100px;
	    text-align: center;
	    padding-top: 50px;
	}
	
	.search {
	    
	    float: right; /*将div标签向右对齐*/
	    margin-right: 20px;
		margin-top: 15px;
		border-color: #333333;
	}
	.red{
	color:red;
	}
</style>
</head>

<body background="jpg/002%20(1).jpg" id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">
<!-- header -->

<div class="header-w3layouts"> 
  <!-- Navigation -->
  <nav class="navbar  navbar-default navbar-fixed-top">
    <div class="container">
      <div class="navbar-jpeg page-scroll">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">  <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
        <h1><a class="navbar-brand" href="index.html" style="">私人FM </a></h1>
		
      </div>
      <!-- Collect the nav links, forms, and other content for toggling -->
      <div class="collapse navbar-collapse navbar-ex1-collapse">
        <ul class="nav navbar-nav navbar-right">
          <!-- Hidden li included to remove active class from about link when scrolled up past about section -->
          <li class="hidden"><a class="page-scroll" href="#page-top"></a></li>
		  <li>
			  <div class="search"><input type="text" class="form-control input-sm no-border rounded" placeholder="搜索 歌曲, 专辑...">
			  </div>
			  </li> 
          <li><a href="page1.html" title="注册" target="blank">注册</a></li> 
          <li><a href="page2.html" title="排行" target="blank">排行</a></li> 
           <li><a href="page3.html" title="电台" target="blank">电台</a></li> 
          <li><a class="page-scroll scroll" href="#exp">主播</a></li>
          <li><a href="page5.html" title="联系" target="blank">联系</a></li> 
        </ul>
      </div>
      <!-- /.navbar-collapse --> 
    </div>
    <!-- /.container --> 
  </nav>
</div>
<%
   //循环cookie
   Cookie[] cookies=request.getCookies();
   if(cookies!=null){
   for(Cookie cookie:cookies){
	   //cookie里关键的两个属性是name value
	   String name=cookie.getName();
	   String value=cookie.getValue();
	   //判断此次循环到的key是否为username
	   if(name.equals("username")){
		   request.setAttribute("username", value);
	   }
	   
	   if(name.equals("password")){
		   request.setAttribute("password", value);
	   }
   }
   }
%>
<div class="tu jarallax" id="home">
  <div class="container">
    <div class="banner-text text-center">
      <h2></h2>
      <div class="content">
          <!--注册表单界面-->
		  <form action="loginServlet" method="post">
          <div class="main">
              <span id="registerText"><strong>登录</strong></span>
              <div id="loginText"><a href="page1.html" title="注册" target="blank">直接注册</a></div>
              <hr/>
              <input type="text" name="username" placeholder="请输入账号"  value="${username }"><br/>
              <input type="password" name="password" placeholder="请输入密码" value="${ password}"><br/>
              记住用户名密码:<input type="checkbox" name="flag" value="1">
              <input type="submit" value="立即登录"><br/>
               <!--我希望在这儿打印错误信息  -->
          <%//脚本段
             //这里可以写java代码
            String msg=(String)request.getAttribute("resultMsg");
          %>
           <!--接下来的这句话相当于out.write -->
           <%if(msg!=null){ %>
          <span class="red"><%=msg %></span>
          <%} %>
          </div>
          </form>
    </div>
	</div>
</div>


</html>