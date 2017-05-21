<%@page import="br.com.gamer.dao.loginDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="utf-8" />
    <link rel="stylesheet" href="./css/reset.css" />
    <link rel="stylesheet" href="./css/960_24_col.css" />
    <link rel="stylesheet" href="./css/style.css" />
    <link rel="stylesheet" href="./css/font-awesome.min.css" />
    
    <script src="http://mustorze.com/js/jquery-2.1.1.min.js"></script>
    <script src="./js/scripts.js"></script>
    
    <title>Gamer Quiz</title>
</head>

<header>

        <div class="container_24">

            <div class="grid_24">

                <div class="breadCrumb">

                    <ul>
                        <li><a href="/gamerQuiz/" class="btnS">GameQuiz</a></li>
                    </ul>

                </div>

            </div>

            <div class="grid_24">

                <div id="headTop">
                    <h1>GAMER QUIZ</h1>
                </div>

            </div>


        </div>

    </header>

    <body>

        <%

            loginDao l = new loginDao();
            String p = request.getParameter("p");

            if (l.checarLogado(request) == true) {

                if ("quiz".equals(p)) {

        %>

        <%@include file="paginas/quiz.jsp" %>

        <%                } else if ("rank".equals(p)) {

        %>

        <%@include file="paginas/rank.jsp" %>
        
        <%                } else if ("fim".equals(p)) {

        %>

        <%@include file="paginas/fim.jsp" %>

        <%                } else {

        %>

        <%@include file="paginas/in.jsp" %>

        <%                    }

        } else {

            if ("cadastro".equals(p)) {

        %>

        <%@include file="paginas/cadastro.jsp" %>

        <%                    } else {

        %>

        <%@include file="paginas/login.jsp" %>

        <%                }

            }

        %>

    </body>
    
    <footer>

        <div class="container_24">

            <div class="grid_8">

                <h4>Quem somos</h4>

                <ul>
                    <li>Biografia</li>
                    <li>Parceiros</li>
                    <li>Localidade</li>
                </ul>

            </div>

            <div class="grid_8">

                <h4>Contato</h4>

                <ul>
                    <li>Email</li>
                    <li>Fone</li>
                    <li>Telepatia</li>
                </ul>
            </div>

            <div class="grid_8">

                <h4>Redes Sociais</h4>

                <ul>
                    <li>Facebook <i class="fa fa-facebook-square" aria-hidden="true"></i></li>
                    <li>Twitter <i class="fa fa-twitter" aria-hidden="true"></i></li>
                    <li>Instagram <i class="fa fa-instagram" aria-hidden="true"></i></li>
                </ul>
            </div>

        </div>

    </footer>
    
</html>
