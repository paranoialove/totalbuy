<%-- 
    Document   : login_ok
    Created on : 2016/3/22, 下午 12:22:34
    Author     : PattyTai
--%>

<%@page import="uuu.totalbuy.domain.Customer"%>
<%@page pageEncoding="UTF-8" info="登入成功"%>
<!DOCTYPE html>
<html>
<head>
    <title><%= this.getServletInfo() %></title>
</head>
<body>
    <%
        Customer user = (Customer)request.getAttribute("user");
    %>
<h1>TotalBuy購物網</h1>
<h2><%= this.getServletInfo() %>!<%= user!=null?user.getName():""%></h2>
<p>線上人次共有: <%= application.getAttribute("app.login.count") %></p>
</body>
</html>
