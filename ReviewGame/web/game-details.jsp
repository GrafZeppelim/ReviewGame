

<%@page import="ObjecInfo.Game"%>
<%@page import="Model.GameModel"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
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
    ArrayList<Game> list = new ArrayList<Game>();
    list = gm.searchGameByID(id);

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Game information</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

        <!-- Popper JS -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <style>
            pre {
                white-space: -moz-pre-wrap; /* Mozilla, supported since 1999 */
                white-space: -pre-wrap; /* Opera */
                white-space: -o-pre-wrap; /* Opera */
                white-space: pre-wrap; /* CSS3 - Text module (Candidate Recommendation) http://www.w3.org/TR/css3-text/#white-space */
                word-wrap: break-word; /* IE 5.5+ */
            }
        </style>
    </head>
    <body>
        <h2 style="text-align: center;padding: 40px;">Information of <%=list.get(0).getName_Game()%> </h2>
        <div class="container">
            <div class="card" >
                <div class="card-body">
                    <p style="font-size: 20px"><b>Name of game: </b><%=list.get(0).getName_Game()%></p>     
                    <p style="font-size: 20px"><b>Image of game: </b></p>
                    <img src="ImageUpload/Game/<%=list.get(0).getImage_Game()%>" alt="Card image" style="width:100%;height: 40%">
                    <p style="font-size: 20px"><b>Video of game: </b></p>
                    <iframe width="100%" height="500"
                            src="<%=list.get(0).getVideo_Game()%>">
                    </iframe>
                    <pre style="font-size: 20px"><b>Description:  </b> <%=list.get(0).getDescription()%></pre>
                    <p style="font-size: 20px"><b>Count rate:  </b> <%=list.get(0).getCountRate()%></p>
                    <p style="font-size: 20px"><b>Total rate point:  </b> <%=list.get(0).getTotalRatePoint()%></p>
                        <p style="font-size: 20px"><b>Status:  </b> <%=list.get(0).getStatus() == 1 ? "Available"
                                : "Unavailable"%> </p> 
                    <p style="font-size: 20px"><b>Type:  </b> <%=gm.getTypeGame(list.get(0).getID_Category())%></p>
                </div>
                <br>

            </div>
            <div class="container" style="padding: 30px 0px 30px 0px;">
                <div class="d-flex justify-content-around">
                    <button class="btn btn-primary" onclick="location.href = 'gameIndex.jsp?id=<%=id%>&page=<%=p%>&s=<%=s%>'">Back
                    </button>
                </div>
            </div>
        </div>
    </body>
</html>
