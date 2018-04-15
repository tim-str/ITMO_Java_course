package homework.assignment_5;

public class HandlingCfg {

    private AccessingCfgFiles method;

    HandlingCfg (AccessingCfgFiles method) {
        this.method = method;
    }

    public static void main(String[] args) {

        HandlingCfg file1 = new HandlingCfg(new CfgFormatXML("src/java.txt"));
        System.out.println("What's been just done is...");
        file1.method.readInFile();
        file1.method.writeOutFile();
        System.out.println();

        HandlingCfg file2 = new HandlingCfg(new CfgFormatXML("src/java2.txt"));
        System.out.println("One more example with non-existing file: What's been just done is...");
        file2.method.readInFile();
        file2.method.writeOutFile();
        System.out.println();

        HandlingCfg file3 = new HandlingCfg(new CfgFormatTXT("src/java.txt"));
        System.out.println("What's been just done is...");
        file3.method.readInFile();
        file3.method.writeOutFile();
        System.out.println();

        HandlingCfg file4 = new HandlingCfg(new CfgFormatJSON("src/java.txt"));
        System.out.println("What's been just done is...");
        file4.method.readInFile();
        file4.method.writeOutFile();
    }
}

