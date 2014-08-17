package com.bookshop.dao;

import com.bookshop.exception.ConnectionException;

/**
 * Created by USER on 13.08.2014.
 */
public interface OrderDao {
    void addOrder() throws ConnectionException;
}
