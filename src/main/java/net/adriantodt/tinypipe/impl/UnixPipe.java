package net.adriantodt.tinypipe.impl;

import net.adriantodt.tinypipe.Pipe;
import org.newsclub.net.unix.AFUNIXSocket;
import org.newsclub.net.unix.AFUNIXSocketAddress;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class UnixPipe implements Pipe {
    private final AFUNIXSocket socket;
    private final InputStream inputStream;
    private final OutputStream outputStream;

    public UnixPipe(String location) throws IOException {
        socket = AFUNIXSocket.newInstance();
        socket.connect(new AFUNIXSocketAddress(new File(location)));
        this.inputStream = socket.getInputStream();
        this.outputStream = socket.getOutputStream();
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
        socket.close();
    }
}
