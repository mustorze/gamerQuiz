<%@page import="java.util.ArrayList"%>
<%@page import="br.com.gamer.classes.Resultado"%>
<%@page import="br.com.gamer.dao.resultadoDao"%>
<%

    ArrayList<Resultado> cdxz = new ArrayList<Resultado>();
    resultadoDao gddff = new resultadoDao();

    cdxz = gddff.resultados();

    int ix = 1;
%>

<h1>Melhores Resultados</h1>
<div>
    <table>
        <thead>
            <tr><td>Posição</td><td>Usuario</td><td>Pontos</td></tr>
        </thead>
        <tbody>
            <%
                for (Resultado gt : cdxz) {

            %>

            <tr><td><%=ix%></td><td><%=gt.getUsuario_nome()%></td><td><%=gt.getPontuacao()%></td></tr>

            <%

                ix++;
                }

            %>
        </tbody>
    </table>
</div>