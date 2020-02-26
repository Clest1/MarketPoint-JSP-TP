package Servlet;

import Model.Client;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/register")
public class ServletRegister extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String pseudo = request.getParameter("pseudo");
        String password = request.getParameter("password");
        Client client = new Client(nom,prenom,pseudo,password);

        ArrayList<Client> listeClients = (ArrayList<Client>) getServletContext().getAttribute("listeClients");
        listeClients.add(client);
        getServletContext().setAttribute("listeClients",listeClients);

        this.getServletContext().getRequestDispatcher("/connexion.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/inscription.jsp").forward(request, response);
    }
}
