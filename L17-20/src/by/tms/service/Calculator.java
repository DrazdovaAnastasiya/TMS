package by.tms.service;

import by.tms.console.util.ConsoleReader;
import by.tms.console.util.ConsoleWriter;
import by.tms.entity.Operation;
import by.tms.console.response.OperationType;
import by.tms.storage.FileOperationStorage;
import by.tms.storage.JdbcOperationStorage;
import by.tms.storage.JsonOperationStorage;
import by.tms.storage.OperationStorage;
import by.tms.util.Reader;
import by.tms.util.Writer;

public class Calculator {

    private Writer writer = new ConsoleWriter();
    private Reader reader = new ConsoleReader();
    private OperationStorage fileOperationStorage = new FileOperationStorage();
    private OperationStorage jdbcOperationStorage = new JdbcOperationStorage();
    private OperationStorage jsonOperationStorage = new JsonOperationStorage();
    private FunctionalCalculator calculatorF;

//    public Calculator(OperationStorage storage) {
//        this.storage = storage;
//    }

    public Operation calculate(Operation operation) throws Exception {
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
            writer.write("Select the storage location of the operation:\n1 — File;\n2 — JDBC;\n3 — JSON.");
            int location = reader.readIntNumber();
            switch (location) {
                case 1:
                    fileOperationStorage.save(operation);
                    break;
                case 2:
                    jdbcOperationStorage.save(operation);
                    break;
                case 3:
                    jsonOperationStorage.save(operation);
                    break;
            }

        return operation;
    }
}
