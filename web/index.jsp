<%@page import="br.com.gamer.dao.loginDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GamerQuiz</title>
    </head>
    <body>

        <%

            loginDao l = new loginDao();
            String p = request.getParameter("p");

            if (l.checarLogado(request) == true) {

                if ("quiz".equals(p)) {

        %>

        <%@include file="paginas/quiz.jsp" %>

        <%                } else {

        %>

        <%@include file="paginas/in.jsp" %>

        <%                    }

        } else {

        %>

        <%@include file="paginas/login.jsp" %>

        <%                    }

        %>

    </body>
</html>
