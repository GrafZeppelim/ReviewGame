
<%@page import="ObjecInfo.Game"%>
<%@page import="Model.GameModel"%>
<%@page import="Model.CategoryModel"%>
<%@page import="ObjecInfo.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    CategoryModel cm = new CategoryModel();
    GameModel gm = new GameModel();
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
    ArrayList<Game> list = gm.searchGameByID(id);
    int type = list.get(0).getID_Category();
   
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Game</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <script>
            function myFunction() {
                document.getElementById("mySelect").value = "<%=type%>";
            }
            ;
            window.onload = function () {
                myFunction();
            };

        </script>
    </head>
    <body>
        <div class="container" style="padding-bottom: 50px;">
            <h2 style="text-align: center;padding: 40px;">Edit game <%=list.get(0).getName_Game()%> </h2>
            <form action="abc" method="post" enctype="multipart/form-data" >
                <input type="hidden" class="form-control" name="page" value="<%=p%>">
                <input type="hidden" id="id" class="form-control" name="id" value="<%=list.get(0).getID_Game()%>">
                <div class="form-group">
                    <label for="name">Name of game</label>
                    <input type="text" class="form-control"  name="nameGame" value="<%=list.get(0).getName_Game()%>">
                </div>
                
                <div class="form-group">
                    <label for="video">Link video game</label>
                    <input type="text" class="form-control"  name="videoGame" value="<%=list.get(0).getVideo_Game()%>">
                </div>
                <div class="form-group">
                    <label for="Description">Description</label>
                    <textarea name="description" style="width:100%; height:350px;" ><%=list.get(0).getDescription()%></textarea>
                </div>

                <div class="form-group">
                    <label for="loai">Type</label>
                    <select class="form-group" name="loai" id="mySelect">
                        <option value="1">action</option>
                        <option value="2">adventure</option>
                        <option value="3">tactic</option>
                        <option value="4">roleplaying</option>
                        <option value="5">horror</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="picture">Picture of game</label><br/>
                    <input type = "file" name = "file" size = "50" />
                </div>
                <div style="text-align: center;">
                    <button type="submit" class="btn btn-danger">Submit</button>
                </div>               
            </form>

            <div class="container" style="padding: 30px 0px 30px 0px; text-align: left;">
                <div class="d-flex justify-content-around">
                    <button class="btn btn-primary" onclick="location.href = 'gameIndex.jsp?id=<%=id%>&page=<%=p%>&s=<%=s%>'">Back
                    </button>
                </div>
            </div>

        </div>
    </body>
</html>
