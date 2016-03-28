<%@page pageEncoding="UTF-8" %>
<%@page contentType="text/html" info="歡迎" %>
<jsp:include page="/WEB-INF/subviews/header.jsp" >
    <jsp:param name="subtitle" value="<%= this.getServletInfo()%>" />
</jsp:include>
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
    <p>time out: <%= session.getMaxInactiveInterval()%></p>
    <p>time out: <%= session.getMaxInactiveInterval()%></p>
    <p>time out: <%= session.getMaxInactiveInterval()%></p>
    <p>time out: <%= session.getMaxInactiveInterval()%></p>
    <p>time out: <%= session.getMaxInactiveInterval()%></p>
    <p>time out: <%= session.getMaxInactiveInterval()%></p>
    <p>time out: <%= session.getMaxInactiveInterval()%></p>
    <p>time out: <%= session.getMaxInactiveInterval()%></p>
    <p>time out: <%= session.getMaxInactiveInterval()%></p>
    <p>time out: <%= session.getMaxInactiveInterval()%></p>
    <p>time out: <%= session.getMaxInactiveInterval()%></p>
    <p>time out: <%= session.getMaxInactiveInterval()%></p>
    <p>time out: <%= session.getMaxInactiveInterval()%></p>
    <br><br>
</div>        
<%@include file="/WEB-INF/subviews/footer.jsp" %>