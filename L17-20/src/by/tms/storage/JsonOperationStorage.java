package by.tms.storage;

import by.tms.entity.Operation;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonOperationStorage implements OperationStorage {

    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public void save(Operation operation) throws Exception {
        List<Operation> list = findAll();
        list.add(operation);
        String operationsJson = gson.toJson(list.toArray());
        FileWriter fileWriter = new FileWriter("operations.json");
        fileWriter.write(operationsJson);
        fileWriter.close();
    }

    private String readFileAsString() throws IOException {
        File file = new File("operations.json");
        if (!file.exists()) {
            file.createNewFile();
        }
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        StringBuilder stringBuilder = new StringBuilder();
        String readLine;
        do {
            readLine = bufferedReader.readLine();
            if (readLine != null) {
                stringBuilder.append(readLine);
            }
        } while (readLine != null);
        bufferedReader.close();
        return stringBuilder.toString();
    }

    @Override
    public List<Operation> findAll() throws Exception {
        String fileAsString = readFileAsString();
        Operation[] operations = gson.fromJson(fileAsString, Operation[].class);
        List<Operation> list;
        if (operations != null) {
            list = new ArrayList(Arrays.asList(operations));
        } else {
            list = new ArrayList<>();
        }
        return list;
    }
}
