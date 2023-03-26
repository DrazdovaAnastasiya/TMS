package by.tms.filter;


import by.tms.validator.OperationValidator;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(servletNames = "CalculatorServlet")
public class CalculatorFilter extends HttpFilter {
    private final OperationValidator validator = new OperationValidator();
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String type = req.getParameter("type");

        if(validator.validateOperationType(type.toUpperCase())){
            chain.doFilter(req, res);
        } else {
            res.sendError(HttpServletResponse.SC_REQUESTED_RANGE_NOT_SATISFIABLE, "Invalid request!");
        }
    }
}
