

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if (session.getAttribute("username") == null) {
%>
<script type="text/javascript">
    function alertName() {
        alert("Username or password incorrect!! ");
    }
</script>
<script type="text/javascript"> window.onload = alertName;</script>

<%@include file = "login.jsp" %>
<%} else if (session.getAttribute("username") != null & session.getAttribute("typeaccount").equals("0")) {
%>
<%@include file = "dashboard.jsp" %>
<%} else if (session.getAttribute("username") != null & session.getAttribute("typeaccount").equals("2")) {
%>
<%@include file = "Home.jsp" %>
<%  }

%>
