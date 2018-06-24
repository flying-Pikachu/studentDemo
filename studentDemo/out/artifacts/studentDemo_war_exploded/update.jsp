<%--
  Created by IntelliJ IDEA.
  User: xuzhipeng
  Date: 2018/6/22
  Time: 下午10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="css/update.css" />
    <title></title>
</head>
<body>
<table>
    <h1 colspan="3">修改学生信息画面</h1>
    <form action="StudentUpd" method="post">
    <tr>

        <td>学号</td>
        <td><input class="" readonly id="sno" name="sno" type = "text" value=<%=request.getParameter("sno")%>></td>
        <td></td>
    </tr>
    <tr>
        <td>姓名</td>
        <td><input  class="" id="sname" name="sname" type = "text" value=<%=request.getParameter("sname")%>></td>
        <td>*请输入正确的名字</td>
    </tr>
    <tr>
        <td>语文成绩</td>
        <td><input class="" id="chinese" name="chinese" type = "text" value=<%=request.getParameter("chinese")%>></td>
        <td>*0~150</td>
    </tr>
    <tr>
        <td>数学成绩</td>
        <td><input  class="" id="math" name="math" type = "text" value=<%=request.getParameter("math")%>></td>
        <td>*0~150</td>
    </tr>
    <tr>
        <td>英语成绩</td>
        <td><input  class="" id="english" name="english" type = "text" value=<%=request.getParameter("english")%>></td>
        <td>*0~150</td>
    </tr>
    <tr>
        <td></td>
        <td>
                <input type="submit" class="btn" value="修改"/>
        </td>
        <td>
            <a href="searchStudent.html">搜索画面</a>
        </td>
    </tr>
    </form>
</table>
</body>
</html>

