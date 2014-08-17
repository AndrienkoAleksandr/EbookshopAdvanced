package com.bookshop.dao.factory;

import com.bookshop.dao.*;

/**
 * Created by USER on 13.08.2014.
 */
public class FactoryDaoJDBC implements FactoryDao{

    public BookDao getBookDao() {
        return new BookDaoImpl();
    }

    public UserDao getUserDao() {
        return new UserDaoImpl();
    }

    public OrderDao getOrderDao() {
        return new OrderDaoImpl();
    }

}
