package by.tms.service;

import by.tms.entity.Operation;
import by.tms.entity.OperationType;

public class DivOperation implements CalculatorOperation {
    private final Operation operation;

    public DivOperation(Operation operation) {
        this.operation = operation;
    }

    @Override
    public void process() {
        operation.setResult(operation.getNum1() / operation.getNum2());
        operation.setType(OperationType.DIV);

    }

    @Override
    public Operation getFinalResult() {
        return operation;
    }
}
