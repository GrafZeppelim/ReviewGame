
<%@page import="ObjecInfo.Game"%>
<%@page import="Model.GameModel"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%

    GameModel gm = new GameModel();

    Object name = request.getAttribute("nameGame");
    String nameGame = name.toString();

    Object file = request.getAttribute("file");
    String picture = file.toString();

    Object video = request.getAttribute("video");
    String videoGame = video.toString();

    Object info = request.getAttribute("description");
    String description = info.toString();

    int loai = Integer.parseInt((String) request.getAttribute("loai"));

    gm.insertGames(loai, nameGame, picture, videoGame, description, 0, 0);
    String s = "";
    String sortColumn = "";
    int p = (int) Math.ceil(gm.getNumberOfProduct(1, "", sortColumn) / (float) gm.SoDong_Trang);
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
        <%            response.sendRedirect("admin-game-list.jsp?page=" + p + "&s=" + s);
        %>
    </body>
</html>
