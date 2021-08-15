
<%@page import="Model.PostModel"%>
<%@page import="ObjecInfo.Game"%>
<%@page import="Model.GameModel"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%

    PostModel pm = new PostModel();

    Object title =request.getAttribute("title");
    String titlePost = title.toString();

    Object file = request.getAttribute("file");
    String picture = file.toString();

    Object video = request.getAttribute("video");
    String videoGame = video.toString();

    Object content = request.getAttribute("content");
    String contentPost = content.toString();

    int idGame = Integer.parseInt((String) request.getAttribute("gamelist"));
    int idAccount = Integer.parseInt((String) request.getAttribute("accountlist"));
    pm.insertPost(idAccount, idGame, contentPost, titlePost, picture, videoGame);
    String s = "";
    String sortColumn = "";
    int p = (int) Math.ceil(pm.getNumberOfProduct(1, "", sortColumn) / (float) pm.SoDong_Trang);
    if (request.getParameter("s") != null) {
        s = request.getParameter("s");
    }

%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%            response.sendRedirect("Post-list.jsp?page=" + p + "&s=" + s);
        %>
    </body>
</html>
