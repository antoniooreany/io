package com.gorshkov.io.message;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataMessageDao implements MessageDao{
    @Override
    public void save(Message message) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("message2"));
        dataOutputStream.writeLong(message.getDate().getTime());
        dataOutputStream.writeInt(message.getAmount());
        dataOutputStream.writeInt(message.getMessage().length());
        dataOutputStream.write(message.getMessage().getBytes());
    }

    @Override
    public Message load() throws FileNotFoundException, IOException, ClassNotFoundException {
        return null;
    }
}
