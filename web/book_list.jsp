<%@ page import="java.util.List" %>
<%@ page import="findBook.Book" %><%--
  Created by IntelliJ IDEA.
  User: Fantasia
  Date: 2017/4/18
  Time: 23:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>书架界面</title>
    <script language="JavaScript">
        function chose() {
            document.
        }
    </script>
</head>
<body>
<table align="center" width="450" border="1">
    <tr>
        <td align="center" colspan="6">
            <h2>所有图书信息</h2>
        </td>
    </tr>
    <tr align="center">
        <td><b>ID</b></td>
        <td><b>图书名称</b></td>
        <td><b>价格</b></td>
        <td><b>数量</b></td>
        <td><b>作者</b></td>
        <td><b>删除</b></td>
    </tr>
    <%
        List<Book> list=(List<Book>)request.getAttribute("list");
        if (list==null||list.size()<1){
            out.print("没有数据！");
        }else {
            for (Book book:list){
    %>
    <tr>
        <td><%=book.getId()%></td>
        <td><%=book.getName()%></td>
        <td><%=book.getPrice()%></td>
        <td><%=book.getBookCount()%></td>
        <td><%=book.getAuthor()%></td>
        <td align="center">
            <a href="DeleteServlet?id=<%=book.getId()%>" style="text-decoration: none"><input type="button" value="删除" ></a>
        </td>
    </tr>
    <%
            }
        }
    %>

    <form action="fixBook.jsp" method="post">
        <table align="center">
            <tr>
                <td><input type="hidden" name="hname" value=""></td>
            </tr>
        </table>
    </form>

</table>
</body>
</html>
