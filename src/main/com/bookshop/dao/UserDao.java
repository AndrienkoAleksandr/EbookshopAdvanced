package com.bookshop.dao;

import com.bookshop.exception.ConnectionException;
import com.bookshop.exception.DataBaseNotFound;
import com.bookshop.model.User;

import java.net.ConnectException;

/**
 * Created by USER on 13.08.2014.
 */
public interface UserDao {
    User getUserByName(String userName) throws ConnectionException, DataBaseNotFound;
    boolean addUser(User user) throws ConnectionException, DataBaseNotFound;
}
