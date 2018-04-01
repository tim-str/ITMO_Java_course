package new_calc;

import calculator.calculator.Oper;

public class Subtraction extends OperationWrapper {

    String type;

    protected Subtraction(){
        this.type = "Subtraction";
    }

    protected String getType() {
        return this.type;
    }

    @Override
    protected double execute(int a, int b) {
        return a - b;
    }

}