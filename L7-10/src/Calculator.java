public class Calculator {
    public Operation calculate(Operation operation) {
        switch (operation.getType()) {
            case "sum":
                return operation.setResult(operation.getNum1() + operation.getNum2());
            case "sub":
                return operation.setResult(operation.getNum1() - operation.getNum2());
            case "mul":
                return operation.setResult(operation.getNum1() * operation.getNum2());
            case "div":
                return operation.setResult(operation.getNum1() / operation.getNum2());
        }
        return operation;
    }
}
