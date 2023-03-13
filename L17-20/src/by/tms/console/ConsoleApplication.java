package by.tms.console;

import by.tms.Application;
import by.tms.console.util.ConsoleReader;
import by.tms.console.util.ConsoleWriter;
import by.tms.entity.Operation;
import by.tms.console.response.OperationType;
import by.tms.service.Calculator;
import by.tms.storage.FileOperationStorage;
import by.tms.storage.JdbcOperationStorage;
import by.tms.storage.JsonOperationStorage;
import by.tms.storage.OperationStorage;
import by.tms.util.Reader;
import by.tms.util.Writer;
import by.tms.validator.OperationValidator;


import java.time.LocalDateTime;
import java.util.List;


public class ConsoleApplication implements Application {

    private OperationStorage fileOperationStorage = new FileOperationStorage();
    private OperationStorage jdbcOperationStorage = new JdbcOperationStorage();
    private OperationStorage jsonOperationStorage = new JsonOperationStorage();
    private Writer writer = new ConsoleWriter();
    private Reader reader = new ConsoleReader();
    private Calculator calculator = new Calculator();
    private OperationValidator validator = new OperationValidator();


    public void go() {
        while (true) {
            Operation result = null;
            String operationType = "";
            try {
                writer.write("Enter number 1");
                double num1 = reader.readDoubleNumber();
                writer.write("Enter number 2");
                double num2 = reader.readDoubleNumber();
                boolean isCorrect = false;
                while (!isCorrect) {
                    writer.write("Enter operation type (SUM/SUB/MUL/DIV)");
                    operationType = reader.readString();
                    isCorrect = validator.validateOperationType(operationType);
                }

                Operation operation = new Operation(num1, num2, operationType);

                result = calculator.calculate(operation);

            } catch (Exception e) {
                writer.write(String.valueOf(e));
                e.printStackTrace();
            }
            if (result == null) {
                continue;
            }

            writer.write("Result: " + result.getResult());

            writer.write("Choose a further action:\n1 — show the history of operations (File);" +
                    "\n2 — show the history of operations (JDBC);" +
                    "\n3 — show the history of operations (JSON);" +
                    "\n4 — continue calculation;" +
                    "\n5 — exit.");

            try {
                int history = reader.readIntNumber();
                switch (history) {
                    case 1:
                        operationHistory(fileOperationStorage.findAll());
                        writer.write("Choose a further action:\n1 — continue calculation;\n2 — exit.");
                        int cont1 = reader.readIntNumber();
                        if (cont1 == 1) {
                            continue;
                        } else {
                            writer.write("Bye!");
                            return;
                        }
                    case 2:
                        operationHistory(jdbcOperationStorage.findAll());
                        writer.write("Choose a further action:\n1 — continue calculation;\n2 — exit.");
                        int cont2 = reader.readIntNumber();
                        if (cont2 == 1) {
                            continue;
                        } else {
                            writer.write("Bye!");
                            return;
                        }
                    case 3:
                        operationHistory(jsonOperationStorage.findAll());
                        writer.write("Choose a further action:\n1 — continue calculation;\n2 — exit.");
                        int cont3 = reader.readIntNumber();
                        if (cont3 == 1) {
                            continue;
                        } else {
                            writer.write("Bye!");
                            return;
                        }
                    case 4:
                        break;
                    case 5:
                        writer.write("Bye!");
                        return;
                }
            } catch (Exception e) {
                writer.write(String.valueOf(e));
            }
        }
    }

    private void operationHistory(List<Operation> operations) {
            for (Operation operation : operations) {
            writer.write(operation.toString());
        }
    }


}
