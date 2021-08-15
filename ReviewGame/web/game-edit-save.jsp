
<%@page import="ObjecInfo.Game"%>
<%@page import="Model.GameModel"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    GameModel gm = new GameModel();
    String picture = "";
    String videoGame = "";
    String s = "";
    String sortColumn = "";
    int p = 1;
    if (request.getAttribute("page") != null) {
        p = Integer.parseInt((String) request.getAttribute("page"));
    }
    if (request.getAttribute("s") != null) {
        Object search = request.getAttribute("s");
        s = search.toString();
    }

    Object file = request.getAttribute("file");
    if (file == null) {
        picture = "";
    } else {
        picture = file.toString();
    }
    int id = Integer.parseInt((String) request.getAttribute("id"));
    Object name = request.getAttribute("nameGame");
    String nameGame = name.toString();

    if (request.getAttribute("videoGame") != null) {
        Object video = request.getAttribute("videoGame");
        videoGame = video.toString();
    }
    Object info = request.getAttribute("description");
    String description = info.toString();
    int loai = Integer.parseInt((String) request.getAttribute("loai"));

    ArrayList<Game> list = gm.getPaging(p, s, sortColumn);
    for (Game spm : list) {
        if (id == spm.getID_Game() && picture.equals("")) {
            picture = spm.getImage_Game();
        }
    }
    boolean check = gm.updateGame(id, loai, nameGame, picture, videoGame, description);
    if (check == true) {
        response.sendRedirect("admin-game-list.jsp?page=" + p + "&s=" + s);
    } else {
        out.println("loi roi xem lai sql nha ");
    }
//%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <h1></h1>
    </body>
</html>
