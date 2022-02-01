package com.gorshkov.io.buffered;

import java.io.IOException;
import java.io.OutputStream;

public class BufferedOutputStream extends OutputStream {
    private static final int DEFAULT_SIZE = 20;
    private OutputStream target;
    private byte[] buffer;
    private int currentIndex;

    public BufferedOutputStream(OutputStream target) {
        this.target = target;
        this.buffer = new byte[DEFAULT_SIZE];
    }

    @Override
    public void write(int b) throws IOException {
        if (currentIndex >= buffer.length) {
            flush();
        }
        buffer[currentIndex] = (byte) b;
        currentIndex++;
    }

    @Override
    public void write(byte[] b) throws IOException {
        write(b, 0, b.length);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        if (len >= buffer.length) {
            flush();
            target.write(b, off, len);
            return;
        }
        if (len > buffer.length - currentIndex) {
            flush();
        }
        System.arraycopy(b, off, buffer, currentIndex, len);
        currentIndex += len;
    }

    @Override
    public void flush() throws IOException {
        if (currentIndex > 0) {
            target.write(buffer, 0, currentIndex);
            currentIndex = 0;
        }
        target.flush();
    }

    @Override
    public void close() throws IOException {
        flush();
        target.close();
    }
}
