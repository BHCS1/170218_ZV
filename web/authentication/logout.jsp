<%@page import="model.XmlLog"%>
// Berényi Lajos

<%@page import="jsp.AuthBean" contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="auth" class="jsp.AuthBean" scope="session"/>
<%
  String username = auth.getUsername();
  auth.logout();
  XmlLog.logLogout(username);
  session.invalidate();
  response.sendRedirect("login.jsp");
%>