<%--
  Created by IntelliJ IDEA.
  User: Gabriel
  Date: 26/02/2020
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Connexion</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<jsp:include page="navBar.jsp"></jsp:include>
<div style="margin-left: 30px; margin-top: 30px;">
    <h1>Connexion : </h1><br>

    <form  action="login" method="POST" style=" width: 300px;">
        <div class="form-group">
            <label for="pseudo"> Pseudonyme : </label>
            <input type="text" class="form-control" dataSource="client.pseudo" id="pseudo" name="pseudo"/>
        </div>
        <div class="form-group">
            <label for="password"> Mot de passe : </label>
            <input type="password" class="form-control" dataSource="client.motDePasse" id="password" name="password">
        </div>
        <button type="submit" class="btn btn-primary">Connexion</button>
    </form>
    <p> L'inscription en tant que client permet de sauvegarder en ligne son panier, le modifier, ajouter ou supprimer un article.</p>
</div>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>