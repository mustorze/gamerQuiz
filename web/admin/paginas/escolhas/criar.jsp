<div class="content-box">
    
    <h1>Categorias - Criar</h1>

    <div class="content-box-large">
        
        <div class="panel-body">
            <%
              
                int px = Integer.parseInt(request.getParameter("px"));

            %>
            <form action="../criarEscolha?px=<%=px%>" method="POST">
                <fieldset>
                    
                    <div class="form-group">
                        <label>Descricao</label>
                        <input class="form-control" placeholder="Descricao" type="text" name="descricao">
                    </div>
                    
                </fieldset>
                
                <div>
                    <input class="btn btn-primary" type="submit" value="Criar">
                </div>
                
            </form>
            
        </div>
        
    </div>

</div>