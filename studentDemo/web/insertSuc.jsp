<%--
  Created by IntelliJ IDEA.
  User: xuzhipeng
  Date: 2018/6/22
  Time: 下午8:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
</head>
<body>
<font size="7">添加成功</font>
<br />
<font size="4">添加的信息如下</font>
<br />
<table border="0" cellspacing="0" cellpadding="0">
    <tr><td><font size="3">学号：</font></td><td id="sno"><%=request.getParameter("sno")%></td></tr>
    <tr><td><font size="3">姓名：</font></td><td id="sname"><%=request.getParameter("sname")%></td></tr>
    <tr><td><font size="3">语文：</font></td><td id="chinese"><%=request.getParameter("chinese")%></td></tr>
    <tr><td><font size="3">数学：</font></td><td id="math"><%=request.getParameter("math")%></td></tr>
    <tr><td><font size="3">英语：</font></td><td id="english"><%=request.getParameter("english")%></td></tr>
</table>
<font size="4">继续<a href="insert.html">添加</a>下一个学生信息</font>
<br />
<font size="4">跳转到<a href="searchStudent.html">搜索界面</a></font>
</body>
</html>
