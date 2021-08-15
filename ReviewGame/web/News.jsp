
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
    String fullname = "";
    boolean checkLogin = false;
    if (session.getAttribute("username") != null) {
        String name = session.getAttribute("username").toString();
        checkLogin = true;
        AccountModel am = new AccountModel();
        fullname = am.getNameAccount(name);
    }
    String s = "";
    String sortColumn = "";
    int p = 1;
    if (request.getParameter("s") != null) {
        s = request.getParameter("s");
    }
    if (request.getParameter("page") != null) {
        p = Integer.parseInt(request.getParameter("page"));
    }

    ArrayList<Game> TopGame = gm.getTopGame();
    ArrayList<Posts> list = pm.getPaging(p, s, sortColumn);

%>
<!DOCTYPE html>
<html lang="zxx">
    <head>
        <title>News</title>
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
            #paging{
                padding-left: 0px;
                padding-top: 35px;
            }
            .blog-item {
                margin-top: 10px !important;
                width: 290px;
            }
            .blog-item .blog-thumb {
                width: 250px;
                float: left;
                margin-right: 30px;
            }
            .pagination>.active>a, 
            .pagination>.active>a:focus, 
            .pagination>.active>a:hover,
            .pagination>.active>span, 
            .pagination>.active>span:focus,
            .pagination>.active>span:hover{
                background-color: #b01ba5;
                border-color: #b01ba5; 
            }
            .pagination>li>a, .pagination>li>span{
                color: #b01ba5;
            }
            .main-menu li .sub-menu{
                padding: 10px;
            }
            .trending-widget .tw-item {
                margin-bottom: 73px;
            }
            .gianCach{
                padding-top: 100px;
            }
            #TieuDe{
                font-size: 30px;
                font-weight: bold;
                color: white;
                padding-top: 40px;
                margin-bottom: 0px;
            }
        </style>
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
        <section class="page-top-section set-bg" data-setbg="img/page-top-bg/3.jpg">
            <div class="page-info">
                <h2>News</h2>
                <div class="site-breadcrumb">
                    <a href="Home.jsp">Home</a>  /
                    <span>News</span>
                </div>
            </div>
        </section>
        <!-- Page top end-->


        <!-- Blog page -->
        <section class="blog-page">
            <div class="container">
                <div class="row">
                    <div class="col-xl-9 col-lg-8 col-md-7">
                        <div class="section-title text-white">
                            <h2>All latest new </h2>
                        </div>
                        <br/>
                        <div class="widget-item">
                            <form class="search-widget">
                                <input type="text" name="s" value="<%=s%>">
                                <button type="submit">Search</button>
                            </form>
                        </div>

                        <%
                            for (Posts post : list) {
                        %>
                        <div class="big-blog-item">
                            <img src="ImageUpload/Post/<%=post.getImage_Post()%>" alt="<%=post.getImage_Post()%>" class="blog-thumbnail">
                            <div class="blog-content text-box text-white">
                                <h3><%=post.getTitle_Post()%></h3>
                                <p><%=gm.printWord(post.getContent_Post(), 100)%></p>
                                <a href="BlogPost.jsp?idPost=<%=post.getID_Post()%>" class="read-more">Read More <img src="img/icons/double-arrow.png" alt="#"/></a>
                            </div>
                        </div>
                        <%
                            }
                        %>

                        <%=pm.getPagingStringEndGame(p, s, sortColumn)%>
                    </div>
                    <div class="col-xl-3 col-lg-4 col-md-5 sidebar">
                        <div id="stickySidebar">
                            <div class="card" style="background-color: #34164b" >
                                <div class="card-body">
                                    <div class="widget-item">
                                        <h4 class="widget-title">Trending</h4>
                                        <div class="trending-widget">

                                            <%                            for (Game topGame : TopGame) {
                                            %>
                                            <div class="tw-item">
                                                <div class="tw-thumb">
                                                    <img src="ImageUpload/Game/<%=topGame.getImage_Game()%>" alt="<%=topGame.getImage_Game()%>" style="width: 100px; height: 70px">
                                                </div>
                                                <div class="tw-text">
                                                    <!--                                            <div class="tw-meta">11.11.18  /  in <a href="">Games</a></div>-->
                                                    <h5><a href="Blog.jsp?idGame=<%=topGame.getID_Game()%>"><%=topGame.getName_Game()%></a></h5>
                                                </div>
                                            </div>
                                            <%
                                                }
                                            %>                                   
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <br/>


                            <div class="widget-item">
                                <div class="categories-widget">
                                    <h4 class="widget-title">categories</h4>
                                    <ul>
                                        <li><a href="Games.jsp?cate=1">Action</a></li>
                                        <li><a href="Games.jsp?cate=2">Adventure</a></li>
                                        <li><a href="Games.jsp?cate=3">Tactic</a></li>
                                        <li><a href="Games.jsp?cate=4">Roleplaying</a></li>
                                        <li><a href="Games.jsp?cate=5">Horror</a></li>
                                    </ul>
                                </div>
                            </div>


                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Blog page end-->




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
