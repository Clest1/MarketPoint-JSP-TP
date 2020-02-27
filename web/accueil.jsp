<%@ page import="Model.Client" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.Article" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: Gabriel
  Date: 26/02/2020
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Accueil</title>
</head>
<body>
<jsp:include page="navBar.jsp"></jsp:include>
    <div>ACCUEIL</div>
<h2>Liste articles</h2>
<%
    Client userConnected = (Client) request.getAttribute( "user" );
    HashMap<Integer, Article> listeArticles = (HashMap<Integer, Article>) request.getServletContext().getAttribute( "listeArticles" );
    for (Article article : listeArticles.values()) { %>
        <div>
            <h4>libelle : <%=article.getLibelle()%></h4><br/>
            <p>Ref : <%=article.getReference()%></p><br/>
            <p>CB : <%=article.getCodeBarre()%></p><br/>
            <p>prixTTC : <%=article.getPrixTTC()%>€</p>
        </div>
    <% } %>
</body>
</html>
