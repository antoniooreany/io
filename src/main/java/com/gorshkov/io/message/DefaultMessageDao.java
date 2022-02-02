package com.gorshkov.io.message;

import java.io.*;
import java.util.Date;

public class DefaultMessageDao implements MessageDao {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        MessageDao messageDao = new DefaultMessageDao();
        messageDao.save(new Message(new Date(), "hello", 10));
        Message message = messageDao.load();
        System.out.println(message);
    }

    @Override
    public void save(Message message) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(
                new FileOutputStream("message"))) {
            outputStream.writeObject(message);
        }
    }

    @Override
    public Message load() throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(
                new FileInputStream("message"))) {
            return (Message) inputStream.readObject();
        }
    }
}
