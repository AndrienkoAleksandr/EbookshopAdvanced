package com.bookshop.service;

import com.bookshop.dao.UserDao;
import com.bookshop.dao.factory.DependencyFactory;
import com.bookshop.dao.factory.FactoryDao;
import com.bookshop.exception.ConnectionException;
import com.bookshop.exception.DataBaseNotFound;
import com.bookshop.model.User;

import java.net.ConnectException;

/**
 * Created by USER on 13.08.2014.
 */
public class UserService {
    private UserDao userDao;
    public UserService() {
        FactoryDao factoryDao = DependencyFactory.getFactory();
        userDao = factoryDao.getUserDao();
    }

    public boolean validUser(String userName) throws ConnectionException, DataBaseNotFound {
        User user = userDao.getUserByName(userName);
        return user == null;
    }

    public boolean addUser(User user) throws ConnectionException, DataBaseNotFound {
        return userDao.addUser(user);
    }
}
