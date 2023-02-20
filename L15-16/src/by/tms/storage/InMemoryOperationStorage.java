package by.tms.storage;

import by.tms.entity.Operation;

import java.util.ArrayList;
import java.util.List;

public class InMemoryOperationStorage implements OperationStorage{
    private List<Operation> operations;


    public InMemoryOperationStorage (){
        this.operations = new ArrayList<>();
    }

   @Override
    public void save (Operation operation){
       operations.add(operation);
    }

    @Override
    public List<Operation> findAll(){
        return new ArrayList<>(operations);
    }
}
