package br.com.gamer.servlets.admCat;

import br.com.gamer.classes.Escolha;
import br.com.gamer.dao.escolhaDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class salvarEscolha extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String descricao = request.getParameter("descricao");
            String id = request.getParameter("i");
            int px = Integer.parseInt(request.getParameter("px"));
            
            Escolha c = new Escolha();
            c.setDescricao(descricao);
            c.setId(Integer.parseInt(id));
            
            escolhaDao lfr = new escolhaDao();
            
            boolean ok = lfr.salvar(c);
            
            if (ok == true) {
                
                response.sendRedirect("admin/index.jsp?f=perguntas&p=editar&i="+px+"&c=ok");
                
            } else {
                
                response.sendRedirect("admin/index.jsp?f=perguntas&p=editar&i="+px+"&c=ok");
                
            }   
            
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
        processRequest(request, response);
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
