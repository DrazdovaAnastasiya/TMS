package by.tms.entity;

import java.time.LocalDateTime;

public class Operation {
    private final double num1;
    private final double num2;
    private double result;
    private final String operationType;
    private LocalDateTime createAt;


    public Operation(double num1, double num2, String operationType, LocalDateTime createAt) {
        this.num1 = num1;
        this.num2 = num2;
        this.operationType = operationType;
        this.createAt = createAt;
    }

    public Operation(double num1, double num2, String operationType, double result, String createAt) {
        this(num1, num2, operationType, LocalDateTime.parse(createAt));
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

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "num1=" + num1 +
                ", num2=" + num2 +
                ", result=" + result +
                ", type='" + operationType + '\'' +
                ", time: " + createAt +
                '}';
    }
}
