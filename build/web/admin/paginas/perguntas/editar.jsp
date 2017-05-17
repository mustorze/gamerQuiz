<%@page import="br.com.gamer.classes.Escolha"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.gamer.classes.Categoria"%>
<%@page import="br.com.gamer.dao.categoriaDao"%>
<%@page import="br.com.gamer.dao.perguntaDao"%>
<%@page import="br.com.gamer.classes.Pergunta"%>
<div class="content-box">

    <h1>Produtos - Editar</h1>

    <div class="content-box-large">

        <div class="panel-body">

            <%

                int id = Integer.parseInt(request.getParameter("i"));

                perguntaDao ld = new perguntaDao();
                Pergunta c = new Pergunta();
                c = ld.buscarPergunta(id);

                String descricao = c.getDescricao();

                int correta = Integer.parseInt(c.getCorreta());

                int idx = c.getId();
                int categoriaP = c.getCategoria_id();

            %>

            <form action="../salvarPergunta?i=<%=idx%>" method="POST">
                <fieldset>

                    <div class="form-group">
                        <label>Descrição</label>
                        <input class="form-control" placeholder="Descrição" type="text" name="descricao" value="<%=descricao%>">
                    </div>


                    <div class="form-group">
                        <label>Categoria</label>
                        <select name="categoria" class="form-control">

                            <%

                                categoriaDao cx = new categoriaDao();
                                ArrayList<Categoria> lxx = new ArrayList<Categoria>();

                                lxx = cx.categorias();

                                int i = 1;
                                for (Categoria t : lxx) {

                                    if (categoriaP == t.getId()) {

                                        out.write("<option value='" + t.getId() + "' SELECTED>" + t.getNome() + "</option>");

                                    } else {

                                        out.write("<option value='" + t.getId() + "'>" + t.getNome() + "</option>");

                                    }

                                }

                            %>

                        </select>
                    </div>

                    <a class="btn btn-default" href="index.jsp?f=escolhas&p=criar&px=<%=id%>"><i class="glyphicon glyphicon-eye-open"></i> Criar</a>

                    <table>

                        <thead>
                            <tr><td>#</td><td>Descrição</td><td></td></tr>
                        </thead>

                        <%                                int ix = 1;
                            for (Escolha xdf : c.getEscolhas()) {

                                String descricaoES = xdf.getDescricao();
                                int idxES = xdf.getId();

                        %>

                        <tbody>
                            <tr>
                                <td><%=i%></td>
                                <td><%=descricaoES%></td>
                                <td>

                                    <a href="index.jsp?f=escolhas&p=editar&i=<%=idxES%>&px=<%=id%>" class="btn btn-primary"><i class="glyphicon glyphicon-pencil"></i> Editar</a>
                                    <a href="index.jsp?f=escolhas&p=excluir&i=<%=idxES%>&px=<%=id%>" class="btn btn-danger"><i class="glyphicon glyphicon-remove"></i> Deletar</a>

                                    <% if (Integer.parseInt(c.getCorreta()) != idxES) {%>

                                    <a href="../escolhaCerta?i=<%=idxES%>&px=<%=id%>" class="btn btn-danger"><i class="glyphicon glyphicon-remove"></i> Definir Certa</a>
                                    <% } else { %>
                                    Certa
                                    <% } %>
                                </td>
                            </tr>
                        </tbody>

                        <%
                                i++;
                            }

                        %>

                    </table>

                </fieldset>

                <div>
                    <input class="btn btn-primary" type="submit" value="Salvar">
                </div>

            </form>

        </div>

    </div>

</div>