<%

    String ec = request.getParameter("ec");
    String e = request.getParameter("e");

%>
<content>

        <div class="container_24">

            <div class="grid_24">

                <div>

                    <form method="POST" class="form_type" id="frmLogin" action="/gamerQuiz/postLogin">
                        <div class="dBtn">
                            <button class="bntAzul">Logar com Facebook</button><button class="bntAzul bntCad">Cadastrar</button>
                        </div>

                        <div class="inputs">

                            <div>
                                <input type="text" placeholder="Email" name="email">
                            </div>

                            <div>
                                <input type="password" placeholder="Senha" name="senha">
                            </div>

                        </div>

                        <div class="dBtn">

                            <div class="alwaysOn">
                                <input type="checkbox">
                                <span>Manter conectado?</span>
                            </div>

                            <button form="frmLogin">Iniciar</button>

                        </div>
                        
                        <%                            if ("true".equals(e)) {

                    %>        

                    <div>

                        <span class="errorForm">Email ou senha invalidos!</span>

                    </div>

                    <%                            }

                    %>
                    
                    <%                            if ("ok".equals(ec)) {

                    %>        

                    <div>

                        <span class="sucessForm">Cadastro realizado com sucesso!</span>

                    </div>

                    <%                            }

                    %>

                    </form>

                </div>

            </div>
        </div>

    </content>