<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HOS用户首页</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/reset.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/userMainMenu.css" />
<script type="text/javascript" src="<%=request.getContextPath() %>/js/btn.js">
	
</script>
</head>
<body>
		<div id="main">
			<div id="top">
				<div class="top_left">
					<a href="http://127.0.0.1:8848/project_demo/MainMenu.html" target="_self"><h1>Home Office System√</h1></a>
				</div>
				<div class="top_right">
					<ul>
					<li>在线：${onlinenumber}当前：${loginUser.userName }</li>
						<a href="<%=request.getContextPath() %>/logoutServlet"><li>退出</li></a>
						<a href=""><li>设置</li></a>
					</ul>
				</div>
			</div>
			<div id="main_menu">
				<div id="left_nav">
					<ul>
						<li class="sub_nav">
							<span>
								<details>
								<summary><strong>个人信息管理</strong></summary>
								<a href="userinformation.jsp" target="iframebox"><p>查看个人信息</p></a>
								<a href="updateuser.jsp" target="iframebox"><p>修改个人信息</p></a>
								</details>
							</span>
						</li>
						<li class="sub_nav">
							<span>
								<details>
								<summary><strong>用户信息管理</strong></summary>
								<a href="<%=request.getContextPath() %>/admin/findAllUserServlet?pageSize=10&currentPage=1" target="iframebox"><p>用户信息列表</p></a>
								
								</details>
							</span>
						</li>
						
						<li class="sub_nav">
							<span>
								<details>
								<summary><strong>商品管理</strong></summary>
								<a href="<%=request.getContextPath() %>/admin/preAddGoodsServlet" target="iframebox"><p>商品添加</p></a>
								
								</details>
							</span>
						</li>
						<li class="sub_nav">
							<span>
								<details>
								<summary><strong>代办事项管理</strong></summary>
								<a href=""><p>查看未读公告</p></a>
								<a href=""><p>当前任务</p></a>
								<a href=""><p>当前重大项目</p></a>
								<a href=""><p>查看当月完成度</p></a>
								<a href=""><p>待添加</p></a>
								</details>
							</span>
						</li>
						<li class="sub_nav">
							<span>
								<details>
								<summary><strong>出勤管理</strong></summary>
								<a href=""><p>个人考勤情况</p></a>
								<a href=""><p>出差申请</p></a>
								<a href=""><p>请假申请</p></a>
								<a href=""><p>待添加</p></a>							
								</details>
							</span>
						</li>
						<li class="sub_nav">
							<span>
								<details>
								<summary><strong>考评与反馈管理</strong></summary>
								<a href=""><p>考评入口</p></a>
								<a href=""><p>考评成绩查看</p></a>
								<a href=""><p>向经理反馈</p></a>
								<a href=""><p>待添加</p></a>							
								</details>
							</span>
						</li>
					</ul>
				</div>
				<!-- 右侧 -->
				<iframe name="iframebox" scrolling="no" frameborder="no">
				
				
				</iframe>
			</div>
		</div>
	</body>
</html>