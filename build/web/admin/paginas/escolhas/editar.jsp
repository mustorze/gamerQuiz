<%@page import="br.com.gamer.dao.escolhaDao"%>
<%@page import="br.com.gamer.classes.Escolha"%>
<div class="content-box">
    
    <h1>Categorias - Editar</h1>

    <div class="content-box-large">
        
        <div class="panel-body">
            
            <%
                
                int id = Integer.parseInt(request.getParameter("i"));
                int px = Integer.parseInt(request.getParameter("px"));
                
                escolhaDao ld = new escolhaDao();
                Escolha c = new Escolha();
                c = ld.buscarEscolha(id);
                
                String descricao = c.getDescricao();
                int idx = c.getId();
                
            %>
            
            <form action="../salvarEscolha?i=<%=idx%>&px=<%=px%>" method="POST">
                <fieldset>
                    
                    <div class="form-group">
                        <label>Descrição</label>
                        <input class="form-control" placeholder="Nome" type="text" name="descricao" value="<%=descricao%>">
                    </div>
                    
                </fieldset>
                
                <div>
                    <input class="btn btn-primary" type="submit" value="Salvar">
                </div>
                
            </form>
            
        </div>
        
    </div>

</div>