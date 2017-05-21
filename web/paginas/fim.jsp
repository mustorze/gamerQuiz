<%
  
String pt = request.getParameter("pt");

%>
<content>

    <div class="container_24">

        <div class="grid_24">

            <div class="form_type frmFim">

                <h1>Você Errou!!!</h1>
                <h2>Sua pontuação foi: <%=pt%></h2>

                <div class="dBtn">

                    <button class="bntInit">Voltar</button>
                    <button class="bntRank">Ir para o Ranking</button>

                </div>

            </div>

        </div>
    </div>

</content>