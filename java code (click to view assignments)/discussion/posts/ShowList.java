/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posts;

import java.io.IOException;
import java.util.ArrayList; 
import java.util.List; 
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import posts.model.Post;
import posts.model.FilePostHandler;
import posts.model.PostDataHandler;

/**
 *
 * @author Matthew
 */
@WebServlet(name = "ShowList", urlPatterns = {"/ShowList"})
public class ShowList extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request request
     * @param response response
     * @throws ServletException if a -specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            PostDataHandler handler = new FilePostHandler("discussion.txt");
            request.setAttribute("posts", handler.getFavoritePosts());

            request.getRequestDispatcher("discussions.jsp").forward(request,response);
    }
}
