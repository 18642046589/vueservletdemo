<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

${resultMsg }
<form action="<%=request.getContextPath() %>/admin/userUpdateServlet" method="post">
     <!-- 此次不修改密码
     update t_user set username=?,email=?,phone=?,birthday=? where id=?
     
      -->
       用户名：<input type="text" name="username" value="${loginUser.userName }" readonly/><br>
       邮箱：<input type="text" name="email" value="${loginUser.email }"/><br> 
       电话：<input type="text" name="phone" value="${loginUser.phone }"/><br> 
       生日：<input type="date" name="birthday" value="${loginUser.birthday }"/><br> 
    <input type="hidden" name="id" value="${loginUser.id }"/>
    <input type="hidden" name="role" value="${loginUser.role }"/>
   <input type="submit" value="提交"/>   
</form>
</body>
</html>