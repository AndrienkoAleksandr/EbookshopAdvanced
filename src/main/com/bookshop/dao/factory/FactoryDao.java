package com.bookshop.dao.factory;

import com.bookshop.dao.*;

/**
 * Created by USER on 13.08.2014.
 */
public interface FactoryDao {
    public FactoryDao FACTORY_DAO = new FactoryDaoJDBC();
    public BookDao getBookDao();

    public UserDao getUserDao();

    public OrderDao getOrderDao();
}
