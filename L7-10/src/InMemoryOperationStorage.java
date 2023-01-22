public class InMemoryOperationStorage implements OperationStorage{   //тренировка по лекциям
    private Operation[] operations;
    private int nextOperationIndex;

    public InMemoryOperationStorage (int storageSize){
        this.operations = new Operation[storageSize];
        this.nextOperationIndex = 0;
    }

    public void save (Operation operation){
        if (nextOperationIndex >= this.operations.length){
            this.nextOperationIndex = 0;
        }
        this.operations[nextOperationIndex] = operation;
        this.nextOperationIndex++;
    }

    private int getPosition (int i){
        return ((this.nextOperationIndex - 1 - i) >= 0) ? (this.nextOperationIndex - 1 -i) : this.operations.length + (this.nextOperationIndex - 1 -i);
    }

    @Override
    public Operation[] findAll(){
        return operations;
    }

}
