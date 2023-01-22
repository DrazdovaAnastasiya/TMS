import java.util.Arrays;
import java.util.Objects;

public class ConsoleApplication implements Application {

    private OperationStorage operstor = new InMemoryOperationStorage(5);
    private Calculator calculator = new Calculator();
    private Writer writer = new ConsoleWriter();
    private Reader reader = new ConsoleReader();

    public void go() {
        while (true) {
            writer.write("Enter number 1");
            double num1 = reader.readNumber();
            writer.write("Enter number 2");
            double num2 = reader.readNumber();
            writer.write("Operation type (sum/sub/mul/div)");
            String type = reader.readOperationType();

            Operation operation = new Operation(num1, num2, type);

            Operation result = calculator.calculate(operation);
            operstor.save(operation);
            writer.write("Result: " + result.getResult());
            writer.write("Choose a further action:\n1 — show the history of operations;\n2 — continue calculation;\n3 — exit.");
            int history = reader.readIntNumber();
            switch (history) {
                case 1:
                    OperationHistory(operstor.findAll());
                    writer.write("Choose a further action:\n1 — continue calculation;\n2 — exit.");
                    int cont = reader.readIntNumber();
                    if (cont == 1) {
                        continue;
                    } else {
                        return;
                    }
                case 2:
                    break;
                case 3:
                    writer.write("Bye!");
                    return;
            }
        }
    }

    private void OperationHistory(Operation[] operations) {
        for(Operation operation:operations){
            if(operation!=null){
                writer.write("Num1: " + operation.getNum1() + ", num2: " + operation.getNum2() + ", result: " + operation.getResult() + ", type: " + operation.getType());
            }
        }

    }
}
