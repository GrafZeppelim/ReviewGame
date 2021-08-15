

<%@page import="ObjecInfo.Account"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.AccountModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%

    String username = request.getParameter("txtUsername").toLowerCase();
    String password = request.getParameter("txtPassword");
    String MD5pass = MyUtils.MD5.getMd5(password);
    AccountModel am = new AccountModel();
    ArrayList<Account> listAcc = am.loadAccount();

//    if(username.equals(password)){
//        session.setAttribute("username", username);
//    }else if (session.getAttribute("username") != null){
//        session.removeAttribute("username");
//    }
    for (Account acc : listAcc) {
        if (username.equals(acc.getUserName().toLowerCase()) && MD5pass.equals(acc.getPassword()) && acc.getID_TypeAccount() == 1) {
            session.setAttribute("username", username);
            session.setAttribute("typeaccount", "1");
            session.setAttribute("iduser", acc.getID_Account());
            break;
        } else if (username.equals(acc.getUserName().toLowerCase()) && MD5pass.equals(acc.getPassword()) && acc.getID_TypeAccount() == 2) {
            session.setAttribute("username", username);
            session.setAttribute("typeaccount", "2");
            session.setAttribute("iduser", acc.getID_Account());
            break;
        } else if (username.equals(acc.getUserName().toLowerCase()) && MD5pass.equals(acc.getPassword()) && acc.getID_TypeAccount() == 0) {
            session.setAttribute("username", username);
            session.setAttribute("typeaccount", "0");
            session.setAttribute("iduser", acc.getID_Account());
            break;
        }else if (session.getAttribute("username") != null) {
            session.removeAttribute("username");
            session.removeAttribute("typeaccount");
            session.removeAttribute("iduser");
        }
    }
    response.sendRedirect("index.jsp");

%>
