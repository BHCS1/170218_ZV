<!-- Pomeisl Ferenc-->
<!-- Kovács Zoltán-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="auth" class="jsp.AuthBean" scope="session"/>
<%@page import="java.util.ArrayList"%>
<%@page import="model.XmlLog"%>
<%@page import="jsp.LogDatasSort"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.sql.Timestamp"%>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/c3.min.css" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/d3/3.5.17/d3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/c3.min.js"></script>

<% if(!auth.isloggedIn() || !auth.hasPermission("log")) {
  response.sendRedirect(request.getContextPath()+"/authentication/login.jsp");
  return;
} %>

<jsp:include page="/layout/head.jsp"></jsp:include>

<% ArrayList<String[]> logs = XmlLog.getXmlContent(); %>
<div class="page-header">
    <h1>Logs</h1>
    <table class="table table-striped table-hover table-condensed">
        <thead>
        <tr>
            <th>Time(<a href="?time=asc"><i class="fa fa-arrow-circle-down" aria-hidden="true"></i></a>/<a href="?time=desc"><i class="fa fa-arrow-circle-up" aria-hidden="true"></i></a>)</th>
            <th>User(<a href="?user=asc"><i class="fa fa-arrow-circle-down" aria-hidden="true"></i></a>/<a href="?user=desc"><i class="fa fa-arrow-circle-up" aria-hidden="true"></i></a>)</th>
            <th>Type(<a href="?type=asc"><i class="fa fa-arrow-circle-down" aria-hidden="true"></i></a>/<a href="?type=desc"><i class="fa fa-arrow-circle-up" aria-hidden="true"></i></a>)</th>
            <th>Datas</th>
        </tr>
    </thead>
    <tbody>
        <% 
        if(request.getParameter("time") != null){
            String dir = request.getParameter("time");
            logs = LogDatasSort.sort(logs, "time", dir);
            }
            if(request.getParameter("user") != null){
            String dir = request.getParameter("user");
            logs = LogDatasSort.sort(logs, "user", dir);
            }
            if(request.getParameter("type") != null){
            String dir = request.getParameter("type");
            logs = LogDatasSort.sort(logs, "type", dir);
            }
        for (int i = 0; i < logs.size(); i++) {%>
        <tr>
             <%
               long dateLong = Long.parseLong(logs.get(i)[0]);
               String date = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM).format(new Date(dateLong));
             %>
            <td title="Time"><%= date %>
            </td>
            <td title="User"><%= logs.get(i)[1] %></td>
            <td title="Type"><%= logs.get(i)[2] %></td>
            <td title="Datas"><% 
                if(logs.get(i)[7] != "") { %> 
                Employee: <%= logs.get(i)[7] %>
                <% }
                if(logs.get(i)[3] != "") { %>
                From: <%= logs.get(i)[3] %>
                <% }
                if(logs.get(i)[4] != "") { %> 
                To: <%= logs.get(i)[4] %>
                <% }
                if(logs.get(i)[5] != "") { %> 
                SQL: <%= logs.get(i)[5] %>
                <%
                }
                %></td>
        </tr>
        <% } %>
    </tbody>
    </table>
</div>

<jsp:include page="/layout/foot.jsp"></jsp:include>  