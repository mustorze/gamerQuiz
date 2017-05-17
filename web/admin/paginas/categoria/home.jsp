<%@page import="br.com.gamer.dao.categoriaDao"%>
<%@page import="br.com.gamer.classes.Categoria"%>
<%@page import="java.util.ArrayList"%>
<h1>Categorias</h1>
<a class="btn btn-default" href="index.jsp?f=categorias&p=criar"><i class="glyphicon glyphicon-eye-open"></i> Criar</a>
<div>
    <table cellpadding="0" cellspacing="0" border="0">
        <thead>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Ação</th>
            </tr>
        </thead>
        <tbody>

            <%

                categoriaDao c = new categoriaDao();
                ArrayList<Categoria> lx = new ArrayList<Categoria>();

                lx = c.categorias();

                int i = 1;
                for (Categoria t : lx) {

                    String nome = t.getNome();
                    int id = t.getId();

            %>

            <tr>
                <td><%=i%></td>
                <td><%=nome%></td>
                <td>

                    <a href="index.jsp?f=categorias&p=editar&i=<%=id%>" class="btn btn-primary"><i class="glyphicon glyphicon-pencil"></i> Editar</a>
                    <a href="index.jsp?f=categorias&p=excluir&i=<%=id%>" class="btn btn-danger"><i class="glyphicon glyphicon-remove"></i> Deletar</a>

                </td>
            </tr>

            <%
                    i++;
                }

            %>
        </tbody>
    </table>
</div>