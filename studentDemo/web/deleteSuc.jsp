<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    		<font size="6">删除成功</font>
    		<br />
    		<font size="4">删除信息如下</font>
    		<table border="0" cellspacing="0" cellpadding="0">
    			<tr><td>学号：</td><td><%=request.getParameter("sno")%></td></tr>
    		</table>
			<font size="4">跳转到<a href="searchStudent.html">搜索</a>界面</font>
 	</body>
</html>