package com.bookshop.exception;

/**
 * Created by User on 16.08.2014.
 */
public class DataBaseNotFound extends RuntimeException {
    public DataBaseNotFound(String message) {
        super(message);
    }

    public DataBaseNotFound() {
    }
}
