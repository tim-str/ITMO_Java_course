package homework.assignment_5;

public class HandlingCfg {

    private String path;
    private AccessingCfgFiles method;

    HandlingCfg (AccessingCfgFiles method, String path) {
        this.path = path;
        this.method = method;
        System.out.println("What's been just done is...");
        // System.out.println(method.readInFile());
    }

    String getPath() {
        return this.path;
    }

    public static void main(String[] args) {

        HandlingCfg file1 = new HandlingCfg(new CfgFormatJSON(), "src/java.txt");


//            if (new CheckingAccess(file1).accessCheck() == 0 ) {
//            System.out.println("The path validated");
        }

    }

