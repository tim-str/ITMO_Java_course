package homework.assignment_4.calc_via_interfaces;

class Addition implements GenericOperation {

    private String type;

    public Addition() {
        this.type = "Addition";
    }

    @Override
    public double execute(int a, int b) {
        return a + b;
    }
    public String getType() {
        return this.type;
    }
}

class Subtraction implements GenericOperation {

    private String type;

    public Subtraction() {
        this.type = "Subtraction";
    }

    @Override
    public double execute(int a, int b) {
        return a - b;
    }
    public String getType() {
        return this.type;
    }
}

class Multiplication implements GenericOperation {

    private String type;

    public Multiplication() {
        this.type = "Multiplication";
    }

    @Override
    public double execute(int a, int b) {
        return a * b;
    }
    public String getType() {
        return this.type;
    }
}

class Division implements GenericOperation {

    private String type;

    public Division() {
        this.type = "Division";
    }
    @Override
    public double execute(int a, int b) {

        double result;
        if (b != 0) {
            result = a / (double) b;
        } else { result = -99999.0;
            System.out.println("The denominator equals to 0! Please provide new values to perform the operation");
        }

        return result;

    }
    public String getType() {
        return this.type;
    }
}