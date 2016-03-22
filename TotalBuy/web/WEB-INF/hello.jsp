<%@ page import="java.util.Date" buffer="2kb" autoFlush="true"%>
<%@ page pageEncoding='utf-8' info="JSP Demo" contentType="text/html;charset=big5" %>
<!DOCTYPE html>

<%-- JSP comment, 只能在JSP看到 --%>
<!-- html comment, 能在JSP, java, html-->
<%
    // java comment , 能在jsp, java看到, html看不到
%>
<html>
    <head>
        <meta charset="utf-8">
        <title><%= this.getServletInfo() %></title>
        <script>
            //JS comment, 能在JSP, java, js看到
        </script>
        <style>
            /*body{margin:0}  能在JSP, java, css看到*/            
        </style>
    </head>
    <body>
        <%!
            private int i = 100;   //member variable
            private String welcome = "Hello";

            public void jspInit() {
                System.out.println(this.getServletName() + " created...");
                String welcome = this.getInitParameter("welcome");
                if (welcome != null) {
                    this.welcome = welcome;
                }
            }

            public void jspDestroy() {
                System.out.println(this.getServletName() + "was destroyed...");
            }
        %>

        <%
            int i = 1; //local variable            
%>
        <h1><%= this.getInitParameter("welcome")%>, <%= this.getServletInfo() %> at <%= request.getContextPath()%></h1>
        <p>現在時間: <%= new Date()%></p>
        <p>Browser: <%= request.getHeader("user-agent")%></p>
        <p>屬性 i: <%= this.i%></p>
        <p>區域變數 i: <%= i%></p>
        <% 
            out.flush(); 
            Thread.sleep(1000);
        %>
        <h2>JSP implicit variables:</h2>
        user-agent: <%= request.getHeader("user-agent")%><br>
        context-path: <%= request.getContextPath()%><br>
        Request URL: <%= request.getRequestURL()%><br>
        Protocol: <%= request.getProtocol()%><br>
        Remote Addr: <%= request.getRemoteAddr()%><br>
        Server Name <%= request.getServerName()%><br>
        Server Port: <%= request.getServerPort()%><br>

        <br>
        <hr>
        <br>
        session id: <%= session.getId() %><br>
        Creation Time: <%= session.getCreationTime()%><br>
        Last Accessed Time: <%= session.getLastAccessedTime()%><br>
        Max Inactive Interval: <%= session.getMaxInactiveInterval()%><br>        
        
        <br>
        <hr>
        <br>

        request context path: <%= ((HttpServletRequest)pageContext.getRequest()).getHeader("user-agent") %>
    </body>
</html>

