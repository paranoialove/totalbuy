<%@page pageEncoding="UTF-8" %>
<%@page contentType="text/html" %>

<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset='UTF-8'>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!--        <meta http-equiv="refresh" content="10; url=http://www.uuu.com.tw"/>-->
        <link href="css/totalbuy.css" rel="stylesheet" type="text/css"/>
        <script>
            var user = "John";
            function addCart() {
                if (user) {
                    location.href = "http://www.google.com";
                } else {
                    alert("請先登入後再購物!");
                }
            }
        </script>

    </head>
    <body>
        <div id="header">
            <h1>首頁</h1>
        </div>
        <div id="nav">
            <span>
                <a href="<%=application.getContextPath()%>/index.jsp">首頁</a> | 
                <a href="<%=application.getContextPath()%>/register.html">註冊</a> | 
                <a href="<%=application.getContextPath()%>/login.jsp">登入</a> | 
                <a href="<%=application.getContextPath()%>/products_list.html">產品清單</a> |             
                <a href="<%=application.getContextPath()%>/cart.html">購物車</a> |            
            </span>
            <span>
                <a href="<%=application.getContextPath()%>/user/logout.html">登出</a> | 
                <a href="<%=application.getContextPath()%>/user/update.html">修改</a> |
                <a href="<%=application.getContextPath()%>/user/check_out.html">結帳</a> |
                <a href="<%=application.getContextPath()%>/user/history.html">訂單歷史</a> |
            </span>
            <a href="<%=application.getContextPath()%>/test/map.html">map</a>
        </div>
        <div id="article">
            <div id="demo">Welcome</div>
            <a href="javascript:addCart()">Add To Cart</a>
            <!--        <p>10秒後將轉址到<a href="http://www.uuu.com.tw">http://www.uuu.com.tw</a>-->
            <script>
                /*
                 document.getElementById("demo").innerHTML =
                 "Page location is: " + location.href;
                 location.href = "http://www.google.com";
                 */
            </script>     
        </div>
        <div id="footer">
            版權所有&copy;TotalBuy.com.tw
        </div>        
    </body>
</html>
