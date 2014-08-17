package com.bookshop.dao.factory;

/**
 * Created by USER on 13.08.2014.
 */
public class DependencyFactory {
    private static String typeFactor;
    private static FactoryDao factoryDAO;

    public static void setTypeFactor(String typeFactor1) {
        typeFactor = typeFactor1;
    }

    public static FactoryDao getFactory() {
        switch (typeFactor) {
            case "JDBC":
                factoryDAO = new FactoryDaoJDBC();
                break;
            case "Hibernate":
                break;
            default:
                factoryDAO = new FactoryDaoJDBC();
                break;
        }
        return factoryDAO;
    }
}
