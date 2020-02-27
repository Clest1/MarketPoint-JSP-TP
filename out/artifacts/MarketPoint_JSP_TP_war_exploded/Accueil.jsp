<%@ page import="Model.Client" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.Article" %><%--
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
    ArrayList<Article> listeArticles = (ArrayList<Article>) request.getAttribute( "listeArticles" );
%>
<c:forEach items="${listeArticles}" var="article">
    <jsp:include page="article.jsp"></jsp:include>
</c:forEach>
</body>
</html>
