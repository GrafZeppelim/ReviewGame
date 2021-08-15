
<%@page import="Model.PostModel"%>
<%@page import="Model.AccountModel"%>
<%@page import="ObjecInfo.Comment"%>
<%@page import="Model.CommentModel"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    CommentModel cm = new CommentModel();
    AccountModel am = new AccountModel();
    PostModel pm = new PostModel() ;
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
    if (request.getParameter("idComment") != null) {
        id = Integer.parseInt(request.getParameter("idComment"));
    }
    ArrayList<Comment> list = new ArrayList<Comment>();
    list = cm.searchGameByID(id);

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
        <h2 style="text-align: center;padding: 40px;">Information of comment </h2>
        <div class="container">
            <div class="card" >
                <div class="card-body">
                    
                    <p style="font-size: 20px"><b>User name: </b><%=am.getNameAccountByID(list.get(0).getID_Account())%></p>     
                    <p style="font-size: 20px"><b>Title of post:  </b> <%=pm.printWord(pm.getNamePostByID(list.get(0).getID_Post()),100)%></p>
                    <p style="font-size: 20px"><b>Content of comment:  </b> <%=list.get(0).getContent_Comment()%></p>
                    <p style="font-size: 20px"><b>Date of comment:  </b> <%=list.get(0).getDate_Comment()%></p>
                        <p style="font-size: 20px"><b>Status:  </b> <%=list.get(0).getStatus() == 1 ? "Enable"
                                : "Disable"%> </p> 
                </div>
                <br>

            </div>
            <div class="container" style="padding: 30px 0px 30px 0px;">
                <div class="d-flex justify-content-around">
                    <button class="btn btn-primary" onclick="location.href = 'CommentAdmin.jsp?page=<%=p%>&s=<%=s%>'">Back
                    </button>
                </div>
            </div>
        </div>
    </body>
</html>
