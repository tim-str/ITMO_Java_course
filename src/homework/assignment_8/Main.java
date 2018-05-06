package homework.assignment_8;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        File source;
        String path;

        CopyingFileUI aTask = new CopyingFileUI();

        source = aTask.defineFile();
        path = aTask.defineDestinationPath();

        // CopyingFileIoStreams(File file, String destination, int buffer)
        CopyingFileIoStreams CopyCmd = new CopyingFileIoStreams(source,path,4096);

        // Splitting the file designated earlier as the copy of source
        String[] fileNames;
        fileNames = CopyCmd.SplittingFile(CopyCmd.defineHowToSplit());

        // Reconstructing the parts back into whole
        GluingFiles restoredFile = new GluingFiles(fileNames,4096);
        File file = restoredFile.recreateFile();

        // XOR-encryption
        XORencryption encryptedFile = new XORencryption();
        encryptedFile.encryptFile(file,"password");

    }
}
