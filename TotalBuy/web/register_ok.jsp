<%-- 
    Document   : register_ok
    Created on : 2016/3/22, 下午 03:58:29
    Author     : PattyTai
--%>

<%@page import="uuu.totalbuy.domain.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8" info="註冊成功"%>
<%
    Customer c = (Customer)request.getAttribute("customer");
%>
<!DOCTYPE html>
<html>
    <head>
        <title><%= this.getServletInfo() %></title>
    </head>
    <body>
        <h1><%= application.getInitParameter("app-name")%></h1>        
        <h2><%= this.getServletInfo() %>: <%= (c==null ? "" : c) %></h2>
    </body>
</html>
