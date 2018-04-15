package homework.assignment_4.new_calc;

abstract class OperationWrapper {

    String type;

    protected double execute(int a, int b) {
        return 0;
    }

    protected String getType() {
        return this.type;
    }
}
