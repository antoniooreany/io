package com.gorshkov.io.message;

import java.io.*;
import java.util.Date;

public class DataMessageDao implements MessageDao {

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
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream("message2"));) {
            long time = dataInputStream.readLong();
            int amount = dataInputStream.readInt();
            int messageLength = dataInputStream.readInt();
            byte[] messageContent = new byte[messageLength];
            dataInputStream.readNBytes(messageContent, 0, messageLength);
            return new Message(new Date(time), new String(messageContent), amount);
        }
    }
}
