package src;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;


public class openFile {
    public openFile(Path fileName) throws IOException {
        File file = new File(String.valueOf(fileName));
        if (file.exists()) {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(file);
            }
        }
    }
}
