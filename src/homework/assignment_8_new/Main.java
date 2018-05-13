package homework.assignment_8_new;

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
        CopyingFileIoStreams CopyCmd = new CopyingFileIoStreams(source,path,2048);

        // Splitting the file designated earlier as the copy of source
        String[] fileNames;
        fileNames = CopyCmd.SplittingFile(CopyCmd.defineHowToSplit());

        // Reconstructing the parts back into whole
        GluingFiles restoredFile = new GluingFiles(fileNames,2048);
        File file = restoredFile.recreateFile();

        // XOR-encryption
        XORencryption encrypted = new XORencryption();
        File encryptedFile = encrypted.encryptFile(file,"password");

        // XOR-decryption
        XORdecryption decryptedFile = new XORdecryption();
        decryptedFile.decryptFile(encryptedFile,"password");
    }
}
