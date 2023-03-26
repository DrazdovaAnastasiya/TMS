package by.tms.service;

import by.tms.entity.Operation;
import by.tms.entity.OperationType;
import by.tms.storage.JdbcOperationStorage;
import by.tms.storage.OperationStorage;


public class CalculatorService {

    private OperationStorage jdbcOperationStorage = new JdbcOperationStorage();

    public Operation calculate(Operation operation) throws Exception {
        switch (OperationType.valueOf(operation.getType())) {
            case SUM:
                operation.setResult(operation.getNum1() + operation.getNum2());
                break;
            case SUB:
                operation.setResult(operation.getNum1() - operation.getNum2());
                break;
            case MUL:
                operation.setResult(operation.getNum1() * operation.getNum2());
                break;
            case DIV:
                operation.setResult(operation.getNum1() / operation.getNum2());
                break;
        }

        jdbcOperationStorage.save(operation);

        return operation;
    }
}
