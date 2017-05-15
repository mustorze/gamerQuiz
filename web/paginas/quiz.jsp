<%@page import="java.util.ArrayList"%>
<%@page import="br.com.gamer.classes.Escolha"%>
<%@page import="br.com.gamer.dao.perguntaDao"%>
<%@page import="br.com.gamer.classes.Pergunta"%>
<%
    
    perguntaDao pergDao = new perguntaDao();
    Pergunta perg = new Pergunta();
    
    perg = pergDao.getRNDPergunta();
    session.setAttribute("qizCerto", perg.getId());
    
    
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Acertos: <%= session.getAttribute( "qizAcertos" ) %></h1>
        <div>
            <h2><%=perg.getDescricao()%></h2>
            <ul>
                <%
                
                ArrayList<Escolha> c = new ArrayList<Escolha>();
                c = perg.getEscolhas();
                
                for (Escolha e: c) {
                    
                    out.write("<li>" + e.getDescricao() + "</li>");
                    
                }
                
                %>
            </ul>
        </div>
    </body>
</html>
