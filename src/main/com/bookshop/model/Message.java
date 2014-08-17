package com.bookshop.model;

/**
 * Created by User on 16.08.2014.
 */
public class Message {
    String message;
    public Message() {
    }
    public Message(String message) {
        this.message = message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
    @Override
    public String toString() {
        return "Message [message: 'gfg']";
    }
}
