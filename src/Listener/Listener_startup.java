package Listener;

import Model.Article;
import Model.Client;

import javax.naming.Context;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.util.ArrayList;

@WebListener()
public class Listener_startup implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {

    // Public constructor is required by servlet spec
    public Listener_startup() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
        /* This method is called when the servlet context is
         initialized(when the Web application is deployed).
         You can initialize servlet context related data here.
        */
        // init the values
        ArrayList<Client> listeClients = new ArrayList<Client>();
        ArrayList<Article> listeArticles = new ArrayList<Article>();
        // fill with values
        listeClients.add(new Client("Giboulot","Gabriel","Clest1","1234Test"));
        listeClients.add(new Client("Tuning","Jacky","Jackytuning","bass"));
        listeClients.add(new Client("test","test","test","test"));

        listeArticles.add(new Article("Jus d'orange","juiO",42315375,350,Article.MAP_TVA.get(0)));
        listeArticles.add(new Article("eau de source","oS",54763252,100,Article.MAP_TVA.get(0)));
        listeArticles.add(new Article("Ordinateur portable Atus","CompPAtus",53243252,140000,Article.MAP_TVA.get(1)));
        // set this in the context
        sce.getServletContext().setAttribute("listeClients", listeClients);
        sce.getServletContext().setAttribute("listeArticles", listeArticles);
    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
    }

    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
    }

    // -------------------------------------------------------
    // HttpSessionAttributeListener implementation
    // -------------------------------------------------------

    public void attributeAdded(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute 
         is added to a session.
      */
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute
         is removed from a session.
      */
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
      /* This method is invoked when an attribute
         is replaced in a session.
      */
    }
}
