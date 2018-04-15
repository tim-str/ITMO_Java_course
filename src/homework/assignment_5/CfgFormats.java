package homework.assignment_5;

class CfgFormatXML extends CheckingAccess implements AccessingCfgFiles {

    @Override
    public void readInFile() {
        System.out.println("Here we are reading configuration from XML file in");
    }

    public void writeOutFile() {
        System.out.println("Here we are writing configuration from XML file out");
    }
}

class CfgFormatTXT implements AccessingCfgFiles {

    @Override
    public void readInFile() {
        System.out.println("Here we are reading configuration from TXT file in");
    }

    public void writeOutFile() {
        System.out.println("Here we are writing configuration from TXT file out");
    }
}

class CfgFormatJSON implements AccessingCfgFiles {

    @Override
    public void readInFile() {
        System.out.println("Here we are reading configuration from JSON file in");
    }

    public void writeOutFile() {
        System.out.println("Here we are writing configuration from JSON file out");
    }
}