package by.tms.servlet;

import by.tms.entity.Operation;
import by.tms.entity.OperationType;
import by.tms.entity.User;
import by.tms.factory.OperationFactory;
import by.tms.service.CalculatorOperation;
import by.tms.service.CalculatorService;
import by.tms.validator.ValidatorCalculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(value = "/calc", name = "CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
    private final ValidatorCalculator validator = new ValidatorCalculator();
    private int userId;
    private CalculatorService calculator = CalculatorService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.getRequestDispatcher("/pages/calc.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sNum1 = req.getParameter("num1");
        String sNum2 = req.getParameter("num2");
        String operationType = req.getParameter("type");

        if (validator.isValidNum(sNum1) & validator.isValidNum(sNum2)) {
        double num1 = Double.parseDouble(sNum1);
        double num2 = Double.parseDouble(sNum2);
        OperationType opType = OperationType.valueOf(operationType);

        if (req.getSession().getAttribute("user") != null) {
            User user = (User) req.getSession().getAttribute("user");
            userId = user.getUserId();
        }
            Operation operation = new Operation(num1, num2, opType, userId);
            CalculatorOperation calculatorOperation = OperationFactory.createOperation(operation).get();
            double result = calculator.calculate(calculatorOperation).get().getResult();

            req.setAttribute("result", result);
            req.getRequestDispatcher("/pages/calc.jsp").forward(req, resp);
        } else {
            req.setAttribute("calcMessage", "Numbers inputted wrong, please try again");
            req.getRequestDispatcher("/pages/calc.jsp").forward(req, resp);
        }

    }
    }

