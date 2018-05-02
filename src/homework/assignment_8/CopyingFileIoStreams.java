package homework.assignment_8;

import java.io.*;
import java.util.Arrays;

public class CopyingFileIoStreams {
    File file;
    String destination;
    int buffer = 1024;

    public CopyingFileIoStreams(File file, String destination, int buffer) throws IOException {
        this.file = file;
        this.destination = destination;
        this.buffer = buffer;

        this.streamingBytes();
    }

    private boolean streamingBytes() throws IOException {
        try(
                // Opening a stream for reading byte-level data from the source file with buffered access
                InputStream in = new BufferedInputStream(new FileInputStream(this.file));
                // Capturing read data into a stream to output via an array of bytes
                ByteArrayOutputStream bout = new ByteArrayOutputStream();
                // Opening an output stream to write byte-level data into a target copy of the file
                OutputStream out = new BufferedOutputStream(
                        new FileOutputStream(new File(this.destination.concat(this.file.getName())), false));
                // No need to create another buffer of data - just streaming what was read straight away
            ) {

            byte[] buf = new byte[this.buffer];
            int length; long bytes, buffers; bytes= buffers= 0;
            try {
                while ((length = in.read(buf)) > 0) {
                    // System.out.println(Arrays.toString(buf));
                    bout.write(buf, 0, length);
                    bytes += length;
                }
                bout.writeTo(out);
                buffers = bout.toByteArray().length;

                System.out.println("Bytes transferred: " + bytes);
                System.out.println("The Buffer been in use: " + buffers);
                return true;
            }
            catch (Exception e) {
                System.out.println("Exception triggered...");
                return false;
            }
        }
    }
}
