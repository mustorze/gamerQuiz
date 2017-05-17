<%@page import="br.com.gamer.classes.Usuario"%>
<%@page import="br.com.gamer.dao.loginDao"%>
<%

    loginDao l = new loginDao();
    String f = request.getParameter("f");

    if (l.checarLogado(request) == true) {

        String usrIDS = session.getAttribute("usrID").toString();
        int usrID = Integer.parseInt(usrIDS);

        Usuario usr;
        usr = l.buscarUsr(usrID);

        if (usr.getAdmin() > 0) {

            if ("categorias".equals(f)) {

%>

<%@include file="categoria/index.jsp" %>

<%} else if ("escolhas".equals(f)) {

%>

<%@include file="escolhas/index.jsp" %>

<%} else if ("perguntas".equals(f)) {

%>

<%@include file="perguntas/index.jsp" %>

<%} else {

%>

<%@include file="home.jsp" %>

<%                        }

        } else {

            response.sendRedirect("/gamerQuiz/");

        }

    } else {

        response.sendRedirect("/gamerQuiz/");

    }

%>