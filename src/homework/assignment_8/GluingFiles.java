package homework.assignment_8;

import java.io.*;

public class GluingFiles {
    private String[] fileNames;
    private int buffer;

    public GluingFiles(String[] fileNames, int buffer) {
    this.fileNames = fileNames;
    this.buffer = buffer;
    }

    public File recreateFile() throws IOException {

        File filePart1 = new File(this.fileNames[0]);
        File filePart2 = new File(this.fileNames[1]);
        File fileRestored = new File(this.fileNames[2]);

        try(
                // Opening a stream for reading byte-level data from the source file with buffered access
                InputStream in1 = new BufferedInputStream(new FileInputStream(filePart1));
                InputStream in2 = new BufferedInputStream(new FileInputStream(filePart2));
                // Capturing read data into a stream to output via an array of bytes
                ByteArrayOutputStream bout1 = new ByteArrayOutputStream();
                // Opening an output stream to write byte-level data into a target copy of the file
                OutputStream out1 = new BufferedOutputStream(
                        new FileOutputStream(fileRestored, false));
                OutputStream out2 = new BufferedOutputStream(
                        new FileOutputStream(fileRestored, true));
        ) {
            byte[] buf = new byte[this.buffer];
            int length; long byte1, byte2, bytes; byte1=byte2=bytes = 0;

            try {
                while ((length = in1.read(buf)) > 0) {
                        bout1.write(buf, 0, length);
                        byte1 += length;
                }
                bytes = byte1;
                bout1.writeTo(out1);
                bout1.reset();
                //System.out.println("byte1: " + byte1 + "||" + "bytes: " + bytes);
                while ((length = in2.read(buf)) > 0) {
                    bout1.write(buf, 0, length);
                    byte2 += length;
                    bytes += length;
                }
                bout1.writeTo(out2);
                System.out.println("Gluing file succeeded. The data transferred are (in bytes): ");
                System.out.println("File 1: " + byte1 + " || File 2: " + byte2 + " || The recreated file: " + bytes);
            }
            catch (Exception e) {
                System.out.println("Exception triggered...");
            }
            finally {
                return fileRestored;
            }

        }
    }
}
