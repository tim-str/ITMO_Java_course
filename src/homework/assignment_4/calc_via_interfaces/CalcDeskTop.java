package homework.assignment_4.calc_via_interfaces;

public class CalcDeskTop {

    // instance fields
    private int operand1;
    private int operand2;
    private double result;
    private GenericOperation Operation;

    // a constructor
    protected CalcDeskTop(GenericOperation anOperation, int operand1, int operand2) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.Operation = anOperation;
        this.result = this.Operation.execute(this.operand1, this.operand2);
        System.out.println(this.Operation.getType());
    }

    // a set of methods that might be applied over the class instance (i.e. an Object)
    protected int getOperand1() {
        return this.operand1;
    }
    protected int getOperand2() {
        return this.operand2;
    }
    protected double getResult() {
        return this.result;
    }

    public static void main(String[] args) {

        CalcDeskTop aDeskTop_1 = new CalcDeskTop(new Addition(), 13, 5);
        System.out.println("Having entered these two operands " + aDeskTop_1.getOperand1() + " || " + aDeskTop_1.getOperand2() +
                ", the following is the result: " + aDeskTop_1.getResult());
        CalcDeskTop aDeskTop_2 = new CalcDeskTop(new Subtraction(), 130, 5);
        System.out.println("Having entered these two operands " + aDeskTop_2.getOperand1() + " || " + aDeskTop_2.getOperand2() +
                ", the following is the result: " + aDeskTop_2.getResult());
        CalcDeskTop aDeskTop_3 = new CalcDeskTop(new Division(), 13, 5);
        System.out.println("Having entered these two operands " + aDeskTop_3.getOperand1() + " || " + aDeskTop_3.getOperand2() +
                ", the following is the result: " + aDeskTop_3.getResult());
        CalcDeskTop aDeskTop_4 = new CalcDeskTop(new Multiplication(), 13, 5);
        System.out.println("Having entered these two operands " + aDeskTop_4.getOperand1() + " || " + aDeskTop_4.getOperand2() +
                ", the following is the result: " + aDeskTop_4.getResult());
        CalcDeskTop aDeskTop_5 = new CalcDeskTop(new Division(), 13, 0);
        System.out.println("Having entered these two operands " + aDeskTop_5.getOperand1() + " || " + aDeskTop_5.getOperand2() +
                ", the following is the result: " + aDeskTop_5.getResult());
    }
}
