package new_calc;

public class Addition extends OperationWrapper {

    String type;

    protected Addition(){
        this.type = "Addition";
    }

    protected String getType() {
        return this.type;
    }

    @Override
    protected double execute(int a, int b) {
        return a + b;
    }

}
