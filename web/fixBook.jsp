<%--
  Created by IntelliJ IDEA.
  User: Fantasia
  Date: 2017/4/19
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改界面</title>
</head>
<body>
<form action="AddServlet" method="post" name="form1">
    <table align="center" width="450">
        <tr>
            <td align="center" colspan="2">
                <h2>欢迎使用图书管理系统</h2>
                <hr>
            </td>
        </tr>
        <tr>
            <td align="right">图书名称：</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td align="right">价格：</td>
            <td><input type="text" name="price"></td>
        </tr>
        <tr>
            <td align="right">数量：</td>
            <td><input type="text" name="bookCount"></td>
        </tr>
        <tr>
            <td align="right">作者：</td>
            <td><input type="text" name="author"></td>
        </tr>
        <tr>
            <td align="center" colspan="2">
                <a href="FindServlet" style="text-decoration: none"><input type="button" value="提交" ></a>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
