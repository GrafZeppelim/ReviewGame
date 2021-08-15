

<%@page import="ObjecInfo.Account"%>
<%@page import="Model.AccountModel"%>
<%@page import="ObjecInfo.Posts"%>
<%@page import="Model.PostModel"%>
<%@page import="ObjecInfo.Game"%>
<%@page import="Model.GameModel"%>
<%@page import="Model.CategoryModel"%>
<%@page import="ObjecInfo.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    GameModel gm = new GameModel();
    PostModel pm = new PostModel();
    AccountModel am = new AccountModel();
    String s = "";
    String sortColumn = "";
    int p = 1;
    int id = 1;
    if (request.getParameter("s") != null) {
        s = request.getParameter("s");
    }
    if (request.getParameter("page") != null) {
        p = Integer.parseInt(request.getParameter("page"));
    }
    if (request.getParameter("id") != null) {
        id = Integer.parseInt(request.getParameter("id"));
    }
    ArrayList<Posts> list = pm.searchPostByID(id);
    int idgame = list.get(0).getID_Game();
    int idaccount = list.get(0).getID_Account();
    ArrayList<Game> listGame = gm.loadAllGame();
    ArrayList<Account> listAccount = am.loadAuthor();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Post</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

    </head>
    <body>
        <div class="container" style="padding-bottom: 50px;">

            <h2 style="text-align: center;padding: 40px;">Edit game <%=list.get(0).getTitle_Post()%> </h2>
            <form action="EditFilePost" method="post" enctype="multipart/form-data" >
                <input type="hidden" class="form-control" name="page" value="<%=p%>">
                <input type="hidden" id="id" class="form-control" name="id" value="<%=list.get(0).getID_Post()%>">
                <div class="form-group">
                    <label for="name">Name of Post</label>
                    <input type="text" class="form-control"  name="namePost" value="<%=list.get(0).getTitle_Post()%>">
                </div>

                <div class="form-group">
                    <label for="video">Link video Post</label>
                    <input type="text" class="form-control"  name="videoPost" value="<%=list.get(0).getVideo_Post()%>">
                </div>
                <div class="form-group">
                    <label for="Description">Content of post</label>
                    <textarea name="content" style="width:100%; height:350px;" ><%=list.get(0).getContent_Post()%></textarea>
                </div>

                <div class="form-group">
                    <label for="gameList">Game</label>
                    <select class="form-group" name="gameList" id="mySelect1" required>
                        <%                            for (Game a : listGame) {
                        %>
                        <option value="<%=a.getID_Game()%>"><%=a.getName_Game()%></option>
                        <%                            }
                        %>
                    </select>
                </div>

                <div class="form-group">
                    <label for="loai">Author </label>
                    <select class="form-group" name="accountlist" id="mySelect2" required>
                        <%                            for (Account author : listAccount) {
                        %>
                        <option value="<%=author.getID_Account()%>"><%=author.getFullName()%></option>
                        <%
                            }
                        %>
                    </select>
                </div>


                <div class="form-group">
                    <label for="picture">Picture of Post</label><br/>
                    <input type = "file" name = "file" size = "50" />
                </div>
                <div style="text-align: center;">
                    <button type="submit" class="btn btn-danger">Submit</button>
                </div>               
            </form>

            <div class="container" style="padding: 30px 0px 30px 0px; text-align: left;">
                <div class="d-flex justify-content-around">
                    <button class="btn btn-primary" onclick="location.href = 'Post-list.jsp?id=<%=id%>&page=<%=p%>&s=<%=s%>'">Back
                    </button>
                </div>
            </div>

        </div>
    </body>
    <script>
        function myFunction1() {
            document.getElementById("mySelect1").value = "<%=idgame%>";
        }
        ;
        function myFunction2() {
            document.getElementById("mySelect2").value = "<%=idaccount%>";
        }
        ;
        window.onload = function () {
            myFunction1();
            myFunction2();
        };

    </script>
</html>

