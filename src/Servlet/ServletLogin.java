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

@WebServlet("/login")
public class ServletLogin extends HttpServlet {
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

                this.getServletContext().getRequestDispatcher("/accueil.jsp").forward(request, response);
                return;
            }
        }
        request.setAttribute("errorMsg", "Message : " + pseudo + " " + password);
        this.getServletContext().getRequestDispatcher("/connexion.jsp").forward(request, response);
        return;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher( "/connexion.jsp" ).forward( request, response );
    }
}
