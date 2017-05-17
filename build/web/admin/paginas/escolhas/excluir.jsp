<%@page import="br.com.gamer.dao.escolhaDao"%>
<%@page import="br.com.gamer.classes.Escolha"%>
<div class="content-box">
    
    <h1>Categorias - Excluir</h1>

    <div class="content-box-large">
        
        <div class="panel-body">
            
            <%
                
                int id = Integer.parseInt(request.getParameter("i"));
                int px = Integer.parseInt(request.getParameter("px"));
                
                escolhaDao ld = new escolhaDao();
                Escolha c = new Escolha();
                c = ld.buscarEscolha(id);
                
                String nome = c.getDescricao();
                int idx = c.getId();
                
            %>
            
            <form action="../excluirEscolha?i=<%=idx%>&px=<%=px%>" method="POST">
                <fieldset>
                    
                    <h3>Você deseja mesmo excluir a escolha: <%=nome%>?</h3>
                    
                </fieldset>
                
                <div>
                    <input class="btn btn-primary" type="submit" value="Excluir">
                </div>
                
            </form>
            
        </div>
        
    </div>

</div>