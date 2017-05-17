package br.com.gamer.servlets;

import br.com.gamer.classes.Categoria;
import br.com.gamer.classes.Escolha;
import br.com.gamer.classes.Pergunta;
import br.com.gamer.dao.categoriaDao;
import br.com.gamer.dao.perguntaDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;

public class pegarPergunta extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");

        try (PrintWriter out = response.getWriter()) {

            perguntaDao pergDao = new perguntaDao();
            Pergunta perg;

            String ctgR = request.getParameter("ctg");

            if (ctgR != null) {

                int ctg = Integer.parseInt(ctgR);

                if (ctg > 0 && ctg < 7) {

                    perg = pergDao.getRNDPerguntaPorCategoria(ctg);
                    //perg = pergDao.getRNDPergunta();

                } else {

                    perg = pergDao.getRNDPergunta();

                }

            } else {

                perg = pergDao.getRNDPergunta();

            }

            ArrayList<Escolha> e;
            Categoria csafds;
            categoriaDao cDao = new categoriaDao();

            ArrayList lox = new ArrayList();

            csafds = cDao.buscar(perg.getCategoria_id());

            e = perg.getEscolhas();

            for (Escolha ex : e) {

                lox.add(ex.getDescricao());

            }

            JSONArray jsArray = new JSONArray(lox);

            JSONObject json = new JSONObject();

            json.put("Id", perg.getId());
            json.put("Descricao", perg.getDescricao());
            json.put("Categoria", csafds.getNome());
            json.put("Escolhas", jsArray);
            json.put("Correta", jsArray.get(3));

            out.print(json.toString());

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
