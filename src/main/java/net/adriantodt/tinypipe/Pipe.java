package net.adriantodt.tinypipe;

import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;

public interface Pipe extends Closeable {
    InputStream inputStream();

    OutputStream outputStream();
}
