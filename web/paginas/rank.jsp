<%@page import="java.util.ArrayList"%>
<%@page import="br.com.gamer.classes.Resultado"%>
<%@page import="br.com.gamer.dao.resultadoDao"%>
<%

    ArrayList<Resultado> cdxz = new ArrayList<Resultado>();
    ArrayList<Resultado> cdxzfsd = new ArrayList<Resultado>();
    resultadoDao gddff = new resultadoDao();

    String usrID = session.getAttribute("usrID").toString();

    cdxz = gddff.resultados();
    cdxzfsd = gddff.resultadosByID(Integer.parseInt(usrID));

    int ix = 1;
    int iu = 1;
%>
<content>

    <div class="container_24">

        <div class="grid_24">

            <div class="grid_11">
                <div class="form_type frmRank">
                    <h1>Suas melhores pontuações</h1>
                    <table>
                        <tbody>
                            <%
                                for (Resultado gt : cdxzfsd) {

                            %>

                            <tr><td><%=iu%>°</td><td><%=gt.getPontuacao()%></td></tr>

                            <%

                                    iu++;
                                }

                            %>
                        </tbody>
                    </table>
                </div>
            </div>

            <div class="grid_1">
                ~.~
            </div>

            <div class="grid_11">
                <div class="form_type frmRank">
                    <h1>Rank Global</h1>
                    <table>
                        <tbody>
                            <%                                for (Resultado gt : cdxz) {

                            %>

                            <tr><td><%=ix%>°</td><td><%=gt.getPontuacao()%></td></tr>

                            <%

                                    ix++;
                                }

                            %>
                        </tbody>
                    </table>
                </div>
            </div>

        </div>
    </div>

</content>