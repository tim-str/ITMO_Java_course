package calculator.calculator;

public class Oper {

    int a, b;
    String operator;

    public Oper(int a, int b, String operator) {
        this.a = a;
        this.b = b;
        this.operator = operator;
    }

    protected void execute() {
        System.out.println(" execute ");
    }
}
