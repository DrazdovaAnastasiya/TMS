import Exeptions.OperationNotFoundException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class FileOperationStorage implements OperationStorage{
    @Override
    public void save(Operation operation) throws IOException{
        String result = String.format("%s,%s,%s,%s", operation.getNum1(), operation.getNum2(), operation.getType(),
                operation.getResult());

        FileOutputStream fileOutputStream = new FileOutputStream("history.csv", true);
        fileOutputStream.write(result.getBytes());
        fileOutputStream.write(10);
        fileOutputStream.close();
    }

    @Override
    public List<Operation> findAll() throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("history.csv"));
        List<Operation> operations = new ArrayList<>();
        String str;

        while ((str = bufferedReader.readLine()) != null) {
            operations.add(convertToOperation(str));
        }
        return operations;
    }

    private Operation convertToOperation(String operation) throws OperationNotFoundException {
        String[] s = operation.split(",");
        double num1 = Double.parseDouble(s[0]);
        double num2 = Double.parseDouble(s[1]);
        double result = Double.parseDouble(s[3]);
        return new Operation(num1, num2, ConsoleReader.operationTypeFromString(s[2]), result);
    }
}
