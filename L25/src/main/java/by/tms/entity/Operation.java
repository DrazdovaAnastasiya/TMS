package by.tms.entity;

public class Operation {
    private final double num1;
    private final double num2;
    private double result;
    private final String operationType;



    public Operation(double num1, double num2, String operationType) {
        this.num1 = num1;
        this.num2 = num2;
        this.operationType = operationType;

    }

    public Operation(double num1, double num2, String operationType, double result) {
        this(num1, num2, operationType);
        this.result = result;
    }

    public double getNum1() {
        return num1;
    }

    public double getNum2() {
        return num2;
    }

    public String getType() {
        return operationType;
    }

    public double getResult() {
        return result;
    }

    public Operation setResult(double result) {
        this.result = result;
        return this;
    }
}
