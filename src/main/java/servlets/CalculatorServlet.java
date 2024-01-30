import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calculate")
public class CalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("calculatorServlet.jsp");
        dispatcher.forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.setContentType("text/html");
        PrintWriter writer;
        writer = resp.getWriter();
        String operation = req.getParameter("operation");
        double firstOperand = Double.parseDouble(req.getParameter("firstOperand"));
        double secondOperand = Double.parseDouble(req.getParameter("secondOperand"));
        double result;
        switch (operation) {
            case "add":
                result = firstOperand + secondOperand;
                break;
            case "subtraction":
                result = firstOperand - secondOperand;
                break;
            case "multiply":
                result = firstOperand * secondOperand;
                break;
            case "divide":
                if (secondOperand != 0) {
                    result = firstOperand / secondOperand;
                } else {
                    writer.println("You cannot divide by zero");
                    return;
                }
                break;
            default:
                writer.println("I don't know its operation!");
                return;
        }
        req.setAttribute("result", result);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/calculatorServlet.jsp");
        dispatcher.forward(req, resp);
        System.out.println("Result: " + result);
    }
}