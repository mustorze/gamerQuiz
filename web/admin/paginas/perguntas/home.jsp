<%@page import="br.com.gamer.dao.perguntaDao"%>
<%@page import="br.com.gamer.classes.Pergunta"%>
<%@page import="java.util.ArrayList"%>
<div class="content-box">
    <h1>Perguntas</h1>
    <a class="btn btn-default" href="index.jsp?f=perguntas&p=criar"><i class="glyphicon glyphicon-eye-open"></i> Criar</a>
    <div class="content-box-large">
        <div class="panel-heading">
            <div class="panel-title"></div>
        </div>
        <div class="panel-body">
            <table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="example">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>Ação</th>
                    </tr>
                </thead>
                <tbody>

                    <%

                        perguntaDao c = new perguntaDao();
                        ArrayList<Pergunta> lx = new ArrayList<Pergunta>();

                        lx = c.perguntas();
                        
                        int i = 1;
                        for (Pergunta t : lx) {

                            String descricao = t.getDescricao();
                            int id = t.getId();

                    %>

                    <tr>
                        <td><%=i%></td>
                        <td><%=descricao%></td>
                        <td>
                            
                            <a href="index.jsp?f=perguntas&p=editar&i=<%=id%>" class="btn btn-primary"><i class="glyphicon glyphicon-pencil"></i> Editar</a>
                            <a href="index.jsp?f=perguntas&p=excluir&i=<%=id%>" class="btn btn-danger"><i class="glyphicon glyphicon-remove"></i> Deletar</a>
                            
                        </td>
                    </tr>

                    <%
                        i++;
                        }

                    %>
                </tbody>
            </table>
        </div>
    </div>
</div>