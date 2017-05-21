<%

    String ec = request.getParameter("ec");

%>

<content>

    <div class="container_24">

        <div class="grid_24">

            <div>

                <form method="POST" class="form_type" action="/gamerQuiz/postCadastro">
                    <p>Preencha abaixo para realizar o cadastro</p>

                    <div class="inputs">

                        <div>
                            <input type="text" placeholder="Email" name="email">
                        </div>

                        <div>
                            <input type="text" placeholder="Senha" name="senha">
                        </div>

                        <div>
                            <input type="text" placeholder="Nome" name="nome">
                        </div>

                    </div>

                    <%                            if ("erro".equals(ec)) {

                    %>        

                    <div>

                        <span class="errorForm">Usuario já existe!</span>

                    </div>

                    <%                            }

                    %>

                    <div class="dBtn">
                        <button>Cadastrar</button><button class="bntVoltar"><i class="fa fa-long-arrow-left" aria-hidden="true"></i> Voltar</button>
                    </div>

                </form>

            </div>

        </div>
    </div>

</content>