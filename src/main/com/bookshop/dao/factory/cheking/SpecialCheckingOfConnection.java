package com.bookshop.dao.factory.cheking;

import com.bookshop.exception.ConnectionException;
import com.bookshop.exception.DataBaseNotFound;

/**
 * Created by User on 16.08.2014.
 */
public class SpecialCheckingOfConnection {
    public synchronized static void checkConnection(Exception e) throws ConnectionException, DataBaseNotFound{
        if (e.getLocalizedMessage().equals("Access denied for user 'root'@'localhost' (using password: YES)")) {
            throw new ConnectionException("Couldn't connect to data base.");
        }
        if (e.getLocalizedMessage().equals("Unknown database 'ebookshop'")) {
            throw new DataBaseNotFound("Data Base Not Found.");
        }
    }

}
