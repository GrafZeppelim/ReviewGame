
<%@page import="ObjecInfo.Game"%>
<%@page import="Model.GameModel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="MyUtils.DBConnection"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    GameModel gm = new GameModel();

    String s = "";
    String sortColumn = "";
    int p = 1;
    if (request.getParameter("s") != null) {
        s = request.getParameter("s");
    }
    if (request.getParameter("page") != null) {
        p = Integer.parseInt(request.getParameter("page"));
    }
    ArrayList<Game> list = gm.getPaging(p, s, sortColumn);

    int game_no = (p - 1) * GameModel.SoDong_Trang;

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of game</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    </head>
    <style>
        .sp_image{
            width: 200px;
            height: 120px;
        }
        .table>thead>tr>th {
            vertical-align: inherit !important;
            text-align: center;
        }
        .paging{
            text-align: left;
        }
        td{
            text-align: center;
        }
    </style>
    <body>


        <div class="container">     
            <h2>List of games (<%=gm.getNumberOfProduct(p, s, sortColumn)%> Games)</h2>
            
            <table class="table">
                <thead>
                <form>
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="Search" name="s" value="<%=s%>">
                        <div class="input-group-btn">
                            <button class="btn btn-default" type="submit" >
                                <i class="glyphicon glyphicon-search"></i>
                            </button>
                        </div>
                    </div>
                </form>
                <tr>
                    <th colspan="7" style="text-align: left; padding: 0px;">
                        <%=gm.getPagingString(p, s, sortColumn)%>
                    </th>
                </tr>
                <tr>
                    <th>STT</th>
                    <th style="width: 100px">Name of game</th>
                    <th>Picture</th>
                    <th>Video</th>
                    <th>Description</th>
                    <th>Count rate</th>
                    <th>Total rate point</th>
                    <th>Status</th>
                    <th>Add
                        <button type="button"  class="btn btn-success" 
                                onclick="location.href = 'game-new.jsp?page=<%=p%>&s=<%=s%>'">
                            <span class="glyphicon glyphicon-plus"></span>
                        </button>
                    </th>

                </tr>
                </thead>
                <tbody>
                    <%
                        String status;
                        for (Game game : list) {
                            ++game_no;
                            status = game.getStatus() == 1 ? "<span class='glyphicon glyphicon-ok-circle text-success'></span>"
                                    : "<span class='glyphicon glyphicon-remove-circle text-danger'></span>";
                    %>
                    <tr>
                        <td><%=game_no%></td>
                        <td><%=game.getName_Game()%></td>
                        <td><img class="sp_image"src="ImageUpload/Game/<%=game.getImage_Game()%>"></td>
                        <td><iframe width="200" height="120"
                                    src="<%=game.getVideo_Game()%>">
                            </iframe></td>
                        <td><%=gm.printWord(game.getDescription(),100)%></td>
                        <td><%=game.getCountRate()%></td>
                        <td><%=game.getTotalRatePoint()%></td>
                        <td><%=status%></td>


                        <td class="column-verticallineMiddle form-inline" style="display: inline-block; width: 132px">
                            <button type="button" class="btn btn-default btn-sm btn-primary"
                                    onclick=" location.href = 'game-details.jsp?id=<%=game.getID_Game()%>&page=<%=p%>&s=<%=s%>'">
                                <span class="glyphicon glyphicon-info-sign"></span>
                            </button>
                            <button type="button" class="btn btn-warning" 
                                    onclick="location.href = 'game-edit.jsp?id=<%=game.getID_Game()%>&page=<%=p%>&s=<%=s%>'">
                                <span class="glyphicon glyphicon-pencil"></span>
                            </button>
                            <button type="button" class="btn btn-default btn-sm btn-danger" onclick="if (confirm('Do you want do delete ?'))
                                        location.href = 'game-delete.jsp?id=<%=game.getID_Game()%>&page=<%=p%>&s=<%=s%>'">
                                <span class="glyphicon glyphicon-trash "></span> 
                            </button>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>
    </body>
</html>
