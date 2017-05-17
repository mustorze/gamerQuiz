<%

    String p = request.getParameter("p");

    if (p != null) {

if (p.equals("criar")) {

%>

<%@include file="criar.jsp" %>

<%
    
} else if (p.equals("editar")) {

%>

<%@include file="editar.jsp" %>

<%

} else if (p.equals("excluir")) {

%>

<%@include file="excluir.jsp" %>

<%

}

} else {

%>

<%@include file="home.jsp" %>

<%                                }

%>