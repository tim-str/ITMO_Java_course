package homework.assignment_8;

import java.io.*;

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
            int length;
            try {

                while ((length = in.read(buf)) > 0) {
                    bout.write(buf, 0, length);
                    out.write(bout.toByteArray());
                }
                return true;
            }
            catch (Exception e) {
                return false;
            }
        }
    }
}
