package homework.assignment_4.new_calc;

public class Division extends OperationWrapper {

    String type;

    protected Division() {
        this.type = "Division";
    }

    protected String getType() {
        return this.type;
    }

    @Override
    protected double execute(int a, int b) {

        double result;
        if (b != 0) {
            result = a / (double) b;
        } else { result = -99999.0;
            System.out.println("The denominator equals to 0! Please provide new values to perform the operation");
        }

        return result;

    }
}
