<%@page import="br.com.gamer.dao.categoriaDao"%>
<%@page import="br.com.gamer.classes.Categoria"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.gamer.classes.Escolha"%>
<%@page import="br.com.gamer.dao.perguntaDao"%>
<%@page import="br.com.gamer.classes.Pergunta"%>
<%@page import="org.apache.commons.lang3.StringEscapeUtils" %>
<%

    perguntaDao pergDao = new perguntaDao();
    Pergunta perg = new Pergunta();

    perg = pergDao.getRNDPergunta();

    Categoria csafds;
    categoriaDao cDao = new categoriaDao();
    csafds = cDao.buscar(perg.getCategoria_id());

    session.setAttribute("qizCerto", perg.getCorreta());

%>

<content>

    <div class="container_24">

        <div class="grid_24">

            <div class="form_type frmQuiz">

                <h3><%=csafds.getNome()%></h3>
                <h1><%=perg.getDescricao()%></h1>


                <ul>
                    <%

                        ArrayList<Escolha> c = new ArrayList<Escolha>();
                        c = perg.getEscolhas();

                        for (Escolha e : c) {

                            out.write("<li><a href='/gamerQuiz/processResp?p=" + e.getId() + "'>" + StringEscapeUtils.escapeHtml4(e.getDescricao()) + "</a></li>");

                        }

                    %>
                </ul>

            </div>

            <div class="form_type pontos">

                <h1>Acertos: <%= session.getAttribute("qizAcertos")%></h1>

            </div>

        </div>
    </div>

</content>