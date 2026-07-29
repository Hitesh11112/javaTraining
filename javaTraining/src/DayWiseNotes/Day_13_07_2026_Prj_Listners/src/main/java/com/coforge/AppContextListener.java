package com.coforge;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class AppContextListener
 *
 */
@WebListener
public class AppContextListener implements ServletContextListener {

	
    public AppContextListener() {
    	
    	
    }
    
    public void contextInitialized(ServletContextEvent sce) {
    	
    	ServletContextListener.super.contextInitialized(sce);
    	
    	ServletContext context = sce.getServletContext();
    	context.setAttribute("count", 0);
    	System.out.println("Application started");
    		
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    	
    	ServletContextListener.super.contextDestroyed(sce);

    	ServletContext context = sce.getServletContext();
    	
    	Object count = context.getAttribute("count");

    	context.log("Number of hits : " + count);

    	context.log("Application stopped");
    	System.out.println("Applicaton stopped with total count of : " + count);
    }
}
