package Servlet;

import Model.Client;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

@WebServlet(name = "delog")
public class ServletDelog extends HttpServlet {

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
    private static Cookie[] setCookieValue( HttpServletRequest request, String nom, String value ) {
        Cookie[] cookies = request.getCookies();
        if ( cookies != null ) {
            for ( Cookie cookie : cookies ) {
                if ( cookie != null && nom.equals( cookie.getName() ) ) {
                    cookie.setValue(value);
                    return cookies;
                }
            }
        }
        return cookies;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Client> listeClients = (ArrayList<Client>) getServletContext().getAttribute("listeClients");
        String userToken = getCookieValue(request, "tokenUser");
        for(Client client : listeClients) {
            if(client.isTokenSame(userToken)) {
                // on retire le token du cookie du user
                Cookie cookie = new Cookie("tokenUser", null);
                cookie.setMaxAge(0);
                response.addCookie(cookie);
                request.setAttribute("islogged", false);
                this.getServletContext().getRequestDispatcher("/accueil.jsp").forward(request, response);
                return;
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
