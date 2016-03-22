<%@page import="java.util.List"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <link href="css/totalbuy.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>登入</h1>
        <div id="nav">
            <a href="index.jsp">首頁</a> | 
            <a href="register.html">註冊</a> | 
            <a href="login.jsp">登入</a> | 
            <a href="products_list.html">產品清單</a>
        </div>
        <hr>
        <div id="article">
            <%
                List<String> errors = (List<String>) request.getAttribute("errors");
                if (errors != null && errors.size() > 0) {
            %>
            <div>
                <ul>
                    <% for(String msg:errors){%>
                    <li><%= msg%></li>
                    <% } %>
                </ul>
            </div>
            <%
                }
            %>
            <form method="POST" action="login.do">
                <p>
                    <label for="userid">帳號:</label>
                    <input type="text" id="userid" name="id" placeholder="請輸入帳號" required 
                           value="<%= request.getParameter("id")==null?"":request.getParameter("id") %>">
                </p>
                <p>
                    <label for="pwd">密碼:</label>
                    <input type="password" id="pwd" name="password" placeholder="請輸入密碼" required>            
                </p>
                <p>
                    <img src="images/check_code.jpg" alt="" id="check_image"> <a href="javascript:refresh()">更新圖片</a><br>
                    <label for="check_code">驗證碼:</label>
                    <input type="text" id="check_code" name="check_code" placeholder="請輸入驗證碼" required 
                           value="<%= request.getParameter("check_code")==null?"":request.getParameter("check_code")%>">    
                    <script>
                        function refresh() {
                            var image = document.getElementById("check_image");
                            image.src = "images/check_code.jpg?get=" + new Date();
                        }
                    </script>
                </p>

                <input type="submit" value="確定">
            </form>
        </div>
        <div id="footer">
            版權所有&copy;TotalBuy.com.tw
        </div>        
    </body>
</html>
