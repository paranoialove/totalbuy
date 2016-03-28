<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uuu.totalbuy.domain.Customer"%>
<!DOCTYPE html>
<html>
    <head>
        <title><%= request.getParameter("subtitle")!=null?request.getParameter("subtitle"):"歡迎光臨"  %></title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!--        <meta http-equiv="refresh" content="10; url=http://www.uuu.com.tw"/>-->
        <link href="<%=application.getContextPath()%>/css/totalbuy.css" rel="stylesheet" type="text/css"/>
        <script src="<%=application.getContextPath()%>/js/jquery.js" type="text/javascript"></script>
        <script>
            function logout() {
                $.ajax({
                    url: "<%= (application.getContextPath() + "/user/logout.do")%>",
                    method: "POST"
                }).done(doneHandler);
            }

            function doneHandler(msg) {
                alert(msg);
                $("#user_span").html('<a href="<%=application.getContextPath()%>/register.jsp">註冊</a> | ' +
                        '<a href="<%=application.getContextPath()%>/login.jsp">登入</a> | ');
                $("#user_data").text('');
                //....
            }
        </script>
    </head>
    <body>
        <div id="header">
            <%
                Customer user = (Customer) session.getAttribute("user");
            %>
            <h1><%= application.getInitParameter("app-name")%></h1>
            <h2><%= request.getParameter("subtitle")!=null?request.getParameter("subtitle"):"歡迎光臨"  %></h2>
            <div style="text-align:right; font-size: medium"><%= this.getServletInfo()%>!<span id="user_data"><%= user != null ? user.getName() : ""%></span>
                拜訪人次: <%= application.getAttribute("app.visitors.count")%><br></div>
        </div>
        <div id="nav">
            <span>
                <a href="<%=(application.getContextPath() + "/index.jsp")%>">首頁</a> | 
                <span id="user_span">
                    <%
                        if (user == null) {
                    %>
                    <a href="<%=application.getContextPath()%>/register.jsp">註冊</a> | 
                    <a href="<%= (application.getContextPath() + "/login.jsp")%>">登入</a> | 
                    <%} else {%>
                    <a href="javascript:logout()">登出</a> | 
                    <a href="<%=application.getContextPath()%>/user/update.jsp">修改</a> |                    
                    <a href="<%=application.getContextPath()%>/user/history.html">訂單歷史</a> |
                    <%}%>
                </span>
                <a href="<%=application.getContextPath()%>/products_list.jsp">產品清單</a> |             
                <a href="<%=application.getContextPath()%>/cart.html">購物車</a> |            
            </span>
            <a href="<%=application.getContextPath()%>/test/map.html">地圖</a> |
            <a href="<%= (application.getContextPath() + "/hello.jsp")%>">Hello.jsp</a> |
        </div>
        <hr>
