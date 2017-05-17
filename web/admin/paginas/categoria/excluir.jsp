<%@page import="br.com.gamer.dao.categoriaDao"%>
<%@page import="br.com.gamer.classes.Categoria"%>
<div class="content-box">
    
    <h1>Categorias - Excluir</h1>

    <div class="content-box-large">
        
        <div class="panel-body">
            
            <%
                
                int id = Integer.parseInt(request.getParameter("i"));
                
                categoriaDao ld = new categoriaDao();
                Categoria c = new Categoria();
                c = ld.buscar(id);
                
                String nome = c.getNome();
                int idx = c.getId();
                
            %>
            
            <form action="../excluirCategoria?i=<%=idx%>" method="POST">
                <fieldset>
                    
                    <h3>Você deseja mesmo excluir a categoria: <%=nome%>?</h3>
                    
                </fieldset>
                
                <div>
                    <input class="btn btn-primary" type="submit" value="Excluir">
                </div>
                
            </form>
            
        </div>
        
    </div>

</div>