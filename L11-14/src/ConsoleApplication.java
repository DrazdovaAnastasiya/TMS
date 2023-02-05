

import java.util.List;

public class ConsoleApplication implements Application {

    private OperationStorage operationStorage = new FileOperationStorage();
    private Calculator calculator = new Calculator();
    private Writer writer = new ConsoleWriter();
    private Reader reader = new ConsoleReader();

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

                Operation operation = new Operation(num1, num2, operationType);
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
