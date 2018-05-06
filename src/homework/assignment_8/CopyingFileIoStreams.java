package homework.assignment_8;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class CopyingFileIoStreams {
    private File file;
    private String destination;
    private int buffer = 1024;
    private long bytes = 0;
    private boolean copyingSuccess;

    void setCopyingSuccess(boolean status) {
        this.copyingSuccess = status;
    }

    boolean getCopyingSuccess() {
        return this.copyingSuccess;
    }

    public CopyingFileIoStreams(File file, String destination, int buffer) throws IOException {
        this.file = file;
        this.destination = destination;
        this.buffer = buffer;

        this.streamingBytes();
    }

    private void streamingBytes() throws IOException {
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
                this.bytes = bytes;
                setCopyingSuccess(true);
            }
            catch (Exception e) {
                System.out.println("Exception triggered...");
                setCopyingSuccess(false);
            }
        }
    }

    protected int[] defineHowToSplit() {
        String split;
        String[] sizes;
        int[] size = {0,0};

        System.out.println("Please define in bytes how to split the copied file: file1/file2");
        while (true) {
        Scanner scanner = new Scanner(System.in);
        split = scanner.nextLine();
            if (!split.isEmpty()) {
                sizes = split.split("/");
                size[0] = Integer.parseInt(sizes[0]);
                size[1] = Integer.parseInt(sizes[1]);
                    if(size[0]+size[1] == (int)this.bytes) {
                        System.out.println(Arrays.toString(sizes));
                        return size;
                }
                System.out.println("The sizes for the split are invalid");
            }
        }
    }

    protected String[] SplittingFile(int[] size) throws IOException {

        String[] coreNameSplit = this.file.getName().split("[.]");
        System.out.println("coreNameSplit[0]: " + this.destination + "||" + coreNameSplit[0]);
        String[] fileNames = new String[3];
        fileNames[0] = this.destination.concat(coreNameSplit[0].concat("_1.").concat(coreNameSplit[1]));
        fileNames[1] = this.destination.concat(coreNameSplit[0].concat("_2.").concat(coreNameSplit[1]));
        fileNames[2] = this.destination.concat("NEW - ").concat(file.getName());

        try(
                    // Opening a stream for reading byte-level data from the source file with buffered access
                    InputStream in = new BufferedInputStream(new FileInputStream(this.file));
                    // Capturing read data into a stream to output via an array of bytes
                    ByteArrayOutputStream bout1 = new ByteArrayOutputStream();
                    ByteArrayOutputStream bout2 = new ByteArrayOutputStream();
                    // Opening an output stream to write byte-level data into a target copy of the file
                    OutputStream out1 = new BufferedOutputStream(
                            new FileOutputStream(
                                    new File(this.destination.
                                                    concat(coreNameSplit[0].
                                                    concat("_1.").
                                                    concat(coreNameSplit[1]))), false));
                    OutputStream out2 = new BufferedOutputStream(
                            new FileOutputStream(
                                    new File(this.destination.
                                                            concat(coreNameSplit[0].
                                                            concat("_2.").
                                                            concat(coreNameSplit[1]))), false));
                    // No need to create another buffer of data - just streaming what was read straight away
            ) {

                byte[] buf = new byte[this.buffer];
                int length; long byte1, byte2, bytes; byte1=byte2=bytes = 0;

                try {
                    while ((length = in.read(buf)) > 0) {
                        if (bytes <= size[0]) {
                            bout1.write(buf, 0, length);
                            byte1 += length;
                        } else {
                            bout2.write(buf, 0, length);
                            byte2 += length;
                        }
                        bytes += length;
                    }
                }
                catch (Exception e) {
                    System.out.println("Exception triggered...");
//
                }
                    bout1.writeTo(out1);
                    bout2.writeTo(out2);
                    // buffers = bout.toByteArray().length;

                    System.out.println("Total bytes transferred: " + bytes);
                    System.out.println("File1 bytes transferred: " + byte1);
                    System.out.println("File2 bytes transferred: " + byte2);
                    System.out.println("Splitting succeeded - the files created are: ");
                    System.out.println(fileNames[0]);
                    System.out.println(fileNames[1]);

                    return fileNames;
            }
        }
}