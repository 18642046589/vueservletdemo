<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function findUser(){
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
	xmlhttp.open("get","user.js",true)
	//第四步，发送请求 send
	xmlhttp.send();
	//第五步，创建回调函数
	function state_Change(){
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			//响应成功后处理
			let result=xmlhttp.responseText;//普通文本或json格式的文本
	        let users=JSON.parse(result);//对象数组 掌握  字符串转成对象
	        //let users=eval('('+result+')'); 
	         //let str=JSON.stringify(users);//对象转成字符串
	        for (var i = 0; i < users.length; i++) {
	        	let user=users[i];
	        	appendRow(user.username,user.age);
			}
		}
	}
	
	 // 添加新行
    function appendRow(username, age) {
        var ui = document.getElementById("userinfo");
        // 添加新行
        //alert(ui.rows.length);
        var newRow = ui.insertRow(ui.rows.length);//1,2
        // 添加新的单元格
        newRow.insertCell(0).innerHTML = username;
        newRow.insertCell(1).innerHTML = age;
    }
}
</script>
</head>
<body>
	<input type="button" value="加载所有用户" onclick="findUser()" />
	<table id="userinfo" cellpadding=0 cellspacing=0 border=1 width="600px">
		<thead>
			<tr>
				<th>用户名</th>
				<th>年纪</th>
			</tr>
		</thead>
	</table>

</body>
</html>