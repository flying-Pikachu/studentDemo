<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    		<font size="6">修改成功</font>
    		<br />
    		<font size="4">修改的信息如下</font>
		<br />
		<table border="0" cellspacing="0" cellpadding="0">
			<tr><td><font size="3">学号：</font></td><td><%=request.getParameter("sno")%></td></tr>
			<tr><td><font size="3">姓名：</font></td><td><%=request.getParameter("sname")%></td></tr>
			<tr><td><font size="3">语文：</font></td><td><%=request.getParameter("chinese")%></td></tr>
			<tr><td><font size="3">数学：</font></td><td><%=request.getParameter("math")%></td></tr>
			<tr><td><font size="3">英语：</font></td><td><%=request.getParameter("english")%></td></tr>
		</table>
		<br />
		<font size="4">跳转到<a href="searchStudent.html">搜索界面</a></font>
 	</body>
</html>