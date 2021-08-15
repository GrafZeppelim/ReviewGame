

<%@page import="Model.AccountModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String fullname = "";
    boolean checkLogin = false;
    if (session.getAttribute("username") != null) {
        String name = session.getAttribute("username").toString();
        checkLogin = true;
        AccountModel am = new AccountModel();
        fullname = am.getNameAccount(name);
    }
%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="zxx">
    <head>
        <title>QKSVC Contact</title>
        <meta charset="UTF-8">
        <meta name="description" content="EndGam Gaming Magazine Template">
        <meta name="keywords" content="endGam,gGaming, magazine, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- Favicon -->
        <link href="img/logoGroup.png" rel="shortcut icon"/>

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
                        <img src="img/logoGroup.png" alt="">
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
        <section class="page-top-section set-bg" data-setbg="img/page-top-bg/4.jpg">
            <div class="page-info">
                <h2>Contact</h2>
                <div class="site-breadcrumb">
                    <a href="Home.jsp">Home</a>  /
                    <span>Contact</span>
                </div>
            </div>
        </section>
        <!-- Page top end-->


        <!-- Contact page -->
        <section class="contact-page">
            <div class="container">
                <div class="map"><iframe src="https://maps.google.com/maps?q=%C4%91%E1%BA%A1i%20h%E1%BB%8Dc%20fpt%20c%E1%BA%A7n%20th%C6%A1&t=&z=13&ie=UTF8&iwloc=&output=embed" style="border:0" allowfullscreen></iframe></div>
                <div class="row">
                    <div class="col-lg-12 order-1 order-lg-2 contact-text text-white">
                        <h3>QKSVC Hello every one!</h3>
                        <p>A game review page helps us view reviews, posts about a game
                            live. With the experience of those who have experienced the game of
                            the members, it will help the viewer have an overview of a certain
                            game. In this project, we wrote a collection of websites containing
                            information about a game such as stories, content, images and videos.</p>
                        <div class="cont-info">
                            <div class="ci-icon"><img src="img/icons/location.png" alt=""></div>
                            <div class="ci-text">FPT 大学</div>
                        </div>
                        <div class="cont-info">
                            <div class="ci-icon"><img src="img/icons/phone.png" alt=""></div>
                            <div class="ci-text">+84 589 003 704</div>
                        </div>
                        <div class="cont-info">
                            <div class="ci-icon"><img src="img/icons/mail.png" alt=""></div>
                            <div class="ci-text">QKSVC@gmail.com</div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Contact page end-->



        <!-- Footer section -->
        <footer class="footer-section">
            <div class="container">
                <a href="Home.jsp" class="footer-logo">
                    <img src="img/logoGroup.png" alt="">
                </a>
                <ul class="main-menu footer-menu">
                    <li><a href="Home.jsp">Home</a></li>
                    <li><a href="Games.jsp">Games</a></li>
                    <li><a href="News.jsp">News</a></li>
                    <li><a href="Contact.jsp">Contact</a></li>
                </ul>
                <div class="footer-social d-flex justify-content-center">
                    <a href="#"><i class="fa fa-pinterest"></i></a>
                    <a href="https://www.facebook.com/YiBongChen/?epa=SEARCH_BOX" target="_blank"><i class="fa fa-facebook"></i></a>
                    <a href="#"><i class="fa fa-twitter"></i></a>
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

