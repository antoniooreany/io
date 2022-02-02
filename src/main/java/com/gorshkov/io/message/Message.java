package com.gorshkov.io.message;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable {
    private Date date;
    private String message;
    private int amount;

    public Message(Date date, String message, int amount) {
        this.date = date;
        this.message = message;
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Message{" +
                "date=" + date +
                ", message='" + message + '\'' +
                ", amount=" + amount +
                '}';
    }
}
