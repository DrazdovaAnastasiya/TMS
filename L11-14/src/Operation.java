public class Operation {
    private final double num1;
    private final double num2;
    private double result;
    private final OperationType operationType;

    public Operation(double num1, double num2, OperationType operationType) {
        this.num1 = num1;
        this.num2 = num2;
        this.operationType = operationType;
    }

    public Operation(double num1, double num2, OperationType operationType, double result) {
        this(num1, num2, operationType);
        this.result = result;
    }

    public double getNum1() {
        return num1;
    }

    public double getNum2() {
        return num2;
    }

    public OperationType getType() {
        return operationType;
    }

    public double getResult() {
        return result;
    }

    public Operation setResult(double result) {
        this.result = result;
        return this;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "num1=" + num1 +
                ", num2=" + num2 +
                ", result=" + result +
                ", type='" + operationType + '\'' +
                '}';
    }
}
