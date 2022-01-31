package com.gorshkov.io.buffered;

import java.io.IOException;
import java.io.InputStream;

public class BufferedInputStream extends InputStream {
    private static final int DEFAULT_SIZE = 20;
    private InputStream target;
    private byte[] buffer;
    private int currentIndex;

    public BufferedInputStream(InputStream target) {
        this.target = target;
        buffer = new byte[DEFAULT_SIZE];
    }

    @Override
    public int read() throws IOException {
        if (buffer[currentIndex] >= 0) {
            currentIndex++;
            buffer[currentIndex] = (byte) target.read();
            return buffer[currentIndex];
        } else throw new IOException("currentIndex = -1");
    }

    @Override
    public int read(byte[] b) throws IOException {
        currentIndex += read(b, currentIndex, b.length);
        return b.length - currentIndex;
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        return super.read(b, off, len);
    }

    @Override
    public void close() throws IOException {
        super.close();
    }
}
