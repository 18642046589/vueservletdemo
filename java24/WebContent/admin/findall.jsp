<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
    <html>
<head>
    <meta charset="utf-8">
    <title></title>
    <script>
        //让checkones的选中状态与checkall保持一致
        function selectAll(){
            //step1获取checkall的选中状态
            var checkall=document.getElementById("chkall");
            var flag=checkall.checked;//true/false
            //step2 让checkone状态与上述状态一致
            var checkones=document.getElementsByName("chkone");//集合
            //遍历所有的checkone,使他的状态与上述状态一样
            for(var i=0;i<checkones.length;i++){
                checkones[i].checked=flag;
            }
        }
        function chkOne(){
            var checkall=document.getElementById("chkall");
            var checkones=document.getElementsByName("chkone");
            var flag=true;
            //遍历所有的checkone,如果checkone有一个没有选中,flag=false;
            for(var i=0;i<checkones.length;i++){
                if(!checkones[i].checked){
                    flag=false;
                }
            }
            checkall.checked=flag;
        }
        function  del(){
        	let result=confirm("您确定要删除数据");//返回true/false
        	if(result==true){//确定删除
        		alert("用户确删除,提交到后台");
        	    document.forms[0].submit();
        	}
        	
        }
        
       
    </script>
</head>
<body>
    <form action="<%=request.getContextPath()%>/admin/delAllServlet">
    <input type="checkbox" name="chkall" id="chkall" onclick="selectAll()"/>全选
	<!-- cellpadding相当于padding  cellspacing相当于margin -->
    <table width="100%" border="1" align="center" bordercolor="#dadada" cellpadding="0" cellspacing="1">
    <tr align="center">
    
      <td width="10%" height="25" valign="middle">选择</td>
      <td width="20%" height="25" valign="middle">用户名</td>
      <td width="20%" height="25" valign="middle">电话</td>
      <td width="20%" height="25" valign="middle">权限</td>
      <td width="30%" height="25" valign="middle">操作</td>
    </tr>
    <!-- for循环 for(User user:UserList)
    items  --循环的变量
    var 循环到的对象别名
    -->
    <c:forEach items="${ userList}"  var="user">
    <tr align="center">
      <td  height="25" valign="middle">
          <input type="checkbox" name="chkone" value="${user.id }" onclick="chkOne()"/></td>
      <td  height="25" valign="middle">${user.userName }</td>
      <td  height="25" valign="middle">${user.phone }</td>
      <td  height="25" valign="middle">
       <!-- if(){
       }
       test里写条件，注意用el表达式
      -->
      <c:if test="${user.role=='0' }">
        普通用户
      </c:if>
      <c:if test="${user.role=='1' }">
       管理员
      </c:if>
      </td>
      <td  height="25" valign="middle">
      
      <a href="<%=request.getContextPath()%>/admin/getUserServlet?id=${user.id }">修改</a>
      <a href="<%=request.getContextPath()%>/admin/delByIdServlet?id=${user.id }">删除</a></td>
    </tr>
   </c:forEach>
   <input type="button" value="批量删除" id="btn02" onclick="del()"/>
    </form>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <!--   //总条数
    private int count;
    //每页条数
    private int pageSize=10;
    //总页数
    private int totalPage;
    //当前页的页码
    private int currentPage=1;
    //是否为首页
    private boolean firstPage;
    //是否为尾页
    private boolean lastPage; -->
    <c:if test="${!page.firstPage }">
    <a href="<%=request.getContextPath() %>/admin/findAllUserServlet?pageSize=${page.pageSize }&currentPage=1" > 
    首页
    </a>
     </c:if>
     
      <c:if test="${page.firstPage }">
    
    首页
   
     </c:if>
    <!-- 非首页时才应该显示下一页 -->
   <c:if test="${!page.firstPage }">
   <a href="<%=request.getContextPath() %>/admin/findAllUserServlet?pageSize=${page.pageSize }&currentPage=${page.currentPage-1}" > 上一页 </a>
   </c:if>
   <c:if test="${!page.lastPage }">
   <a href="<%=request.getContextPath() %>/admin/findAllUserServlet?pageSize=${page.pageSize }&currentPage=${page.currentPage+1}" > 下一页  </a>
   </c:if>
    
     <c:if test="${!page.lastPage }">
   <a href="<%=request.getContextPath() %>/admin/findAllUserServlet?pageSize=${page.pageSize }&currentPage=${page.totalPage}" > 最后一页  </a>
   </c:if>
     <c:if test="${page.lastPage }">
  最后一页
   </c:if>
    
</body>