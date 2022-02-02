package com.gorshkov.io.message;

import java.io.*;
import java.util.Date;

public class DataMessageDao implements MessageDao {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        MessageDao messageDao = new DataMessageDao();
        messageDao.save(new Message(new Date(), "hello", 10));
        Message message = messageDao.load();
        System.out.println(message);
    }

    @Override
    public void save(Message message) throws IOException {
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("message2"));) {
            dataOutputStream.writeLong(message.getDate().getTime());
            dataOutputStream.writeInt(message.getAmount());
            dataOutputStream.writeInt(message.getMessage().length());
            dataOutputStream.write(message.getMessage().getBytes());
        }
    }

    @Override
    public Message load() throws FileNotFoundException, IOException, ClassNotFoundException {
        long time;
        int amount;
        int messageLength;
        byte[] messageContent;
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream("message2"));) {
            time = dataInputStream.readLong();
            amount = dataInputStream.readInt();
            messageLength = dataInputStream.readInt();
            messageContent = new byte[messageLength];
            dataInputStream.readNBytes(messageContent, 0, messageLength);
        }

        return new Message(new Date(time), new String(messageContent), amount);
    }


}
