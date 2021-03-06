<%@ page import="Model.Client" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.Article" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="Model.Panier" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Accueil</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
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
        <th scope="col">Options</th>
    </tr>
    </thead>
    <tbody>

    <%  Panier panierUser = (Panier) request.getAttribute("userPanier");
        Client user = (Client) request.getAttribute("user");
        HashMap<Integer, Article> listeArticles = (HashMap<Integer, Article>) request.getServletContext().getAttribute("listeArticles");
        for (Article article : listeArticles.values()) { %>
    <tr>
        <td><%=article.getLibelle()%>
        </td>
        <td><%=article.getReference()%>
        </td>
        <td><%=article.getCodeBarre()%>
        </td>
        <td><%=article.getPrixHT()/100.0%>
        </td>
        <td><%=article.getPrixTTC()%>€</td>
        <td>
            <a href="<%=  (String) request.getServletContext().getAttribute("routeBase")%>?article=<%=article.getCodeBarre()%>&action=addPanier" class="btn btn-primary">+</a>
            <% if(user != null) if(user.isAdmin()){ %>
            <a href="<%=  (String) request.getServletContext().getAttribute("routeBase")%>?article=<%=article.getCodeBarre()%>&action=removeDB" class="btn btn-primary">Supprimer</a>
            <% } %>
        </td>
    </tr>
    <% } %>
    </tbody>
</table>

<% if(user != null) if(user.isAdmin()){ %>
<h2 style="margin-left: 30px;">Ajout d'un article</h2>
<form  action="" method="POST" style=" width: 300px; margin-left: 30px;">
    <div class="form-group">
        <label for="libelle"> Libellé : </label>
        <input type="text" class="form-control" dataSource="article.libelle" id="libelle" name="libelle"/><br>
    </div>
    <div class="form-group">
        <label for="reference"> Référence : </label>
        <input type="text" class="form-control" dataSource="article.reference" id="reference" name="reference"/><br>
    </div>
    <div class="form-group">
        <label for="codeBarre"> Code-barre : </label>
        <input type="number" class="form-control" dataSource="article.codeBarre" id="codeBarre" name="codeBarre"
               maxlength="8" size="8" min="8"/><br>
    </div>
    <div class="form-group">
        <label for="prixHT"> Prix HT : </label>
        <input type="number" class="form-control" dataSource="article.prixHT" id="prixHT" name="prixHT"/><br>
    </div>
    <div class="form-group">
        <label for="tauxTVA">Taux TVA</label>
        <select class="form-control" id="tauxTVA" name="tauxTVA">
            <option>5,5%</option>
            <option>20%</option>
        </select>
    </div>
    <button type="submit" class="btn btn-primary">Ajouter</button>
</form>
<% } %>

<div>
    <h3>Votre panier</h3>
    <table class="table" style="width: 80%; ">
    <thead class="thead-dark">
    <tr>
        <th scope="col">Libellé</th>
        <th scope="col">Référence</th>
        <th scope="col">Code-barre</th>
        <th scope="col">Prix HT</th>
        <th scope="col">Prix TTC</th>
        <th scope="col">Options</th>
    </tr>
    </thead>
    <tbody>
    <%  if(panierUser != null){
        int index = 0;
        for (Article article : panierUser) { %>
    <tr>
        <td><%=article.getLibelle()%>
        </td>
        <td><%=article.getReference()%>
        </td>
        <td><%=article.getCodeBarre()%>
        </td>
        <td><%=article.getPrixHT()/100.0%>
        </td>
        <td><%=article.getPrixTTC()%>€</td>
        <td><a href="<%=(String) request.getServletContext().getAttribute("routeBase")%>?article=<%=article.getCodeBarre()%>&articleInd=<%=index++%>&action=delPanier" class="btn btn-primary">-</a></td>
    </tr>
    <% }} %>
    </tbody>
    <tfoot>
        <tr>
            <th scope="col">Total</th>
            <th scope="col"></th>
            <th scope="col"></th>
            <th scope="col"></th>
            <th scope="col"><%= (panierUser != null? panierUser.totalValeur() : 0) %>€</th>
            <th scope="col"></th>
        </tr>
    </tfoot>
    </table>
</div>


<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>

</body>
</html>

