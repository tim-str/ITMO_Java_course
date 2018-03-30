package calculator.calculator;

public class ResultAccumulation {

    int value;
    Operation operation;

    public ResultAccumulation(Operation anOperation, int value) {
        this.value = value;
        this.operation = anOperation;
    }

    protected void accum(int someInt) {
        this.value = this.operation.execute(this.value, someInt);
    }

    public int getValue() {
        return this.value;
    }

    public static void main(String[] args) {

        ResultAccumulation acc = new ResultAccumulation(new Plus(), 3);

        System.out.println(acc.getValue());
        acc.accum(5);
        System.out.println(acc.getValue());

    }




}
