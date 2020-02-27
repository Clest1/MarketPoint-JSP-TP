<%@ page import="Model.Client" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.Article" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Accueil</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<jsp:include page="navBar.jsp"></jsp:include>
<h1 style="margin-top: 30px; margin-left: 30px;">Liste des articles disponibles : </h1>
<table class="table" style="width: 80%; margin-top: 30px; margin-left: 30px; ">
    <thead class="thead-dark">
    <tr>
        <th scope="col">Libellé</th>
        <th scope="col">Référence</th>
        <th scope="col">Code-barre</th>
        <th scope="col">Prix HT</th>
        <th scope="col">Prix TTC</th>
    </tr>
    </thead>
    <tbody>

    <%
        Client userConnected = (Client) request.getAttribute( "user" );
        HashMap<Integer, Article> listeArticles = (HashMap<Integer, Article>) request.getServletContext().getAttribute( "listeArticles" );
        for (Article article : listeArticles.values()) { %>
    <tr>
    <td><%=article.getLibelle()%></td>
    <td><%=article.getReference()%></td>
    <td><%=article.getCodeBarre()%></td>
    <td><%=article.getPrixHT()%></td>
    <td><%=article.getPrixTTC()%>€</td>
    </tr>
    <% } %>

    </tbody>
</table>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

</body>
</html>

