package homework.assignment_5;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

public class CheckingAccess {
    private String path;

    CheckingAccess(String path) {
        this.path = path;
    }

    CheckingAccess() {
    }

    int accessCheck() {
        try {
            File cfg = new File(this.path);
            List<String> lines = Files.readAllLines(cfg.toPath());
            return 0;
        } catch (Exception e) {
            return 11;
        }
    }
}
