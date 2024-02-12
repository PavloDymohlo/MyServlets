package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servlets.User;

import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/users")
public class UserServlet extends HttpServlet {
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder reqBody;
        try (BufferedReader reader = req.getReader()) {
            reqBody = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                reqBody.append(line);
            }
        }
        User user = mapper.readValue(reqBody.toString(), User.class);
        System.out.println(user);
    }
}
