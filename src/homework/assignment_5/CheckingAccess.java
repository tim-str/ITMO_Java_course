package homework.assignment_5;

import java.io.File;

public class CheckingAccess {
    private String path;

    CheckingAccess(HandlingCfg file) {
        this.path = file.getPath();
    }

    CheckingAccess() {

    }

    int accessCheck() {
        try {
            File cfg = new File(this.path);
            return 0;
        } catch (Exception e) {
            return 11;
        }
    }
}
