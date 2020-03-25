<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/admin/addGoodsServlet" method="post" enctype="multipart/form-data">
     name:<input type="text" name="goodsName"/><br>
     price:<input type="text" name="goodsPrice"/><br>
     number:<input type="text" name="goodsNumber"/><br>
     picture:<input type="file" name="goodsPic"/><br>
     分类：
     <select name="cateId">
     <c:forEach items="${cateList }" var="cate">
       <option value="${cate.cateId }">${cate.cateName }</option>
     </c:forEach>
     </select><br>
   <input type="submit" value="提交">
   
   
</form>

<img src="<%=request.getContextPath()%>/upload/6d8bcf0d00b84da6a0f6cdae13dc9607.jpg">
</body>
</html>