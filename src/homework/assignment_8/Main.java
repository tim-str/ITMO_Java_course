package homework.assignment_8;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        File source;
        String path;

        CopyingFileUI aTask = new CopyingFileUI();

        source = aTask.defineFile();
        path = aTask.defineDestinationPath();

        // CopyingFileIoStreams(File file, String destination, int buffer)
        CopyingFileIoStreams CopyCmd = new CopyingFileIoStreams(source,path,4096);

    }
}
