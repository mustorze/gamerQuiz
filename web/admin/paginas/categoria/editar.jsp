<%@page import="br.com.gamer.dao.categoriaDao"%>
<%@page import="br.com.gamer.classes.Categoria"%>
<div class="content-box">
    
    <h1>Categorias - Editar</h1>

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
            
            <form action="../salvarCategoria?i=<%=idx%>" method="POST">
                <fieldset>
                    
                    <div class="form-group">
                        <label>Nome</label>
                        <input class="form-control" placeholder="Nome" type="text" name="nome" value="<%=nome%>">
                    </div>
                    
                </fieldset>
                
                <div>
                    <input class="btn btn-primary" type="submit" value="Salvar">
                </div>
                
            </form>
            
        </div>
        
    </div>

</div>