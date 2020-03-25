<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/userinformation.css"/>
</head>

<body>
		<div id="information_box">
		     用户名：${loginUser.userName }<br>
		     邮箱：${loginUser.email} <br>
		     生日：<input type="text" name="userinformation_name" id="userinformation_name" value="${loginUser.birthday }" readonly/><br>
		     电话：<input type="text" name="userinformation_name" id="userinformation_name" value="${loginUser.phone }" readonly/><br>
		    权限：<input type="text" name="userinformation_name" id="userinformation_name" value="${loginUser.role }" readonly/><br>
		</div>
		
	</body>

</html>