package by.tms.console;

import by.tms.Application;
import by.tms.console.util.ConsoleReader;
import by.tms.console.util.ConsoleWriter;
import by.tms.entity.Operation;
import by.tms.console.response.OperationType;
import by.tms.service.Calculator;
import by.tms.storage.FileOperationStorage;
import by.tms.storage.OperationStorage;
import by.tms.util.Reader;
import by.tms.util.Writer;



import java.time.LocalDateTime;
import java.util.List;


public class ConsoleApplication implements Application {

    private OperationStorage operationStorage = new FileOperationStorage();
    private Writer writer = new ConsoleWriter();
    private Reader reader = new ConsoleReader();
    private OperationStorage storage = new FileOperationStorage();
    private Calculator calculator = new Calculator();


    public void go() {
        while (true) {
            Operation result = null;
            try {
                writer.write("Enter number 1");
                double num1 = reader.readDoubleNumber();
                writer.write("Enter number 2");
                double num2 = reader.readDoubleNumber();
                writer.write("Enter operation type (SUM/SUB/MUL/DIV)");
                OperationType operationType = reader.readOperationType();
                LocalDateTime localDateTime = LocalDateTime.now();

                Operation operation = new Operation(num1, num2, operationType.toString(), localDateTime);

                result = calculator.calculate(operation);

            } catch (Exception e) {
                writer.write(String.valueOf(e));
            }
            if (result == null) {
                continue;
            }

            writer.write("Result: " + result.getResult());

            writer.write("Choose a further action:\n1 — show the history of operations;\n2 — continue calculation;\n3 — exit.");
            try {
                int history = reader.readIntNumber();
                switch (history) {
                    case 1:
                        operationHistory(operationStorage.findAll());
                        writer.write("Choose a further action:\n1 — continue calculation;\n2 — exit.");
                        int cont = reader.readIntNumber();
                        if (cont == 1) {
                            continue;
                        } else {
                            writer.write("Bye!");
                            return;
                        }
                    case 2:
                        break;
                    case 3:
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
