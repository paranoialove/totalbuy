<%-- 
    Document   : products_list.jsp
    Created on : 2016/3/22, 下午 05:53:16
    Author     : PattyTai
--%>

<%@page import="java.util.List"%>
<%@page import="uuu.totalbuy.model.ProductService, uuu.totalbuy.domain.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<%
    ProductService service = new ProductService();
    List<Product> list = service.getAll();

%>
<html>
    <head>
        <title>產品清單</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/totalbuy.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="header">
            <h1>產品清單</h1>
            <hr>
        </div>
        <div id="nav">
            <a href="index.jsp" title="點選即連結至首頁">首頁</a> | 
            <a href="register.jsp" title="註冊新會員">註冊</a>        | 
            <a href="login.jsp" title="會員登入">登入</a> | 
            <a href="products_list.html">產品清單</a> | 
            <a href="test/map.html" title="測試Google Geocoder">map</a>
            <hr>
        </div>
        <div id="article">
            <form style="text-align: right">
                <input type="search" name="search" placeholder="請輸入產品代號或部分名稱..." style="width: 85%">
                <input type="submit" value="查詢">
            </form>            
            <div id="product_div">
                <ul>
                    <% if (list != null && list.size() > 0) {
                            for (Product p : list) {
                    %>
                    <li class="product_item">
                        <a href="product.html?p_id=1">
                            <img style="width:120px" src="<%= p.getUrl() %>">
                        </a>
                        <h4>No. <%= String.format("%05d", p.getId())%>, <%= p.getName() %></h4>
                        <p>價格: <%= p.getUnitPrice()%> </p>                    
                        <a href="cart.html">Add to Cart</a>
                    </li>
                    <%      }
                       } %>
                </ul>
            </div>
        </div>
        <div id="footer">
            版權所有&copy;TotalBuy.com.tw
        </div>
    </body>
</html>

