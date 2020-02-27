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

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userToken = getCookieValue(request, "tokenUser");
        String panierToken = getCookieValue(request, "tokenPanier");
        Panier userPanier = null;
        if(userToken != null) if(ServletLogin.searchClient(request,userToken) != null){
            request.setAttribute("islogged", true);
            Client user = ServletLogin.searchClient(request,userToken);
            if(user.getPanier() != null){
                panierToken = user.getPanier().toString();
            }
            request.setAttribute("user", user);
            // request.getRequestDispatcher("accueil.jsp").forward(request, response);
        }else{
            request.setAttribute("islogged", false);
            // request.getRequestDispatcher( "/connexion.jsp" ).forward( request, response );
        }
        if(panierToken != null){
            userPanier = ServletLogin.searchPanier(request,panierToken);
        }
        request.setAttribute("userPanier", userPanier);
        request.getRequestDispatcher("accueil.jsp").forward(request, response);
    }
}
