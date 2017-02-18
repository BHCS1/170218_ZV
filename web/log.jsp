<%-- 
    Document   : log
    Created on : 2017.02.18., 9:11:26
    Author     : ferenc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="auth" class="jsp.AuthBean" scope="session"/>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/c3.min.css" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/d3/3.5.17/d3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/c3.min.js"></script>

<% if(!auth.isloggedIn() || !auth.hasPermission("log")) {
  response.sendRedirect(request.getContextPath()+"/authentication/login.jsp");
  return;
} %>

<jsp:include page="/layout/head.jsp"></jsp:include>

<div class="page-header">
    <h1>Log</h1>
</div>

<jsp:include page="/layout/foot.jsp"></jsp:include>  