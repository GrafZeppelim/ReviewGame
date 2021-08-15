

<%@page import="ObjecInfo.Comment"%>
<%@page import="Model.CommentModel"%>
<%@page import="Model.AccountModel"%>
<%@page import="ObjecInfo.Posts"%>
<%@page import="Model.PostModel"%>
<%@page import="ObjecInfo.Game"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.GameModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    GameModel gm = new GameModel();
    PostModel pm = new PostModel();
    CommentModel cm = new CommentModel();
    AccountModel am = new AccountModel();
    String fullname = "";
    String name ="";
    boolean checkLogin = false;
    if (session.getAttribute("username") != null) {
        name = session.getAttribute("username").toString();
        checkLogin = true;
        fullname = am.getNameAccount(name);
    }
    String s = "";
    String sortColumn = "";
    int cate = 1;
    int p = 1;
    int idPost = 1;
    if (request.getParameter("s") != null) {
        s = request.getParameter("s");
    }
    if (request.getParameter("page") != null) {
        p = Integer.parseInt(request.getParameter("page"));
    }
    if (request.getParameter("cate") != null) {
        cate = Integer.parseInt(request.getParameter("cate"));
    }
    if (request.getParameter("idPost") != null) {
        idPost = Integer.parseInt(request.getParameter("idPost"));
    }
    ArrayList<Posts> list = pm.searchPostByID(idPost);
    ArrayList<Comment> listComment = cm.loadCommentOrderByDateAndID(idPost);

%>
<!DOCTYPE html>
<html lang="zxx">
    <head>
        <title><%=list.get(0).getTitle_Post()%></title>
        <meta charset="UTF-8">
        <meta name="description" content="EndGam Gaming Magazine Template">
        <meta name="keywords" content="endGam,gGaming, magazine, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- Favicon -->
        <link href="./img/logoGroup.png" rel="shortcut icon"/>

        <!-- Google Font -->
        <link href="https://fonts.googleapis.com/css?family=Roboto:400,400i,500,500i,700,700i,900,900i" rel="stylesheet">


        <!-- Stylesheets -->
        <link rel="stylesheet" href="cssUser/bootstrap.min.css"/>
        <link rel="stylesheet" href="cssUser/font-awesome.min.css"/>
        <link rel="stylesheet" href="cssUser/slicknav.min.css"/>
        <link rel="stylesheet" href="cssUser/owl.carousel.min.css"/>
        <link rel="stylesheet" href="cssUser/magnific-popup.css"/>
        <link rel="stylesheet" href="cssUser/animate.css"/>

        <!-- Main Stylesheets -->
        <link rel="stylesheet" href="cssUser/style.css"/>


        <!--[if lt IE 9]>
                  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
        <style>
            pre {
                white-space: -moz-pre-wrap; /* Mozilla, supported since 1999 */
                white-space: -pre-wrap; /* Opera */
                white-space: -o-pre-wrap; /* Opera */
                white-space: pre-wrap; /* CSS3 - Text module (Candidate Recommendation) http://www.w3.org/TR/css3-text/#white-space */
                word-wrap: break-word; /* IE 5.5+ */
            }
            pre {
                font-size: 16px;
                font-weight: 500;
                color: white;
                line-height: 1.8;
                margin-bottom: 70px;
            }



            .widget-area {
                -webkit-border-radius: 4px;
                -moz-border-radius: 4px;
                -ms-border-radius: 4px;
                -o-border-radius: 4px;
                border-radius: 4px;
                -webkit-box-shadow: 0 0 16px rgba(0, 0, 0, 0.05);
                -moz-box-shadow: 0 0 16px rgba(0, 0, 0, 0.05);
                -ms-box-shadow: 0 0 16px rgba(0, 0, 0, 0.05);
                -o-box-shadow: 0 0 16px rgba(0, 0, 0, 0.05);
                box-shadow: 0 0 16px rgba(0, 0, 0, 0.05);
                margin-left: -3%;
                position: relative;
                width: 100%;
            }
            .status-upload {
                -webkit-border-radius: 4px;
                -moz-border-radius: 4px;
                -ms-border-radius: 4px;
                -o-border-radius: 4px;
                border-radius: 4px;
                float: left;
                width: 100%;
            }
            .status-upload form {
                float: left;
                width: 100%;
            }
            .status-upload form textarea {
                background: none repeat scroll 0 0 #fff;
                border: medium none;
                -webkit-border-radius: 4px 4px 0 0;
                -moz-border-radius: 4px 4px 0 0;
                -ms-border-radius: 4px 4px 0 0;
                -o-border-radius: 4px 4px 0 0;
                border-radius: 4px 4px 0 0;
                color: #777777;
                float: left;
                font-family: Lato;
                font-size: 14px;
                height: 90px;
                letter-spacing: 0.3px;
                padding:10px;
                width: 100%;
                resize:vertical;
                outline:none;
                border: 1px solid #F2F2F2;
            }


            .status-upload form button {
                border: medium none;
                -webkit-border-radius: 4px;
                -moz-border-radius: 4px;
                -ms-border-radius: 4px;
                -o-border-radius: 4px;
                border-radius: 4px;
                color: #fff;
                float: right;
                font-family: Lato;
                font-size: 14px;
                letter-spacing: 0.3px;
                margin-right: 9px;
                margin-top: 9px;
                padding: 6px 15px;
            }
            .dropdown > a > span.green:before {
                border-left-color: #2dcb73;
            }
            .status-upload form button > i {
                margin-right: 7px;
            }

            .btn-success {
                color: #fff;
                background-color: #c313b7;
                border-color: #c313b7;
            }

        </style>
        <script>
            function CommentSubmit() {
                if (<%=checkLogin%> == false) {
                    document.getElementById("CommentSubmit").style.display = "none";
                } else {
                    document.getElementById("CommentSubmit").style.visibility = "visible";
                }
            }
            window.onload = CommentSubmit;
        </script>
    </head>
    <body>
        <!-- Page Preloder -->
        <div id="preloder">
            <div class="loader"></div>
        </div>

        <!-- Header section -->
        <header class="header-section">
            <div class="header-warp">
                <div class="header-social d-flex justify-content-end">
                    <p>Follow us:</p>
                    <a href="#"><i class="fa fa-pinterest"></i></a>
                    <a href="https://www.facebook.com/YiBongChen/?epa=SEARCH_BOX" target="_blank"><i class="fa fa-facebook"></i></a>
                    <a href="#"><i class="fa fa-twitter"></i></a>
                    <a href="#"><i class="fa fa-dribbble"></i></a>
                    <a href="#"><i class="fa fa-behance"></i></a>
                </div>
                <div class="header-bar-warp d-flex">
                    <!-- site logo -->
                    <a href="Home.jsp" class="site-logo">
                        <img src="./img/logoGroup.png" alt="">
                    </a>
                    <nav class="top-nav-area w-100">
                        <div class="user-panel">
                            <%                                                                  if (checkLogin) {
                            %>
                            <span><%=fullname%></span> - <button class="btn-dark"><a href="logout.jsp">Logout</a></button>
                            <%
                            } else {
                            %>
                            <a href="login.jsp">Login</a> / <a href="signUp.jsp">Register</a>

                            <%
                                }
                            %>
                        </div>
                        <!-- Menu -->
                        <ul class="main-menu primary-menu">
                            <li><a href="Home.jsp">Home</a></li>
                            <li><a href="Games.jsp">Games</a>
                                <ul class="sub-menu">
                                    <li><a href="Games.jsp?cate=1">Action</a></li>
                                    <li><a href="Games.jsp?cate=2">Adventure</a></li>
                                    <li><a href="Games.jsp?cate=3">Tactic</a></li>
                                    <li><a href="Games.jsp?cate=4">Roleplaying</a></li>
                                    <li><a href="Games.jsp?cate=5">Horror</a></li>
                                </ul>
                            </li>
                            <li><a href="News.jsp">News</a></li>
                            <li><a href="Contact.jsp">Contact</a></li>
                        </ul>
                    </nav>
                </div>
            </div>
        </header>
        <!-- Header section end -->

        <!-- Page top section -->
        <section class="page-top-section set-bg" data-setbg="img/page-top-bg/1.jpg">
            <div class="page-info">
                <h2>News</h2>
                <div class="site-breadcrumb">
                    <a href="Home.jsp">Home</a>  /
                    <span>News</span>
                </div>
            </div>
        </section>
        <!-- Page top end-->


        <!-- Games section -->
        <section class="games-single-page">
            <div class="container">

                <div class="row">
                    <div class="col-xl-12 col-lg-12 col-md-12 game-single-content">
                        <h2 class="gs-title"><%=list.get(0).getTitle_Post()%></h2>
                        <div class="game-single-preview">
                            <img src="ImageUpload/Post/<%=list.get(0).getImage_Post()%>" alt="<%=list.get(0).getImage_Post()%>">
                        </div>
                        <h4>News</h4>
                        <pre><%=list.get(0).getContent_Post()%></pre>
                        <iframe width="100%" height="650"
                                src="<%=list.get(0).getVideo_Post()%>">
                        </iframe>
                    </div>
                </div>
            </div>
        </section>
        <!-- Games end-->

        <section class="game-author-section">
            <div class="container">
                <div class="game-author-pic set-bg" data-setbg="img/author.jpg"></div>
                <div class="game-author-info">
                    <h4>Author</h4>
                    <h5 style="color: white"><%=am.getNameAccountByID(list.get(0).getID_Account())%></h5>
                    <p></p>
                </div>
            </div>
        </section>


        <!--Comment section-->
        <section class="games-single-page">
            <div class="container">
                <div class="row">
                    <div class="col-md-8">
                        <h2 class="page-header" style="color: white;">Comments</h2>
                        <br/>


                        <section class="comment-list">
                            <%
                                for (Comment comments : listComment) {
                                     if (comments.getStatus() == 2) {
                            %>
                            <!-- First Comment -->
                            <article class="row" style="padding-bottom: 2%">
                                <div class="col-md-2 col-sm-2 hidden-xs">
                                    <figure class="thumbnail">
                                        <img class="img-responsive" src="http://www.tangoflooring.ca/wp-content/uploads/2015/07/user-avatar-placeholder.png" />
                                        <figcaption class="text-center" style="color: #c313b7"><%=am.getNameAccountByID(comments.getID_Account())%></figcaption>
                                    </figure>
                                </div>
                                <div class="col-md-10 col-sm-10">
                                    <div class="panel panel-default arrow left">
                                        <div class="panel-body">
                                            <header class="text-left">
                                                <time class="comment-date" datetime="<%=comments.getDate_Comment()%>" style="color: #c313b7"><i class="fa fa-clock-o"></i><%=comments.getDate_Comment()%></time>
                                            </header>
                                            <div class="comment-post" >
                                                <p style="color: white;">
                                                    <%=comments.getContent_Comment()%>
                                                </p>
                                            </div>

                                        </div>
                                    </div>
                                </div>
                            </article>
                            <%    }
}
                            %>

                            <!--comment submit-->
                            <div class="container" id="CommentSubmit">
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="widget-area no-padding blank">
                                            <div class="status-upload">
                                                <form action="add-comment.jsp" method="get" enctype="multipart/form-data">
                                                    <input type="hidden" id="userName" name="userNameOfAccount"value="<%=name%>">
                                                    <input type="hidden" name="idPost"value="<%=idPost%>">
                                                    <textarea placeholder="What are you doing right now?" name="Content" ></textarea>
                                                    <button type="submit" class="btn btn-success green" style="margin-bottom: 2%"><i class="fa fa-share"></i> Comment</button>
                                                </form>
                                            </div><!-- Status Upload  -->
                                        </div><!-- Widget Area -->
                                    </div>
                                </div>
                            </div>
                            <!--end comment submit-->


                        </section>
                    </div>
                </div>
            </div>
        </section>
        <!--Comment section end-->


        <!-- Footer section -->
        <footer class="footer-section">
            <div class="container">
                <a href="Home.jsp" class="footer-logo">
                    <img src="./img/logoGroup.png" alt="">
                </a>
                <ul class="main-menu footer-menu">
                    <li><a href="Home.jsp">Home</a></li>
                    <li><a href="Games.jsp">Games</a></li>
                    <li><a href="Review.jsp">News</a></li>
                    <li><a href="Contact.jsp">Contact</a></li>
                </ul>
                <div class="footer-social d-flex justify-content-center">
                    <a href="#"><i class="fa fa-pinterest"></i></a>
                    <a href="https://www.facebook.com/YiBongChen/?epa=SEARCH_BOX" target="_blank"><i class="fa fa-facebook"></i></a>
                    <a href="#"><i class="fa fa-twitter" target="_blank"></i></a>
                    <a href="#"><i class="fa fa-dribbble"></i></a>
                    <a href="#"><i class="fa fa-behance"></i></a>
                </div>
                <div class="copyright"><a href="">QKSVC</a> 2018 @ All rights reserved</div>
            </div>
        </footer>
        <!-- Footer section end -->


        <!--====== Javascripts & Jquery ======-->
        <script src="jsUser/jquery-3.2.1.min.js"></script>
        <script src="jsUser/bootstrap.min.js"></script>
        <script src="jsUser/jquery.slicknav.min.js"></script>
        <script src="jsUser/owl.carousel.min.js"></script>
        <script src="jsUser/jquery.sticky-sidebar.min.js"></script>
        <script src="jsUser/jquery.magnific-popup.min.js"></script>
        <script src="jsUser/main.js"></script>

    </body>
</html>
