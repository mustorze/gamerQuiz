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
<h1>Acertos: <%= session.getAttribute("qizAcertos")%></h1>
<div>
    <h2><%=perg.getDescricao()%></h2>
    <h3><%=csafds.getNome()%></h3>
    <ul>
        <%

            ArrayList<Escolha> c = new ArrayList<Escolha>();
            c = perg.getEscolhas();

            for (Escolha e : c) {

                out.write("<li><a href='/gamerQuiz/processResp?p=" + e.getId() + "'>" + StringEscapeUtils.escapeHtml4(e.getDescricao()) + "</li>");

            }

        %>
    </ul>
</div>
