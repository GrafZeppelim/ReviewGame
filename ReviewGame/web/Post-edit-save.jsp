

<%@page import="ObjecInfo.Posts"%>
<%@page import="Model.PostModel"%>
<%@page import="ObjecInfo.Game"%>
<%@page import="Model.GameModel"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    PostModel pm = new PostModel();
    String picture = "";
    String videoPost = "";
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
    int idPost = Integer.parseInt((String) request.getAttribute("id"));
    Object name = request.getAttribute("namePost");
    String namePost = name.toString();

    if (request.getAttribute("videoPost") != null) {
        Object video = request.getAttribute("videoPost");
        videoPost = video.toString();
    }
    Object info = request.getAttribute("content");
    String contentPost = info.toString();
    int idGame = Integer.parseInt((String) request.getAttribute("gameList"));
    int idAccount=Integer.parseInt((String) request.getAttribute("accountlist"));
    ArrayList<Posts> list = pm.getPaging(p, s, sortColumn);
    for (Posts spm : list) {
        if (idPost == spm.getID_Post()&& picture.equals("")) {
            picture = spm.getImage_Post();
        }
    }
    boolean check=pm.updatePost(idPost, idAccount, idGame, contentPost, namePost, picture, videoPost);
    if (check == true) {
        response.sendRedirect("Post-list.jsp?page=" + p + "&s=" + s);
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
