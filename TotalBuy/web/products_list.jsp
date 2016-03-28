<%-- 
    Document   : products_list.jsp
    Created on : 2016/3/22, 下午 05:53:16
    Author     : PattyTai
--%>

<%@page import="java.util.List"%>
<%@page import="uuu.totalbuy.model.ProductService, uuu.totalbuy.domain.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8" info="產品清單"%>
<%
    ProductService service = new ProductService();
    List<Product> list = service.getAll();
%>
<jsp:include page="/WEB-INF/subviews/header.jsp" >
    <jsp:param name="subtitle" value="<%= this.getServletInfo()%>" />
</jsp:include>
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
                    <img style="width:120px" src="<%= p.getUrl()%>">
                </a>
                <h4>No. <%= String.format("%05d", p.getId())%>, <%= p.getName()%></h4>
                <p>價格: <%= p.getUnitPrice()%> </p>                    
                <a href="cart.html">Add to Cart</a>
            </li>
            <%      }
                        }%>
        </ul>
    </div>
</div>
<%@include file="/WEB-INF/subviews/footer.jsp" %>

