package com.bookshop.exception;

import javax.servlet.ServletException;

/**
 * Created by User on 15.08.2014.
 */
public class ConnectionException extends RuntimeException {
    public ConnectionException() {
    }

    public ConnectionException(String message) {
        super(message);
    }
}
