

<%@page import="ObjecInfo.Account"%>
<%@page import="Model.AccountModel"%>
<%@page import="Model.GameModel"%>
<%@page import="ObjecInfo.Game"%>
<%@page import="ObjecInfo.Posts"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.CategoryModel"%>
<%@page import="Model.PostModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    PostModel pm = new PostModel();
    GameModel gm = new GameModel();
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
    ArrayList<Posts> list = new ArrayList<Posts>();
    ArrayList<Game> listGame = gm.loadAllGame();
    ArrayList<Account> listAccount = am.loadAuthor();

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add more game</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

        <!-- Popper JS -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


    </head>
    <body>
        <main class="login-form" style="padding-top: 30px;">
            <div class="container-fluid">
                <div class="row justify-content-center">
                    <div class="col-md-6">
                        <div class="card">
                            <div class="card-header" style="text-align: center; font-size:  20px;  font-weight: bold;">Add New Post</div>
                            <div class="card-body">
                                <form action="FileUploadPost" method="post" enctype="multipart/form-data">
                                    <div class="form-group row">
                                        <label for="title" class="col-md-4 col-form-label text-md-right">Title of Post </label>
                                        <div class="col-md-6">
                                            <input type="text" id="nameGame" class="form-control" name="title" required autofocus value="">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="nameGame" class="col-md-4 col-form-label text-md-right">Content of Post </label>
                                        <div class="col-md-6">
                                            <textarea name="content" cols="41" rows="10"></textarea>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="picture" class="col-md-4 col-form-label text-md-right">Picture of Post </label>
                                        <div class="col-md-6">
                                            <input type = "file" name = "file" size = "50" required />
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="video" class="col-md-4 col-form-label text-md-right">Link video of Post </label>
                                        <div class="col-md-6">
                                            <input type="text" id="nameGame" class="form-control" name="video" required autofocus value="">
                                        </div>
                                    </div>

                                    <div class="form-group row">
                                        <label for="loai" class="col-md-4 col-form-label text-md-right">Game </label>
                                        <div class="col-md-6" style="padding-top: 10px;">
                                            <select class="form-group" name="gamelist">
                                                <%                            for (Game a : listGame) {
                                                %>
                                                <option value="<%=a.getID_Game()%>"><%=a.getName_Game()%></option>
                                                <%                            }
                                                %>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="form-group row">
                                        <label for="loai" class="col-md-4 col-form-label text-md-right">Author </label>
                                        <div class="col-md-6" style="padding-top: 10px;">
                                            <select class="form-group" name="accountlist">
                                                <%                            for (Account author : listAccount) {
                                                %>
                                                <option value="<%=author.getID_Account()%>"><%=author.getFullName()%></option>
                                                <%
                                                    }
                                                %>
                                            </select>
                                        </div>
                                    </div>


                                    <div class="col-md-6 offset-md-4 form-group">
                                        <button type="submit" class="btn btn-primary" name="submit" >
                                            Add
                                        </button>
                                    </div>
                                </form>
                            </div>
                        </div>	
                    </div>
                </div>
            </div>

        </main>
    </body>
</html>

