/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.security.auth.message.callback.PrivateKeyCallback;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

@WebServlet(name = "abc", urlPatterns = {"/abc"})
@MultipartConfig
public class EditFileGame extends HttpServlet {

    String username = "";
    String n = "";
    String name = "";
    private final String UPLOAD_DIRECTORY = "C:\\Users\\fptshop\\Desktop\\[PRJ321][SE1302] Group1  QkSvC\\ReviewGame\\ReviewGame\\web\\ImageUpload\\Game";

    /**
     * POST method
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //process only if its multipart content
        if (ServletFileUpload.isMultipartContent(request)) {
            try {
                List<FileItem> multiparts = new ServletFileUpload(
                        new DiskFileItemFactory()).parseRequest(request);
                String root = getServletContext().getRealPath("/");
                File path = new File(root + "/ImageUpload/Game");
                 System.out.println(path);
                for (FileItem item : multiparts) {

                    if (item.isFormField()) {
                        String fieldname = item.getFieldName();
                        String fieldvalue = item.getString();

                        request.setAttribute(fieldname, fieldvalue);
                    } else {

                        name = new File(item.getName()).getName();
                        item.write(new File(path + File.separator + name));
                        request.setAttribute("file", name);
                    }
                }

                //File uploaded successfully
                request.setAttribute("message", "File Uploaded Successfully");
            } catch (Exception ex) {
                request.setAttribute("message", "File Upload Failed due to " + ex);
            }

        } else {
            request.setAttribute("message",
                    "Sorry this Servlet only handles file upload request");
        }

        request.getRequestDispatcher("/game-edit-save.jsp").forward(request, response);

    }

}
