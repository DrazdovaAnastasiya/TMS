package by.tms.util;

import by.tms.console.response.OperationType;
import by.tms.service.Exeptions.InvalidInputException;
import by.tms.service.Exeptions.OperationNotFoundException;

public interface Reader {
    double readDoubleNumber() throws InvalidInputException;

    int readIntNumber() throws InvalidInputException;

//    OperationType readOperationType() throws OperationNotFoundException;

    String readString();
}
