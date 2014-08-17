package com.bookshop.servlets;

import com.bookshop.dao.factory.DependencyFactory;
import com.bookshop.util.DataBaseConnection;
import com.bookshop.util.DataBaseConnection;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by USER on 13.08.2014.
 */
public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        String typeDao = servletContextEvent.getServletContext().getInitParameter("type");
        DependencyFactory.setTypeFactor(typeDao);
        DataBaseConnection.setUrlBaseDate(servletContextEvent.getServletContext().getInitParameter("urlBaseDate"));
        DataBaseConnection.setUserName(servletContextEvent.getServletContext().getInitParameter("userName"));
        DataBaseConnection.setPassword(servletContextEvent.getServletContext().getInitParameter("password"));
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
