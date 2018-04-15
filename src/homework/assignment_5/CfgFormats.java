package homework.assignment_5;

class CfgFormatXML extends CheckingAccess implements AccessingCfgFiles {

    private String path;
    private boolean supress;

    // @Override
    public void readInFile() {
        if (!supress)
        System.out.println("Here we are reading configuration from XML file in");
    }

    public void writeOutFile() {
        if (!supress)
        System.out.println("Here we are writing configuration from XML file out");
    }

    CfgFormatXML(String path) {
        this.path = path;
        CheckingAccess code = new CheckingAccess(this.path);
        if (code.accessCheck()) {
            System.out.println("The path validated successfully");
            supress = false;
        }
            else {
            System.out.println("The path failed to be validated");
            supress = true;
        }

    }
}

    class CfgFormatTXT implements AccessingCfgFiles {

        private String path;
        private boolean supress;

        @Override
        public void readInFile() {
            System.out.println("Here we are reading configuration from TXT file in");
        }

        public void writeOutFile() {
            System.out.println("Here we are writing configuration from TXT file out");
        }

        CfgFormatTXT(String path) {
            this.path = path;
            CheckingAccess code = new CheckingAccess(this.path);
            if (code.accessCheck()) {
                System.out.println("The path validated successfully");
                supress = false;
            }
            else {
                System.out.println("The path failed to be validated");
                supress = true;
            }
        }
    }

    class CfgFormatJSON implements AccessingCfgFiles {

        private String path;
        private boolean supress;

        @Override
        public void readInFile() {
            System.out.println("Here we are reading configuration from JSON file in");
        }

        public void writeOutFile() {
            System.out.println("Here we are writing configuration from JSON file out");
        }

        CfgFormatJSON(String path) {
            this.path = path;
            CheckingAccess code = new CheckingAccess(this.path);
            if (code.accessCheck()) {
                System.out.println("The path validated successfully");
                supress = false;
            }
            else {
                System.out.println("The path failed to be validated");
                supress = true;
            }
        }
    }