<%@page pageEncoding="UTF-8"%>
<%@page import="java.util.List" info="會員登入"%>
<jsp:include page="/WEB-INF/subviews/header.jsp" >
    <jsp:param name="subtitle" value="<%= this.getServletInfo() %>" />
</jsp:include>

        <div id="article">
            <%
                List<String> errors = (List<String>) request.getAttribute("errors");
                if (errors != null && errors.size() > 0) {
            %>
            <div>
                <ul>
                    <% for (String msg : errors) {%>
                    <li><%= msg%></li>
                        <% } %>
                </ul>
            </div>
            <%
                }

                Cookie[] cookies = request.getCookies();
                String cookieUserId = "";
                String cookieMemory = "";
                if (cookies != null && cookies.length > 0) {
                    for (Cookie c : cookies) {
                        if (c != null) {
                            if (c.getName().equals("user_id")) {
                                cookieUserId = c.getValue();
                            } else if (c.getName().equals("memory")) {
                                cookieMemory = c.getValue();
                            }
                        }
                    }
                }
            %>
            <form method="POST" action="login.do">
                <p>
                    <label for="userid">帳號:</label>
                    <input type="text" id="userid" name="id" placeholder="請輸入帳號" required 
                           value="<%= request.getParameter("id") == null ? cookieUserId : request.getParameter("id")%>">
                    <input type="checkbox" name="memory" <%= cookieMemory%>><label for="memory">記住帳號</label>
                </p>
                <p>
                    <label for="pwd">密碼:</label>
                    <input type="password" id="pwd" name="password" placeholder="請輸入密碼" required>            
                </p>
                <p>
                    <img src="images/check_code.jpg" alt="" id="check_image"> <a href="javascript:refresh()">更新圖片</a><br>
                    <label for="check_code">驗證碼:</label>
                    <input type="text" id="check_code" name="check_code" placeholder="請輸入驗證碼" required 
                           value="<%= request.getParameter("check_code") == null ? "" : request.getParameter("check_code")%>">    
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
<%@include file="/WEB-INF/subviews/footer.jsp" %>
