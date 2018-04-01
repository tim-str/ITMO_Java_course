package new_calc;

public class Multiplication extends OperationWrapper {

    String type;

    protected Multiplication(){
        this.type = "Multiplication";
    }

    protected String getType() {
        return this.type;
    }

    @Override
    protected double execute(int a, int b) {
        return a * b;
    }
}

