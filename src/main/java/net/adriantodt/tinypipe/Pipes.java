package net.adriantodt.tinypipe;

import net.adriantodt.tinypipe.impl.UnixPipe;
import net.adriantodt.tinypipe.impl.WindowsPipe;

import java.io.IOException;

public class Pipes {
    private static final String OS_NAME = System.getProperty("os.name").toLowerCase();
    private static final String[] UNIX_PATHS = {"XDG_RUNTIME_DIR", "TMPDIR", "TMP", "TEMP"};
    private static final String UNIX_TMP_PATH;

    public static Pipe of(String location) {
        try {
            if (OS_NAME.contains("win")) {
                return new WindowsPipe("\\\\?\\pipe\\" + location);
            } else if (OS_NAME.contains("linux") || OS_NAME.contains("mac")) {
                return new UnixPipe(UNIX_TMP_PATH + location);
            } else {
                throw new RuntimeException("Unsupported OS: " + OS_NAME);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static {
        if (OS_NAME.contains("win")) {
            UNIX_TMP_PATH = "";
        } else {
            String tmpPath = null;
            for (String envKey : UNIX_PATHS) {
                tmpPath = System.getenv(envKey);
                if (tmpPath != null) {
                    break;
                }
            }
            if (tmpPath == null) {
                tmpPath = "/tmp";
            }

            UNIX_TMP_PATH = tmpPath + '/';
        }
    }
}
