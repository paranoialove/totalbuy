<%-- 
    Document   : 99
    Created on : 2016/3/21, 上午 11:25:39
    Author     : PattyTai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>99乘法表</title>
        <style>
            table, tr, td{padding:1em; border: gray solid thin}
        </style>
    </head>
    <body>
        <h1>99乘法表</h1>
        <table>
            <%for (int i = 1; i < 10; i++) { %>
            <tr>
                <% for (int j = 1; j < 10; j++) { %>
                <td><%= i %> * <%= j %> = <%= i*j %></td>
                <% } %>
            </tr>
            <% } %>
        </table>
    </body>
</html>
