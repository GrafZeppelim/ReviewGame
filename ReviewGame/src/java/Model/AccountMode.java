/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/Mode")
@MultipartConfig
public class AccountMode extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UploadMode</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UploadMode at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName = "", passWork = "", email = "", phoneNumber = "", fullName = "";
        int Gender = 1, idTypeAcc = 1, status = 1;

        try {
            AccountModel am = new AccountModel();

            if (ServletFileUpload.isMultipartContent(request)) {
                try {
                    List<FileItem> multiparts = new ServletFileUpload(
                            new DiskFileItemFactory()).parseRequest(request);

                    for (FileItem item : multiparts) {
                        String fieldName = item.getFieldName();
                        String fieldValue = item.getString();

                        switch (fieldName) {
                            case "account":
                                // beforeStep = 1;
                                userName = fieldValue;
                                // afterStep = 1;
                                break;
                            case "password":
                                // beforeStep = 2;
                                passWork = MyUtils.MD5.getMd5(fieldValue);

                                // afterStep = 2;
                                break;

                            case "fullname":
                                // beforeStep = 3;
                                fullName = fieldValue;
                                // afterStep = 3;
                                break;
                            case "gender":
                                // beforeStep = 4;
                                Gender = Integer.parseInt(fieldValue);
                                // afterStep = 4;
                                break;
                            case "email":
                                //beforeStep = 4;
                                email = fieldValue;
                                // afterStep = 5;
                                break;
                            case "phone":
                                // beforeStep = 6;
                                phoneNumber = fieldValue;
                                // afterStep = 6;
                                break;
                        }
                    }
                    if (!am.checkAccountExits(userName)) {
                        //insert new product
                        am.insertAccount(idTypeAcc, userName, passWork, Gender, email, fullName, phoneNumber);
                        response.setContentType("text/html");
                        PrintWriter pw = response.getWriter();
                        RequestDispatcher rd = request.getRequestDispatcher("new-account-mode.jsp");
                        rd.include(request, response);
                        pw.println("<script type=\"text/javascript\">");
                        pw.println("alert('Create account successful');");
                        pw.println("</script>");
                        //File uploaded successfully
                        request.setAttribute("message", "File Uploaded Successfully");
                        response.sendRedirect("dashboard.jsp");
                    } else {
                        response.setContentType("text/html");
                        PrintWriter pw = response.getWriter();
                        RequestDispatcher rd = request.getRequestDispatcher("new-account-mode.jsp");
                        rd.include(request, response);
                        pw.println("<script type=\"text/javascript\">");
                        pw.println("alert('Account was exits');");
                        pw.println("</script>");

                    }
                } catch (Exception ex) {
                    request.setAttribute("message", "File Upload Failed due to " + ex);
                }

            } else {
                request.setAttribute("message",
                        "Sorry this Servlet only handles file upload request");
            }

        } catch (SQLException ex) {
            Logger.getLogger(AccountClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
