package by.tms.validator;

import java.util.regex.Pattern;

public class ValidatorCalculator {
    private static final Pattern type = Pattern.compile("(SUM)|(SUB)|(MUL)|(DIV)");
    private static final Pattern NUM = Pattern.compile("^\\d[.\\d]*");
    public boolean validateOperationType(String operationType){return type.matcher(operationType).matches();}
    public boolean isValidNum(String num){return NUM.matcher(num).matches();}

}
