package by.tms.servlet;

import by.tms.entity.Operation;
import by.tms.service.CalculatorService;
import by.tms.storage.JdbcOperationStorage;
import by.tms.storage.OperationStorage;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/calc/history")
public class CalculatorHistoryServlet extends HttpServlet {
    private CalculatorService calcService = new CalculatorService();
    private OperationStorage jdbcOperationStorage = new JdbcOperationStorage();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Operation> operationList;
        try {
            operationList = jdbcOperationStorage.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        StringBuilder operationBuilder = new StringBuilder();

        for (Operation operation : operationList) {
            String sOperation = "num1: " + operation.getNum1() + " num2: " + operation.getNum2() + " type: " + operation.getType() +  " result: " + operation.getResult();
            operationBuilder.append(sOperation);
            operationBuilder.append("\n");
        }

        String historyOperation = operationBuilder.toString();
        resp.getWriter().print(historyOperation);
    }
}
