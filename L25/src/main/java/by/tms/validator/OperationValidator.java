package by.tms.validator;

import java.util.regex.Pattern;

public class OperationValidator {
    private static final Pattern type = Pattern.compile("(SUM)|(SUB)|(MUL)|(DIV)");
    public boolean validateOperationType(String operationType){return type.matcher(operationType).matches();}


}
