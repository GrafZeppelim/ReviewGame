package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Model.AccountModel;
import ObjecInfo.Posts;
import Model.PostModel;
import ObjecInfo.Game;
import java.util.ArrayList;
import Model.GameModel;

public final class Home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

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
    int p = 1;
    if (request.getParameter("s") != null) {
        s = request.getParameter("s");
    }
    if (request.getParameter("page") != null) {
        p = Integer.parseInt(request.getParameter("page"));
    }
    ArrayList<Game> list = new ArrayList<Game>();
    ArrayList<Game> TopGame = gm.getTopGame();
    session.setAttribute("getPage", "Home.jsp");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"zxx\">\n");
      out.write("    <head>\n");
      out.write("        <title>QKSVC Home</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"description\" content=\"EndGam Gaming Magazine Template\">\n");
      out.write("        <meta name=\"keywords\" content=\"endGam,gGaming, magazine, html\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <!-- Favicon -->\n");
      out.write("        <link href=\"img/logoGroup.png\" rel=\"shortcut icon\"/>\n");
      out.write("\n");
      out.write("        <!-- Google Font -->\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css?family=Roboto:400,400i,500,500i,700,700i,900,900i\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- Stylesheets -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"cssUser/bootstrap.min.css\"/>\n");
      out.write("        <link rel=\"stylesheet\" href=\"cssUser/font-awesome.min.css\"/>\n");
      out.write("        <link rel=\"stylesheet\" href=\"cssUser/slicknav.min.css\"/>\n");
      out.write("        <link rel=\"stylesheet\" href=\"cssUser/owl.carousel.min.css\"/>\n");
      out.write("        <link rel=\"stylesheet\" href=\"cssUser/magnific-popup.css\"/>\n");
      out.write("        <link rel=\"stylesheet\" href=\"cssUser/animate.css\"/>\n");
      out.write("\n");
      out.write("        <!-- Main Stylesheets -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"cssUser/style.css\"/>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!--[if lt IE 9]>\n");
      out.write("                  <script src=\"https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js\"></script>\n");
      out.write("          <script src=\"https://oss.maxcdn.com/respond/1.4.2/respond.min.js\"></script>\n");
      out.write("        <![endif]-->\n");
      out.write("\n");
      out.write("        <style>\n");
      out.write("            #paging{\n");
      out.write("                padding-left: 0px;\n");
      out.write("                padding-top: 35px;\n");
      out.write("            }\n");
      out.write("            .blog-item {\n");
      out.write("                margin-top: 10px !important;\n");
      out.write("                width: 290px;\n");
      out.write("            }\n");
      out.write("            .blog-item .blog-thumb {\n");
      out.write("                width: 250px;\n");
      out.write("                float: left;\n");
      out.write("                margin-right: 30px;\n");
      out.write("            }\n");
      out.write("            .pagination>.active>a, \n");
      out.write("            .pagination>.active>a:focus, \n");
      out.write("            .pagination>.active>a:hover,\n");
      out.write("            .pagination>.active>span, \n");
      out.write("            .pagination>.active>span:focus,\n");
      out.write("            .pagination>.active>span:hover{\n");
      out.write("                background-color: #b01ba5;\n");
      out.write("                border-color: #b01ba5; \n");
      out.write("            }\n");
      out.write("            .pagination>li>a, .pagination>li>span{\n");
      out.write("                color: #b01ba5;\n");
      out.write("            }\n");
      out.write("            .main-menu li .sub-menu{\n");
      out.write("                padding: 10px;\n");
      out.write("            }\n");
      out.write("            .trending-widget .tw-item {\n");
      out.write("                margin-bottom: 73px;\n");
      out.write("            }\n");
      out.write("            .gianCach{\n");
      out.write("                padding-top: 100px;\n");
      out.write("            }\n");
      out.write("            #TieuDe{\n");
      out.write("                font-size: 30px;\n");
      out.write("                font-weight: bold;\n");
      out.write("                color: white;\n");
      out.write("                padding-top: 40px;\n");
      out.write("                margin-bottom: 0px;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <!-- Page Preloder -->\n");
      out.write("        <div id=\"preloder\">\n");
      out.write("            <div class=\"loader\"></div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!-- Header section -->\n");
      out.write("        <header class=\"header-section\">\n");
      out.write("            <div class=\"header-warp\">\n");
      out.write("                <div class=\"header-social d-flex justify-content-end\">\n");
      out.write("                    <p>Follow us:</p>\n");
      out.write("                    <a href=\"#\"><i class=\"fa fa-pinterest\"></i></a>\n");
      out.write("                    <a href=\"https://www.facebook.com/YiBongChen/?epa=SEARCH_BOX\" target=\"_blank\"><i class=\"fa fa-facebook\"></i></a>\n");
      out.write("                    <a href=\"#\"><i class=\"fa fa-twitter\"></i></a>\n");
      out.write("                    <a href=\"#\"><i class=\"fa fa-dribbble\"></i></a>\n");
      out.write("                    <a href=\"#\"><i class=\"fa fa-behance\"></i></a>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"header-bar-warp d-flex\">\n");
      out.write("                    <!-- site logo -->\n");
      out.write("                    <a href=\"Home.jsp\" class=\"site-logo\">\n");
      out.write("                        <img src=\"./img/logoGroup.png\" alt=\"\">\n");
      out.write("                    </a>\n");
      out.write("                    <nav class=\"top-nav-area w-100\">\n");
      out.write("                        <div class=\"user-panel\">\n");
      out.write("                            ");
                                                                  if (checkLogin) {
                            
      out.write("\n");
      out.write("                            <span>");
      out.print(fullname);
      out.write("</span> - <button class=\"btn-dark\"><a href=\"logout.jsp\">Logout</a></button>\n");
      out.write("                            ");

                            } else {
                            
      out.write("\n");
      out.write("                            <a href=\"login.jsp\">Login</a> / <a href=\"signUp.jsp\">Register</a>\n");
      out.write("                            ");

                                }
                            
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                        <!-- Menu -->\n");
      out.write("                        <ul class=\"main-menu primary-menu\">\n");
      out.write("                            <li><a href=\"Home.jsp\">Home</a></li>\n");
      out.write("                            <li><a href=\"Games.jsp\">Games</a>\n");
      out.write("                                <ul class=\"sub-menu\">\n");
      out.write("                                    <li><a href=\"Games.jsp?cate=1\">Action</a></li>\n");
      out.write("                                    <li><a href=\"Games.jsp?cate=2\">Adventure</a></li>\n");
      out.write("                                    <li><a href=\"Games.jsp?cate=3\">Tactic</a></li>\n");
      out.write("                                    <li><a href=\"Games.jsp?cate=4\">Roleplaying</a></li>\n");
      out.write("                                    <li><a href=\"Games.jsp?cate=5\">Horror</a></li>\n");
      out.write("                                </ul>\n");
      out.write("                            </li>\n");
      out.write("                            <li><a href=\"News.jsp\">News</a></li>\n");
      out.write("                            <li><a href=\"Contact.jsp\">Contact</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </nav>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </header>\n");
      out.write("        <!-- Header section end -->\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- Hero section -->\n");
      out.write("        <section class=\"hero-section overflow-hidden\">\n");
      out.write("            <div class=\"hero-slider owl-carousel\">\n");
      out.write("                <div class=\"hero-item set-bg d-flex align-items-center justify-content-center text-center\" data-setbg=\"img/slider-bg-1.jpg\">\n");
      out.write("                    <div class=\"container\">\n");
      out.write("                        <h2>Game on!</h2>\n");
      out.write("                        <p>A hero need not speak. When he is gone, the world will speak for him</p>                       \n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"hero-item set-bg d-flex align-items-center justify-content-center text-center\" data-setbg=\"img/slider-bg-2.jpg\">\n");
      out.write("                    <div class=\"container\">\n");
      out.write("                        <h2>QKSVC</h2>\n");
      out.write("                        <p>Life is short. Play more</p>\n");
      out.write("                        <a href=\"Contact.jsp\" class=\"site-btn\">Read More  <img src=\"img/icons/double-arrow.png\" alt=\"#\"/></a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </section>\n");
      out.write("        <!-- Hero section end-->\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- Blog section -->\n");
      out.write("        <section class=\"blog-section spad\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-xl-9 col-lg-8 col-md-7\">\n");
      out.write("                        <div class=\"section-title text-white\">\n");
      out.write("                            <h2>All CATEGORIES</h2>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                        <div class=\"blog-text text-box text-white\">\n");
      out.write("                            <p id=\"TieuDe\" >Action\n");
      out.write("                                <a href=\"Games.jsp?cate=1\" class=\"read-more\" style=\"float: right; padding-top: 2%;\">Read More  <img src=\"img/icons/double-arrow.png\" alt=\"#\"/></a>\n");
      out.write("                            </p>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            ");
                                list = gm.ListByCate(1);
                                for (Game game : list) {
                            
      out.write("\n");
      out.write("                            <!-- Blog item -->\n");
      out.write("                            <div class=\"blog-item\">\n");
      out.write("                                <div class=\"blog-thumb\">\n");
      out.write("                                    <img  src=\"ImageUpload/Game/");
      out.print(game.getImage_Game());
      out.write("\" alt=\"");
      out.print(game.getImage_Game());
      out.write("\" style=\"width: 300px; height: 150px\">\n");
      out.write("                                    <div class=\"blog-text text-box text-white\">                                       \n");
      out.write("                                        <h3><a href=\"Blog.jsp?idGame=");
      out.print(game.getID_Game());
      out.write('"');
      out.write('>');
      out.print(game.getName_Game());
      out.write("</a></h3>\n");
      out.write("                                        <p>");
      out.print(gm.printWord(game.getDescription(), 100));
      out.write("</p>\n");
      out.write("\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            ");

                                }
                            
      out.write("\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                        <div class=\"blog-text text-box text-white\">\n");
      out.write("                            <p id=\"TieuDe\">Adventure\n");
      out.write("                                <a href=\"Games.jsp?cate=2\" class=\"read-more\"  style=\"float: right; padding-top: 2%;\">Read More  <img src=\"img/icons/double-arrow.png\" alt=\"#\"/></a>\n");
      out.write("                            </p>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            ");

                                list = gm.ListByCate(2);
                                for (Game game : list) {
                            
      out.write("\n");
      out.write("                            <!-- Blog item -->\n");
      out.write("                            <div class=\"blog-item\">\n");
      out.write("                                <div class=\"blog-thumb\">\n");
      out.write("                                    <img  src=\"ImageUpload/Game/");
      out.print(game.getImage_Game());
      out.write("\" alt=\"");
      out.print(game.getImage_Game());
      out.write("\" style=\"width: 300px; height: 150px\">\n");
      out.write("                                    <div class=\"blog-text text-box text-white\">\n");
      out.write("                                        <h3><a href=\"Blog.jsp?idGame=");
      out.print(game.getID_Game());
      out.write('"');
      out.write('>');
      out.print(game.getName_Game());
      out.write("</a></h3>\n");
      out.write("                                        <p>");
      out.print(gm.printWord(game.getDescription(), 100));
      out.write("</p>\n");
      out.write("\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            ");

                                }
                            
      out.write("\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                        <div class=\"blog-text text-box text-white\">\n");
      out.write("                            <p id=\"TieuDe\">Tactic\n");
      out.write("                                <a href=\"Games.jsp?cate=3\" class=\"read-more\" style=\"float: right; padding-top: 2%;\" >Read More  <img src=\"img/icons/double-arrow.png\" alt=\"#\"/></a>\n");
      out.write("                            </p>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            ");

                                list = gm.ListByCate(3);
                                for (Game game : list) {
                            
      out.write("\n");
      out.write("                            <!-- Blog item -->\n");
      out.write("                            <div class=\"blog-item\">\n");
      out.write("                                <div class=\"blog-thumb\">\n");
      out.write("                                    <img  src=\"ImageUpload/Game/");
      out.print(game.getImage_Game());
      out.write("\" alt=\"");
      out.print(game.getImage_Game());
      out.write("\" style=\"width: 300px; height: 150px\">\n");
      out.write("                                    <div class=\"blog-text text-box text-white\">\n");
      out.write("\n");
      out.write("                                        <h3><a href=\"Blog.jsp?idGame=");
      out.print(game.getID_Game());
      out.write('"');
      out.write('>');
      out.print(game.getName_Game());
      out.write("</a></h3>\n");
      out.write("                                        <p>");
      out.print(gm.printWord(game.getDescription(), 100));
      out.write("</p>\n");
      out.write("\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            ");

                                }
                            
      out.write("\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                        <div class=\"blog-text text-box text-white\">\n");
      out.write("                            <p id=\"TieuDe\">Roleplaying\n");
      out.write("                                <a href=\"Games.jsp?cate=4\" class=\"read-more\" style=\"float: right; padding-top: 2%;\">Read More  <img src=\"img/icons/double-arrow.png\" alt=\"#\"/></a>\n");
      out.write("                            </p>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            ");

                                list = gm.ListByCate(4);
                                for (Game game : list) {
                            
      out.write("\n");
      out.write("                            <!-- Blog item -->\n");
      out.write("                            <div class=\"blog-item\">\n");
      out.write("                                <div class=\"blog-thumb\">\n");
      out.write("                                    <img  src=\"ImageUpload/Game/");
      out.print(game.getImage_Game());
      out.write("\" alt=\"");
      out.print(game.getImage_Game());
      out.write("\" style=\"width: 300px; height: 150px\">\n");
      out.write("                                    <div class=\"blog-text text-box text-white\">       \n");
      out.write("                                        <h3><a href=\"Blog.jsp?idGame=");
      out.print(game.getID_Game());
      out.write('"');
      out.write('>');
      out.print(game.getName_Game());
      out.write("</a></h3>\n");
      out.write("                                        <p>");
      out.print(gm.printWord(game.getDescription(), 100));
      out.write("</p>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            ");

                                }
                            
      out.write("\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                        <div class=\"blog-text text-box text-white\">\n");
      out.write("                            <p id=\"TieuDe\">Horror\n");
      out.write("                                <a href=\"Games.jsp?cate=5\" class=\"read-more\" style=\"float: right; padding-top: 2%;\">Read More  <img src=\"img/icons/double-arrow.png\" alt=\"#\"/></a>\n");
      out.write("                            </p>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            ");

                                list = gm.ListByCate(5);
                                for (Game game : list) {
                            
      out.write("\n");
      out.write("                            <!-- Blog item -->\n");
      out.write("                            <div class=\"blog-item\">\n");
      out.write("                                <div class=\"blog-thumb\">\n");
      out.write("                                    <img  src=\"ImageUpload/Game/");
      out.print(game.getImage_Game());
      out.write("\" alt=\"");
      out.print(game.getImage_Game());
      out.write("\" style=\"width: 300px; height: 150px\">\n");
      out.write("                                    <div class=\"blog-text text-box text-white\">\n");
      out.write("                                        <h3><a href=\"Blog.jsp?idGame=");
      out.print(game.getID_Game());
      out.write('"');
      out.write('>');
      out.print(game.getName_Game());
      out.write("</a></h3>\n");
      out.write("                                        <p>");
      out.print(gm.printWord(game.getDescription(), 100));
      out.write("</p>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            ");

                                }
                            
      out.write("\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <div class=\"col-xl-3 col-lg-4 col-md-5 sidebar\">\n");
      out.write("                        <div id=\"stickySidebar\">\n");
      out.write("                            <div class=\"card\" style=\"background-color: #34164b\" >\n");
      out.write("                                <div class=\"card-body\">\n");
      out.write("                                    <div class=\"widget-item\">\n");
      out.write("                                        <h4 class=\"widget-title\">Trending</h4>\n");
      out.write("                                        <div class=\"trending-widget\">\n");
      out.write("\n");
      out.write("                                            ");
                            for (Game topGame : TopGame) {
                                            
      out.write("\n");
      out.write("                                            <div class=\"tw-item\">\n");
      out.write("                                                <div class=\"tw-thumb\">\n");
      out.write("                                                    <img src=\"ImageUpload/Game/");
      out.print(topGame.getImage_Game());
      out.write("\" alt=\"");
      out.print(topGame.getImage_Game());
      out.write("\" style=\"width: 100px; height: 70px\">\n");
      out.write("                                                </div>\n");
      out.write("                                                <div class=\"tw-text\">\n");
      out.write("                                                    <!--                                            <div class=\"tw-meta\">11.11.18  /  in <a href=\"\">Games</a></div>-->\n");
      out.write("                                                    <h5><a href=\"Blog.jsp?idGame=");
      out.print(topGame.getID_Game());
      out.write('"');
      out.write('>');
      out.print(topGame.getName_Game());
      out.write("</a></h5>\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                            ");

                                                }
                                            
      out.write("                                   \n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <br/>\n");
      out.write("                            <div class=\"widget-item\">\n");
      out.write("                                <div class=\"categories-widget\">\n");
      out.write("                                    <h4 class=\"widget-title\">categories</h4>\n");
      out.write("                                    <ul>\n");
      out.write("                                        <li><a href=\"Games.jsp?cate=1\">Action</a></li>\n");
      out.write("                                        <li><a href=\"Games.jsp?cate=2\">Adventure</a></li>\n");
      out.write("                                        <li><a href=\"Games.jsp?cate=3\">Tactic</a></li>\n");
      out.write("                                        <li><a href=\"Games.jsp?cate=4\">Roleplaying</a></li>\n");
      out.write("                                        <li><a href=\"Games.jsp?cate=5\">Horror</a></li>\n");
      out.write("                                    </ul>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </section>\n");
      out.write("        <!-- Blog section end -->\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- Footer section -->\n");
      out.write("        <footer class=\"footer-section\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <a href=\"Home.jsp\" class=\"footer-logo\">\n");
      out.write("                    <img src=\"./img/logoGroup.png\" alt=\"\">\n");
      out.write("                </a>\n");
      out.write("                <ul class=\"main-menu footer-menu\">\n");
      out.write("                    <li><a href=\"Home.jsp\">Home</a></li>\n");
      out.write("                    <li><a href=\"Games.jsp\">Games</a></li>\n");
      out.write("                    <li><a href=\"News.jsp\">News</a></li>\n");
      out.write("                    <li><a href=\"Contact.jsp\">Contact</a></li>\n");
      out.write("                </ul>\n");
      out.write("                <div class=\"footer-social d-flex justify-content-center\">\n");
      out.write("                    <a href=\"#\"><i class=\"fa fa-pinterest\"></i></a>\n");
      out.write("                    <a href=\"https://www.facebook.com/YiBongChen/?epa=SEARCH_BOX\" target=\"_blank\"><i class=\"fa fa-facebook\"></i></a>\n");
      out.write("                    <a href=\"#\"><i class=\"fa fa-twitter\" target=\"_blank\"></i></a>\n");
      out.write("                    <a href=\"#\"><i class=\"fa fa-dribbble\"></i></a>\n");
      out.write("                    <a href=\"#\"><i class=\"fa fa-behance\"></i></a>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"copyright\"><a href=\"\">QKSVC</a> 2018 @ All rights reserved</div>\n");
      out.write("            </div>\n");
      out.write("        </footer>\n");
      out.write("        <!-- Footer section end -->\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!--====== Javascripts & Jquery ======-->\n");
      out.write("        <script src=\"jsUser/jquery-3.2.1.min.js\"></script>\n");
      out.write("        <script src=\"jsUser/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"jsUser/jquery.slicknav.min.js\"></script>\n");
      out.write("        <script src=\"jsUser/owl.carousel.min.js\"></script>\n");
      out.write("        <script src=\"jsUser/jquery.sticky-sidebar.min.js\"></script>\n");
      out.write("        <script src=\"jsUser/jquery.magnific-popup.min.js\"></script>\n");
      out.write("        <script src=\"jsUser/main.js\"></script>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
