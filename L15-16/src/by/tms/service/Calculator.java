package by.tms.service;

import by.tms.entity.Operation;
import by.tms.console.response.OperationType;
import by.tms.storage.FileOperationStorage;
import by.tms.storage.OperationStorage;

public class Calculator {
    private OperationStorage storage = new FileOperationStorage();
    private FunctionalCalculator calculatorF;
    public Operation calculate (Operation operation) throws Exception {
        switch (OperationType.valueOf(operation.getType())) {
            case SUM:
                calculatorF = (num1, num2) -> num1 + num2;
                operation.setResult(calculatorF.calculateF(operation.getNum1(), operation.getNum2()));
            case SUB:
                calculatorF = (num1, num2) -> num1 - num2;
                operation.setResult(calculatorF.calculateF(operation.getNum1(), operation.getNum2()));
            case MUL:
                calculatorF = (num1, num2) -> num1 * num2;
                operation.setResult(calculatorF.calculateF(operation.getNum1(), operation.getNum2()));
            case DIV:
                calculatorF = (num1, num2) -> num1 / num2;
                operation.setResult(calculatorF.calculateF(operation.getNum1(), operation.getNum2()));
        }

        storage.save(operation);

        return operation;
    }
}
