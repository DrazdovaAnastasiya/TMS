package by.tms.servlet;

import by.tms.entity.Operation;
import by.tms.service.CalculatorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/calc", name = "CalculatorServlet") //GET localhost:8080/calc?num1=...&num2=...&type=...
public class CalculatorServlet extends HttpServlet {

    private CalculatorService calculator = new CalculatorService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String sNum1 = req.getParameter("num1");
        String sNum2 = req.getParameter("num2");
        String operationType = req.getParameter("type");

        double num1 = Double.parseDouble(sNum1);
        double num2 = Double.parseDouble(sNum2);
        Operation operation = new Operation(num1, num2, operationType.toUpperCase());

        try {
            calculator.calculate(operation);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        resp.getWriter().print("Result = " + operation.getResult());

    }
}
