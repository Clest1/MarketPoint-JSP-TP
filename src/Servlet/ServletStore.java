package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        if(userToken != null){
            request.setAttribute("islogged", true);
            request.getRequestDispatcher("accueil.jsp").forward(request, response);
        }else{
            request.setAttribute("islogged", false);
            this.getServletContext().getRequestDispatcher( "/connexion.jsp" ).forward( request, response );
        }
    }
}
