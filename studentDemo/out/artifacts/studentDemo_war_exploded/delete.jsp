<%--
  Created by IntelliJ IDEA.
  User: xuzhipeng
  Date: 2018/6/22
  Time: 下午10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/delete.css"/>
    <title>删除学生信息</title>
</head>
<body>
<table>
    <h1 colspan="3">删除学生信息画面</h1>
    <tr>
        <td>学号</td>
        <form action="StudentDel" method="post">
        <td>
            <input id="sno" name="sno" type = "text" value=<%=request.getParameter("sno")%>>
            <input type="hidden" id="ssno" name="ssno" value=<%=request.getParameter("sno")%>>
        </td>
    </tr>
    <tr>
        <td></td>
        <td>

                <input type="submit" class="btn" value="删除"/>
        </td>
        <td>
            <a href="searchStudent.html">搜索画面</a>
        </td>
        </form>
    </tr>
</body>
</html>

