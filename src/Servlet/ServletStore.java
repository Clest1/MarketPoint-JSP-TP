package Servlet;

import Model.Article;
import Model.Client;
import Model.Panier;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet("/")
public class ServletStore extends HttpServlet {

    private static String getCookieValue( HttpServletRequest request, String nom ) {
        Cookie[] cookies = request.getCookies();
        if ( cookies != null ) {
            for ( Cookie cookie : cookies ) {
                if ( cookie != null && nom.equals( cookie.getName() ) ) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userToken = getCookieValue(request, "tokenUser");
        Client user = null;
        if(userToken != null) if(ServletLogin.searchClient(request,userToken) != null) {
            request.setAttribute("islogged", true);
            user = ServletLogin.searchClient(request, userToken);
            if(!user.isAdmin()){
                response.sendRedirect( (String) getServletContext().getAttribute("routeBase"));
                return;
            }
        }
        String libelle = request.getParameter("libelle");
        String reference = request.getParameter("reference");
        int codeBarre = Integer.parseInt(request.getParameter("codeBarre"));
        int prixHT = Integer.parseInt(request.getParameter("prixHT"))*100;
        String tauxTVAInput = request.getParameter("tauxTVA");
        int tauxTVA = 0;
        switch (tauxTVAInput){
            case "5,5%":
                tauxTVA = Article.MAP_TVA.get(0);
                break;
            case "20%":
                tauxTVA = Article.MAP_TVA.get(1);
                break;
            default:
                tauxTVA = Article.MAP_TVA.get(1);
                break;
        }
        Article article = new Article(libelle,reference,codeBarre,prixHT,tauxTVA);


        HashMap<Integer, Article> listeArticles = (HashMap<Integer, Article>) getServletContext().getAttribute("listeArticles");
        listeArticles.put(codeBarre,article);
        getServletContext().setAttribute("listeArticles",listeArticles);
        response.sendRedirect( (String) getServletContext().getAttribute("routeBase"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // on initialise les valeurs
        String userToken = getCookieValue(request, "tokenUser");
        String panierToken = getCookieValue(request, "tokenPanier");
        Panier userPanier = null;
        Client user = null;
        // on cherche l'utilisateur dans la DB
        if(userToken != null) if(ServletLogin.searchClient(request,userToken) != null){
            request.setAttribute("islogged", true);
            user = ServletLogin.searchClient(request,userToken);
            request.setAttribute("user", user);
            if(user.getPanier() != null){
                panierToken = user.getPanier().toString();
            }
            request.setAttribute("user", user);
            // request.getRequestDispatcher("accueil.jsp").forward(request, response);
        }else{
            request.setAttribute("islogged", false);
            // request.getRequestDispatcher( "/connexion.jsp" ).forward( request, response );
        }
        // on va faire le traitement du panier
        ArrayList<Panier> listePaniers = (ArrayList<Panier>) request.getServletContext().getAttribute("listePaniers");
        if(panierToken != null) if(ServletLogin.searchPanier(request,panierToken) != null) {
            userPanier = ServletLogin.searchPanier(request, panierToken);
        }
        if(userPanier == null){
            // on va tenter de lier le panier à l'utilisateur
            int idUser = -1;
            if(user != null) idUser = user.getId();
            userPanier = new Panier(idUser);
            listePaniers.add(userPanier);
            if(idUser == -1){
                Cookie cookie = new Cookie("tokenPanier", userPanier.getToken().toString());
                response.addCookie(cookie);
            }else{
                if(user.isAdmin())
                    user.setPanier(userPanier.getToken());
                else
                    request.setAttribute("errorMsg", "Erreur : Vous devez être admin");
            }
        }
        String codeBarrePar = request.getParameter("article");
        String action = request.getParameter("action");
        if(codeBarrePar != null && action != null) {
            int codeBarre = Integer.parseInt(request.getParameter("article"));
            HashMap<Integer, Article> listeArticles = (HashMap<Integer, Article>) getServletContext().getAttribute("listeArticles");
            switch (action) {
                case "addPanier":
                    userPanier.add(listeArticles.get(codeBarre));
                    break;
                case "delPanier":
                    String indexPar = request.getParameter("articleInd");
                    if(indexPar != null) {
                        int index = Integer.parseInt(indexPar);
                        if (index < userPanier.size() && index >= 0){
                            userPanier.remove(index);
                        }
                    }
                    break;
                case "removeDB":
                    listeArticles.remove(codeBarre);
                    break;
                default:
                    break;
            }
        }
        request.setAttribute("userPanier", userPanier);
        request.getRequestDispatcher("accueil.jsp").forward(request, response);
    }
}
