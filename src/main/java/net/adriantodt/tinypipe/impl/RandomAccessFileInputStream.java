package net.adriantodt.tinypipe.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

public class RandomAccessFileInputStream extends InputStream {
    private final RandomAccessFile file;

    public RandomAccessFileInputStream(RandomAccessFile file) {
        this.file = file;
    }

    @Override
    public int read() throws IOException {
        return file.read();
    }

    @Override
    public int read(byte[] b) throws IOException {
        return file.read(b);
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        return file.read(b, off, len);
    }

    @Override
    public void close() throws IOException {
        super.close();
        file.close();
    }
}
