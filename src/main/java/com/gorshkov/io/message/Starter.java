package com.gorshkov.io.message;

import java.io.IOException;
import java.util.Date;

public class Starter {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        MessageDao messageDao = new DataMessageDao();
        messageDao.save(new Message(new Date(), "hello", 10));
        Message message = messageDao.load();
        System.out.println(message);
    }
}
