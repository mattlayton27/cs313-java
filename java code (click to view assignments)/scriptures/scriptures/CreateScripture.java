/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scriptures;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import scriptures.model.Scripture;
import scriptures.model.FileScriptureHandler;

/**
 *
 * @author Matthew
 */
@WebServlet(name = "CreateScripture", urlPatterns = {"/CreateScripture"})
public class CreateScripture extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String book = request.getParameter("txtBook");
        int chapter = Integer.parseInt(request.getParameter("txtChapter"));
        int verse = Integer.parseInt(request.getParameter("txtVerse"));

        Scripture newScripture = new Scripture(book, chapter, verse);

        FileScriptureHandler handler = new FileScriptureHandler("list.txt");
        handler.addScripture(newScripture);

        response.sendRedirect("ShowList"); 
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
