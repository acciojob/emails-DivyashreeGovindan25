package com.driver;

import java.util.Date;

public class Mails {
    private Date date;
    private String message;
    private String sender;
    Mails next;

    protected Mails(Date date, String message, String sender) {
        this.date = date;
        this.message = message;
        this.sender = sender;
        next = null;
    }

    public Date getDate() {
        return date;
    }

    public String getMsg() {
        return message;
    }

    public String getSender() {
        return sender;
    }
}
