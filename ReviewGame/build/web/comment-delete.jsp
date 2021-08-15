

<%@page import="Model.CommentModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    CommentModel cm = new CommentModel();
    int id = Integer.parseInt(request.getParameter("idComment"));
    int p = 1;
    String s = "";
    if (request.getParameter("s") != null) {
        s = request.getParameter("s");
    }
    if (request.getParameter("page") != null) {
        p = Integer.parseInt(request.getParameter("page"));
    }
    boolean check = cm.deleteComment(id);
    if (check == true) {
        response.sendRedirect("CommentAdmin.jsp?page=" + p + "&s=" + s);
    }%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
