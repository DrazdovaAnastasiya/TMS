package by.tms.entity;

public class Operation implements Comparable<Operation>{
    private int operationId;
    private double num1;
    private double num2;
    private double result;
    private OperationType type;
    private int userId;


       public Operation(int operationId, double num1, double num2, OperationType type, double result) {
        this.operationId = operationId;
        this.num1 = num1;
        this.num2 = num2;
        this.type = type;
        this.result = result;

    }
    public Operation(int operationId, double num1, double num2, OperationType type, double result, int userId) {
        this.operationId = operationId;
        this.num1 = num1;
        this.num2 = num2;
        this.type = type;
        this.result = result;
        this.userId = userId;

    }
    public Operation(double num1, double num2, OperationType type, int userId) {

        this.num1 = num1;
        this.num2 = num2;
        this.type = type;
        this.userId = userId;

    }

     public double getNum1() {
        return num1;
    }

    public double getNum2() {
        return num2;
    }

    public double getResult() {
        return result;
    }

    public OperationType getType() {
        return type;
    }

    public int getUserId() {
        return userId;
    }


    public Operation setResult(double result) {
        this.result = result;
        return this;
    }


    public void setType(OperationType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "operationId=" + operationId +
                ", num1=" + num1 +
                ", num2=" + num2 +
                ", result=" + result +
                ", type=" + type +
                ", userId=" + userId +
                '}';
    }


    @Override
    public int compareTo(Operation o) {
        return 0;
    }
}