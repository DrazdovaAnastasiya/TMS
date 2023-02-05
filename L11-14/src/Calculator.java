public class Calculator {
    private OperationStorage storage = new FileOperationStorage();
    public Operation calculate(Operation operation) throws Exception {
        switch (operation.getType()) {
            case SUM:
                operation.setResult(operation.getNum1() + operation.getNum2());
            case SUB:
                operation.setResult(operation.getNum1() - operation.getNum2());
            case MUL:
                operation.setResult(operation.getNum1() * operation.getNum2());
            case DIV:
                operation.setResult(operation.getNum1() / operation.getNum2());
        }


        storage.save(operation);

        return operation;
    }
}
