package homework.assignment_5;

public class HandlingCfg {

    private String path;
    private AccessingCfgFiles method;

    HandlingCfg (AccessingCfgFiles method, String path) {
        this.path = path;
        this.method = method;
        System.out.println("What's been just done is...");

        if (new CheckingAccess(path).accessCheck() == 0 ) System.out.println("The path validated");
            else System.out.println("The path/filename is invalid");
    }

    public static void main(String[] args) {

        HandlingCfg file1 = new HandlingCfg(new CfgFormatJSON(), "src/java.txt");

    }
}

