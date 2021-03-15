package net.adriantodt.tinypipe.impl;

import net.adriantodt.tinypipe.Pipe;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;

public class WindowsPipe implements Pipe {
    private final RandomAccessFile file;
    private final InputStream inputStream;
    private final OutputStream outputStream;

    public WindowsPipe(String location) throws IOException {
        this.file = new RandomAccessFile(location, "rw");
        this.inputStream = new RandomAccessFileInputStream(file);
        this.outputStream = new RandomAccessFileOutputStream(file);
    }

    @Override
    public InputStream inputStream() {
        return inputStream;
    }

    @Override
    public OutputStream outputStream() {
        return outputStream;
    }

    @Override
    public void close() throws IOException {
        file.close();
    }
}
