
<%@page import="Model.PostModel"%>
<%@page import="Model.AccountModel"%>
<%@page import="ObjecInfo.Comment"%>
<%@page import="Model.CommentModel"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%

    CommentModel cm = new CommentModel();
    AccountModel am = new AccountModel();
    PostModel pm = new PostModel();
    String s = "";
    String sortColumn = "";
    int idPost = 1;

    if (request.getParameter("idPost") != null) {
        idPost = Integer.parseInt(request.getParameter("idPost"));
    }

    String Username = request.getParameter("userNameOfAccount");

    
    int idUser = am.getAccountIDByName(Username);

    String Content = request.getParameter("Content");


    cm.insertComment(idPost, idUser, Content);

    response.sendRedirect("BlogPost.jsp?idPost=" + idPost);

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <h1>cac</h1>

    </body>
</html>
