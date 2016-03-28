<%-- 
    Document   : byzero
    Created on : 2016/3/21, 下午 05:22:58
    Author     : PattyTai
--%>

<%@page import="java.text.DateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="/WEB-INF/subviews/header.jsp" >
    <jsp:param name="subtitle" value="<%= this.getServletInfo()%>" />
</jsp:include>
<div id="article">
    <h1>10/1: <%= 10 / 1%></h1>
    <p>生日:<%= DateFormat.getDateInstance().parse("abcd/10/10")%></p>
</div>
<%@include file="/WEB-INF/subviews/footer.jsp" %>
