package homework.assignment_8_new;

import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;

public abstract class XORbasic {

    public String pathMutator(File file, String embedding) {

        // handling with creating a name for the encrypted file
        String[] srcFilePathParts = file.getPath().split("\\\\");
//        System.out.println(Arrays.toString(srcFilePathParts));
        LinkedList<String> trgFilePathParts = new LinkedList<>();
        int srcIndex = srcFilePathParts.length;
        for(String e : srcFilePathParts) {
            trgFilePathParts.add(e);
        }
        trgFilePathParts.add(srcIndex - 1,embedding);

        for(int i = 1; i <= srcIndex - 1; i++) {
            trgFilePathParts.add(i*2 - 1,"\\");
        }
        StringBuilder trgPathString = new StringBuilder();
        for (String e:trgFilePathParts
                ) {trgPathString.append(e);
        }
//        System.out.println(trgPathString.toString());

        return trgPathString.toString();
    }
}
