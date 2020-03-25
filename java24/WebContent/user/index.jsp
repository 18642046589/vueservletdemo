<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>布克网-书的海洋</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/reset.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style type="text/css">
	#header{
					padding: 0px 50px;
					height: 70px;
					border-bottom: 1px solid gray;
					position: relative;
				}
				#header-left{
					height: 40px;
					font-size: 20px;
					font-weight: 800;
					line-height: 40px;
					float: left;
				}
				#header-logo-text{
					color: #00FFFF;
					font-size: 60px;	
				}
	#header-right{
		float: right;
		height: 40px;
		font-size: 20px;
		font-weight: bold;
		line-height: 30px;
	}
	.dl{
		float: left;
		height:40px;
		line-height:40px ;
	}
	#user{
		float: right;
	}
	ul,li,a{
	    margin:0px;
	    padding:0px;
	    text-decoration: none;
	    list-style: none;
	    color: black;
	} 
	.ull{
				display: none;
				margin-top: auto;
				background-color:ghostwhite;
			}
	#user li:hover .ull{
		display: block;
	}
	 #user .ull li:hover{
		border: 1px solid #2196F3;
		}

		

		.topnav {
		  overflow: hidden;
		  background-color: #e9e9e9;
		  z-index: -999;
		}
		
		.topnav a {
		  float: left;
		  display: block;
		  color: black;
		  text-align: center;
		  padding: 14px 16px;
		  text-decoration: none;
		  font-size: 17px;

		}
		
		.topnav a:hover {
		  background-color: #ddd;
		  color: black;
		}
		
		.topnav a.active {
		  background-color: #2196F3;
		  color: white;
		}
		
		.topnav .search-container {
		  float: right;
		}
		
		.topnav input[type=text] {
		  padding: 6px;
		  margin-top: 8px;
		  font-size: 17px;
		  border: none;
		}
		
		.topnav .search-container button {
		  float: right;
		  padding: 6px 10px;
		  margin-top: 8px;
		  margin-right: 16px;
		  background: #ddd;
		  font-size: 17px;
		  border: none;
		  cursor: pointer;
		}
		
		.topnav .search-container button:hover {
		  background: #ccc;
		}
		
		@media screen and (max-width: 600px) {
		  .topnav .search-container {
		    float: none;
		  }
		  .topnav a, .topnav input[type=text], .topnav .search-container button {
		    float: none;
		    display: block;
		    text-align: left;
		    width: 100%;
		    margin: 0;
		    padding: 14px;
		  }
		  .topnav input[type=text] {
		    border: 1px solid #ccc;  
		  }
		}
		.slide{
			    position: relative;
			    margin: auto;
				width: 750px;
				height: 315px;
			    text-align: center;
			    font-family: Arial;
			    color: #FFF;
			    overflow: hidden;
		}
		.slide ul {
		    margin: 10px 0;
		    padding: 0;
		    width: 9999px;
		    transition: all 1s;
		}
		
		/*//自动播放*/
		.slide .slide-auto {
		    animation: marginLeft 15s infinite;
		}
		
		.slide li {
		    float: left;
		    width: 750px;
		    height: 315px;
		    list-style: none;
		    line-height: 315px;
		    font-size: 36px;
		}
		@keyframes marginLeft {
		    0% {
		        margin-left: 0;
		    }
		
		    28.5% {
		        margin-left: 0;
		    }
		
		    33.3% {
		        margin-left: -750px;
		    }
		
		    62% {
		        margin-left: -750px;
		    }
		
		    66.7% {
		        margin-left: -1500px;
		    }
		
		    95.2% {
		        margin-left: -1500px;
		    }
		
		    100% {
		        margin-left: 0;
		    }
		}
		#bacol{
			position: absolute;
			margin: auto;
			width: 100%;
			height: 325px;
			background-color: #8FF5E8;
			top: 117px;
			 z-index: -999;
			 animation: bc  15s infinite;
		}
		@keyframes bc{
			0% {background-color: #8FF5E8;}
			28.5%{background-color: #8FF5E8;}
			33%{background-color: #A2498D;}
			62%{background-color: #A2498D;}
			66.7%{background-color: #FFA157;}
			95.2%{background-color: #FFA157;}
			100% {background-color: #8FF5E8;}
			
		}
		#p1{
			position: absolute;
			width: 1070px;
			height: 450px;
			border: 1px solid gray;
			top: 461px;
			left:245px;
		}
		.lp1{
			height: 200px;
			width: 170px;
			border: 1px solid gray;
			margin-top: 15px;
			margin-left: 35px;
			float: left;
		}

		#p2{
			position: absolute;
			width: 320px;
			height: 450px;
			border: 1px solid gray;
			top: 461px;
			left:1342px;
		}
		#foot{
			background-color: #CCCCCC;
			position: absolute;
			width: 100%;
			height: 50px;
			line-height: 50px;
			text-align: center;
			top: 930px;
			color: black;
		}
</style>

</head>
<body>
	<div id="header">
		<div id="header-right">
			<div class="dl">
				<a href="reglog.html">登陆/注册</a>
			</div>
			<div id="user">
				<li><img src="<%=request.getContextPath() %>/images/icons8-user-80.png" height="40px "
					weight="40px">
					<ul class="ull">
						<a href="gouwuche.html"><li>购物车</li></a>
						<a href="myboke.html"><li>我的布克</li></a>
					</ul></li>
			</div>
		</div>

		<div id="header-left">
			<a href=""><img src="<%=request.getContextPath() %>/images/icons8-book-shelf-64.png"
				height="64px"></a>
		</div>
		<div id="header-logo-text">
			<a href="homepage.html">布克</a>
		</div>
	</div>
	<div class="topnav">
		<a class="active" href="homepage.html">主页</a> <a href="DianZiShu.html">全部商品分类</a>
		<a href="DianZiShu.html">图书分类</a> <a href="DianZiShu.html">折扣热销</a>
		<div class="search-container">
			<form action="/action_page.php">
				<input type="text" placeholder="搜索.." name="search">
				<button type="submit">
					<i class="fa fa-search"></i>
				</button>
			</form>
		</div>
	</div>
	
	
	<div class="slide">
		<ul class="slide-auto">
		   <!-- 此处做轮播 -->
		   <c:forEach items="${adList }" var="ad">
			<li><a href="#"><img src="<%=request.getContextPath() %>/upload/${ad.filename}"></a></li>
			</c:forEach>
		    <!-- 轮播结束 --> 
		</ul>
	</div>
	
	
	<div id="bacol"></div>
	
	
	
	<div id="p1">
	    <!-- 首页点击排行 -->
	<c:forEach items="${hotList }" var="goods">
		<div id="" class="lp1">
			<a href=""><img src="<%=request.getContextPath() %>/upload/${goods.filename}" width="170px"
				height="200px"></a>
		</div>
    </c:forEach>
	</div>
	
	
	<div id="p2"></div>
	<div id="foot">
		<h2>布克网 项目成员：刘一男 赵沈阳 华伟东 孙宇 于文博</h2>
	</div>
</body>
</html>
