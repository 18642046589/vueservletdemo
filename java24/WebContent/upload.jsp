<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<body>
    <p>${msg}</p>
        <form action="UploadServlet" method="post" enctype="multipart/form-data">
            name:<input type="text" name="name"/><br>
            email:<input type="text" name="email"/><br>
            上传文件： <input type="file" name="f1" multiple="multiple"> <br> 
            <input type="submit" value="上传"><br> 
        </form>
</body>
</body>
</html>