

<%@page import="Model.AccountModel"%>
<%@page import="ObjecInfo.Posts"%>
<%@page import="Model.PostModel"%>
<%@page import="ObjecInfo.Game"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.GameModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    GameModel gm = new GameModel();
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
    int cate = 1;
    int p = 1;
    int idGame = 1;
    if (request.getParameter("s") != null) {
        s = request.getParameter("s");
    }
    if (request.getParameter("page") != null) {
        p = Integer.parseInt(request.getParameter("page"));
    }
    if (request.getParameter("cate") != null) {
        cate = Integer.parseInt(request.getParameter("cate"));
    }
    if (request.getParameter("idGame") != null) {
        idGame = Integer.parseInt(request.getParameter("idGame"));
    }
    ArrayList<Game> list = gm.searchGameByID(idGame);

%>
<!DOCTYPE html>
<html lang="zxx">
    <head>
        <title><%=list.get(0).getName_Game()%></title>
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
        <section class="page-top-section set-bg" data-setbg="img/page-top-bg/1.jpg">
            <div class="page-info">
                <h2>Games</h2>
                <div class="site-breadcrumb">
                    <a href="Home.jsp">Home</a>  /
                    <span>Games</span>
                </div>
            </div>
        </section>
        <!-- Page top end-->


        <!-- Games section -->
        <section class="games-single-page">
            <div class="container">

                <div class="row">
                    <div class="col-xl-12 col-lg-12 col-md-12 game-single-content">
                        <h2 class="gs-title"><%=list.get(0).getName_Game()%></h2>
                        <div class="game-single-preview">
                            <img src="ImageUpload/Game/<%=list.get(0).getImage_Game()%>" alt="<%=list.get(0).getImage_Game()%>">
                        </div>
                        <h4>Gameplay</h4>
                        <pre><%=list.get(0).getDescription()%></pre>
                        <iframe width="100%" height="650"
                                src="<%=list.get(0).getVideo_Game()%>">
                        </iframe>
                    </div>
                </div>
            </div>
        </section>
        <!-- Games end-->

        <!--        <section class="game-author-section">
                    <div class="container">
                        <div class="game-author-pic set-bg" data-setbg="img/author.jpg"></div>
                        <div class="game-author-info">
                            <h4>Written by: Michael Williams</h4>
                            <p>Vivamus volutpat nibh ac sollicitudin imperdiet. Donec scelerisque lorem sodales odio ultricies, nec rhoncus ex lobortis. Vivamus tincid-unt sit amet sem id varius. Donec elementum aliquet tortor. Curabitur justo mi, efficitur sed eros alique.</p>
                        </div>
                    </div>
                </section>-->



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
