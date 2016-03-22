<%-- 
    Document   : byzero
    Created on : 2016/3/21, 下午 05:22:58
    Author     : PattyTai
--%>

<%@page import="java.text.DateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="/WEB-INF/error.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>By Zero</title>
    </head>
    <body>
        <h1>10/1: <%= 10/1 %></h1>
        <p>生日:<%= DateFormat.getDateInstance().parse("abcd/10/10") %></p>
    </body>
</html>
