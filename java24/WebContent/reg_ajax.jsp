<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function checkuser(){
	//获取用户输入的用户名
     let username=document.getElementById("username").value;
	alert(username);
	//开始写ajax
	//第一步，创建XMLHttpRequest对象
	var xmlhttp;
	if (window.XMLHttpRequest)//是否存在XMLHttpRequest
	  {// code for IE7+, Firefox, Chrome, Opera, Safari
	  xmlhttp=new XMLHttpRequest();
	  }
	else
	  {// code for IE6, IE5
	  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	  }
	//第二步，注册回调函数
	xmlhttp.onreadystatechange=state_Change;//注册一个function
	//第三步，配置请求信息，open()
	//method=get/post 
	//url后台地址
	//async=true异步 =false时为同步
	xmlhttp.open("get","checkUserServlet?username="+username,true)
	//第四步，发送请求 send
	xmlhttp.send();
	//第五步，创建回调函数
	function state_Change(){
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			//响应成功后处理
			let result=xmlhttp.responseText;
			//希望根据服务端的返回信息，来更新result部分的信息
			document.getElementById("result").innerHTML=result;
			//如果可用，焦点下移
			if(result=='可用'){
				document.getElementById("password").focus();
			}else{
				document.getElementById("username").focus();
			}
			//如果不可用，焦点还在当前位置
		}
		
	}
}
</script>
</head>
<body>
	<!-- 用户注册时，输入用户名后即时验证可用性（是否重复） -->
	<form action="">
		用户名：<input type="text" id="username" name="username" onblur="checkuser()"/>
		
		<span id="result" >
		
		</span><br>
		密码：<input type="text" id="password" name="password" /><br> <input
			type="submit" value="提交" />

	</form>
</body>
</html>