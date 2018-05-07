package homework.assignment_8_new;

import java.io.*;

public class XORencryption {

    public void encryptFile(File file, String aKey) throws IOException {
        byte[] key = aKey.getBytes();

        try(
                // Opening a stream for reading byte-level data from the source file with buffered access
                InputStream in1 = new BufferedInputStream(new FileInputStream(file));
                ByteArrayOutputStream bout1 = new ByteArrayOutputStream();
                OutputStream out = new BufferedOutputStream(
                        new FileOutputStream(new File(file.getPath().
                                                                    concat("Encrypted - ").
                                                                    concat(file.getName())), false));
        ) {
            System.out.println("The file name is: " + file.getPath());
            byte[] buf = new byte[1024];
            int length; long byte1, bytes; byte1=bytes = 0;
            try {
                while ((length = in1.read(buf)) > 0) {
                    bout1.write(buf, 0, length);
                    byte1 += length;
//                    System.out.println("The original length is: " + byte1);
//                    System.out.println(Arrays.toString(bout1.toByteArray()));
                }
            }
                catch (Exception e) {
                    System.out.println("Exception triggered...");
                }
                System.out.println("File read successfully...");
                System.out.println("The length of the output stream was: " + bout1.toByteArray().length);

                byte[] xor_encrypted = new byte[bout1.toByteArray().length];
                for (int i = 0; i < bout1.toByteArray().length; i++) {
                    // System.out.println("The " + i + " byte read: " + bout1.toByteArray()[i]);
                    xor_encrypted[i] = (byte) (bout1.toByteArray()[i] ^ key[i % key.length]);
                    // System.out.println("Encrypted " + i + "  byte hashed: " + xor_encrypted[i]);
                }

                bout1.reset();
                bout1.write(xor_encrypted,0,xor_encrypted.length);

                //System.out.println("The length of the encrypted file is: " + xor_encrypted.length);

                bout1.writeTo(out);
        }
    }
}

//        public static byte[] encode(String pText, String pKey) {
//            byte[] txt = pText.getBytes();
//            byte[] key = pKey.getBytes();
//            byte[] res = new byte[pText.length()];
//
//            for (int i = 0; i < txt.length; i++) {
//                res[i] = (byte) (txt[i] ^ key[i % key.length]);
//            }
//
//            return res;
//        }