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
import java.util.UUID;

@WebServlet("/login")
public class ServletLogin extends HttpServlet {

    public static Client searchClient(HttpServletRequest request, String token){
        String pseudo = request.getParameter("pseudo");
        String password = request.getParameter("password");
        ArrayList<Client> listeClients = (ArrayList<Client>) request.getServletContext().getAttribute("listeClients");
        for(Client client : listeClients){
            if ((client.getPseudo().equals(pseudo) && client.isPsswrdSame(password)) || client.isTokenSame(token)) {
                return client;
            }
        }
        return null;
    }

    public static Article searchArticle(HttpServletRequest request){
        String codeBarre = request.getParameter("codeBarre");
        ArrayList<Article> listeArticles = (ArrayList<Article>) request.getServletContext().getAttribute("listeArticles");
        for(Article article : listeArticles){
            if (codeBarre.equals("" + article.getCodeBarre()) ) {
                return article;
            }
        }
        return null;
    }
    public static Panier searchPanier(HttpServletRequest request, String tokenPanier){
        String codeBarre = request.getParameter("codeBarre");
        ArrayList<Panier> listePaniers = (ArrayList<Panier>) request.getServletContext().getAttribute("listePaniers");
        for(Panier panier : listePaniers){
            if (panier.getToken().equals(tokenPanier) ) {
                return panier;
            }
        }
        return null;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pseudo = request.getParameter("pseudo");
        String password = request.getParameter("password");

        ArrayList<Client> listeClients = (ArrayList<Client>) getServletContext().getAttribute("listeClients");
        for(Client client : listeClients) {
            if(client.getPseudo().equals(pseudo) && client.isPsswrdSame(password)) {
                // on génére un nouveau token pour le user
                UUID userToken = UUID.randomUUID();
                client.setToken(userToken);
                getServletContext().setAttribute("listeClients",listeClients);
                // on donne le cookie du token user
                String randomUUIDString = userToken.toString();
                Cookie cookie = new Cookie("tokenUser", randomUUIDString);
                response.addCookie(cookie);
                request.setAttribute("islogged", true);
                this.getServletContext().getRequestDispatcher("/accueil").forward(request, response);
                return;
            }
        }
        request.setAttribute("errorMsg", "Erreur : Login invalide");
        this.getServletContext().getRequestDispatcher("/connexion.jsp").forward(request, response);
        return;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("islogged", false);
        this.getServletContext().getRequestDispatcher( "/connexion.jsp" ).forward( request, response );
    }
}
