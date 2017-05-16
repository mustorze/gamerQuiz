<%@page import="java.util.ArrayList"%>
<%@page import="br.com.gamer.classes.Escolha"%>
<%@page import="br.com.gamer.dao.perguntaDao"%>
<%@page import="br.com.gamer.classes.Pergunta"%>
<%

    perguntaDao pergDao = new perguntaDao();
    Pergunta perg = new Pergunta();

    perg = pergDao.getRNDPergunta();

    session.setAttribute("qizCerto", perg.getCorreta());

%>
<h1>Acertos: <%= session.getAttribute("qizAcertos")%></h1>
<div>
    <h2><%=perg.getDescricao()%></h2>
    <ul>
        <%

            ArrayList<Escolha> c = new ArrayList<Escolha>();
            c = perg.getEscolhas();

            for (Escolha e : c) {

                out.write("<li><a href='/gamerQuiz/processResp?p=" + e.getId() + "'>" + e.getDescricao() + "</li>");

            }

        %>
    </ul>
</div>
