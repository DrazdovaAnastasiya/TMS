package by.tms.util;

import by.tms.service.Exeptions.InvalidInputException;
import by.tms.service.Exeptions.OperationNotFoundException;
import by.tms.console.response.OperationType;

public interface Reader {
    double readDoubleNumber() throws InvalidInputException;

    int readIntNumber() throws InvalidInputException;

    OperationType readOperationType() throws OperationNotFoundException;
}
