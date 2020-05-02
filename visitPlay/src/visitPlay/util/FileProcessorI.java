package visitPlay.util;

import java.io.IOException;

public interface FileProcessorI {
    String poll() throws IOException;
    void close() throws IOException;
}
