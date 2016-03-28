<%@page contentType="text/html" isErrorPage="true"%>
<%@page pageEncoding="UTF-8" info="系統錯誤"%>
<jsp:include page="/WEB-INF/subviews/header.jsp" >
    <jsp:param name="subtitle" value="<%= this.getServletInfo()%>" />
</jsp:include>
<div id="article">
    <script>
        var s1 = "block";
        var s2 = "width:80%;display:blocked;font-size:60%;color:blue";
        function show_details() {
            var d = document.getElementById("details");
            try {
                d.style.setAttribute("display", s1);
                if (s1 == "none") {
                    s1 = "block";
                } else {
                    s1 = "none";
                }
            } catch (err) {
                d.setAttribute("style", (s2 == null ? "width:80%;display:none;" : s2));
                if (s2 == null) {
                    s2 = "width:80%;display:blocked;font-size:60%;color:blue";
                } else {
                    s2 = null;
                }
            }
        }
    </script>
    <h3 style='font-size:80%'>
        執行<span style='color:darkred'> <%= request.getAttribute("javax.servlet.error.request_uri")%> </span>時發生下列錯誤：
        <% if (exception != null) {
                out.println(exception.getClass().getName() + ":\t" + exception.getMessage());%>
        <br/>
        <a href="javascript:show_details()">details...</a><br/>
        <span id='details' style="width:60%;display:none;color:blue">
            <%
                this.log("網頁" + request.getAttribute("javax.servlet.error.request_uri") + "執行失敗", exception);
                exception.printStackTrace(new java.io.PrintWriter(out));
            %>
        </span>
        <% } else {
            Integer errorCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
            if (errorCode != null) {
        %>
        <img src="<%=request.getContextPath()%>/images/<%=errorCode%>.png" alt="">
        <%
                }
            }%>
    </h3>
</div>
<%@include file="/WEB-INF/subviews/footer.jsp" %>