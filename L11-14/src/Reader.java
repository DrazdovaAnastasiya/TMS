import Exeptions.InvalidInputException;
import Exeptions.OperationNotFoundException;

public interface Reader {
    double readDoubleNumber() throws InvalidInputException;

    int readIntNumber() throws InvalidInputException;

    OperationType readOperationType() throws OperationNotFoundException;
}
