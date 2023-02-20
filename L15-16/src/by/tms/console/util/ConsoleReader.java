package by.tms.console.util;

import by.tms.service.Exeptions.InvalidInputException;
import by.tms.service.Exeptions.OperationNotFoundException;
import by.tms.console.response.OperationType;
import by.tms.util.Reader;

import java.util.Scanner;

public class ConsoleReader implements Reader {

    private Scanner scanner = new Scanner(System.in);

    public static OperationType operationTypeFromString(String str) throws OperationNotFoundException {
        String operation = str.trim().toUpperCase();

        for (OperationType operationType : OperationType.values()) {
            if (operation.equals(operationType.toString())) {
                return operationType;
            }
        }

        throw new OperationNotFoundException("OperationNotFound: " + operation);
    }

    @Override
    public double readDoubleNumber() throws InvalidInputException {
        if (scanner.hasNextDouble()) {
            return scanner.nextDouble();
        } else {
            scanner.next();
        }
        throw new InvalidInputException("Incorrect number input.");
    }

    @Override
    public int readIntNumber() throws InvalidInputException{
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        } else {
            scanner.next();
        }
        throw new InvalidInputException("Incorrect number input.");
    }

    @Override
    public OperationType readOperationType() throws OperationNotFoundException {
        String s = scanner.next();

        return operationTypeFromString(s);
    }
}

