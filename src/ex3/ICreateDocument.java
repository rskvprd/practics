package ex3;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface ICreateDocument {
    IDocument createNew();
    IDocument createOpen() throws IOException;
}
