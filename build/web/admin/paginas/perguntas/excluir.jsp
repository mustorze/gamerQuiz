<%@page import="br.com.gamer.dao.perguntaDao"%>
<%@page import="br.com.gamer.classes.Pergunta"%>
<div class="content-box">
    
    <h1>Categorias - Excluir</h1>

    <div class="content-box-large">
        
        <div class="panel-body">
            
            <%
                
                int id = Integer.parseInt(request.getParameter("i"));
                
                perguntaDao ld = new perguntaDao();
                Pergunta c = new Pergunta();
                c = ld.buscarPergunta(id);
                
                String nome = c.getDescricao();
                int idx = c.getId();
                
            %>
            
            <form action="../excluirPergunta?i=<%=idx%>" method="POST">
                <fieldset>
                    
                    <h3>Você deseja mesmo excluir a pergunta: <%=nome%>?</h3>
                    
                </fieldset>
                
                <div>
                    <input class="btn btn-primary" type="submit" value="Excluir">
                </div>
                
            </form>
            
        </div>
        
    </div>

</div>