<%@page import="br.com.gamer.dao.categoriaDao"%>
<%@page import="br.com.gamer.classes.Categoria"%>
<%@page import="java.util.ArrayList"%>
<div class="content-box">

    <h1>Produtos - Criar</h1>

    <div class="content-box-large">

        <div class="panel-body">

            <form action="../criarPergunta" method="POST">
                <fieldset>
                    
                    <div class="form-group">
                        <label>Titulo</label>
                        <input class="form-control" placeholder="Descrição" type="text" name="descricao">
                    </div>
                    

                    <div class="form-group">
                        <label>Categoria</label>
                        <select name="categoria" class="form-control">

                            <%
                                
                                categoriaDao c = new categoriaDao();
                                ArrayList<Categoria> lx = new ArrayList<Categoria>();

                                lx = c.categorias();

                                int i = 1;
                                for (Categoria t : lx) {

                                    out.write("<option value='" + t.getId() + "'>" + t.getNome()+ "</option>");

                                }

                            %>

                        </select>
                    </div>

                </fieldset>

                <div>
                    <input class="btn btn-primary" type="submit" value="Criar">
                </div>

            </form>

        </div>

    </div>

</div>