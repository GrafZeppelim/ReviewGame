

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if (session.getAttribute("username") != null) {
        session.removeAttribute("username");
        session.removeAttribute("typeaccount");
            session.removeAttribute("iduser");
    }
    response.sendRedirect("Home.jsp");
%>