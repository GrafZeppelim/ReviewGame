
<%@page import="Model.CategoryModel"%>
<%@page import="ObjecInfo.Category"%>
<%@page import="ObjecInfo.Game"%>
<%@page import="Model.GameModel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="MyUtils.DBConnection"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    GameModel gm = new GameModel();
    CategoryModel cm = new CategoryModel();
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
    ArrayList<Game> list = new ArrayList<Game>();
    ArrayList<Category> listCate = cm.loadAllCategory();
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
                            <div class="card-header" style="text-align: center; font-size:  20px;  font-weight: bold;">Add New Game</div>
                            <div class="card-body">
                                <form action="UploadNew" method="post" enctype="multipart/form-data">
                                    <div class="form-group row">
                                        <label for="nameGame" class="col-md-4 col-form-label text-md-right">Name of game </label>
                                        <div class="col-md-6">
                                            <input type="text" id="nameGame" class="form-control" name="nameGame" required autofocus value="">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="picture" class="col-md-4 col-form-label text-md-right">Picture of game </label>
                                        <div class="col-md-6">
                                            <input type = "file" name = "file" size = "50" required />
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="video" class="col-md-4 col-form-label text-md-right">Link video of game </label>
                                        <div class="col-md-6">
                                            <input type="text" id="nameGame" class="form-control" name="video" required autofocus value="">
                                        </div>
                                    </div>
                                    
                                    <div class="form-group row">
                                        <label for="description" class="col-md-4 col-form-label text-md-right">Description </label>
                                        <div class="col-md-6">
                                            <textarea name="description" cols="41" rows="10"></textarea>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="loai" class="col-md-4 col-form-label text-md-right">Type </label>
                                        <div class="col-md-6" style="padding-top: 10px;">
                                            <select class="form-group" name="loai">
                                                <%                            for (Category a : listCate) {
                                                %>
                                                <option value="<%=a.getID_Category()%>"><%=a.getName_Category()%></option>
                                                <%                            }
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
        <div class="container" style="padding: 30px 0px 30px 0px;">
            <div class="d-flex justify-content-around">
                <button class="btn btn-primary" onclick="location.href = 'gameIndex.jsp?page=<%=p%>&s=<%=s%>'">Back
                </button>
            </div>
        </div>
    </body>
</html>
