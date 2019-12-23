package servlet;

import model.User;
import service.UserService;
import service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/")
public class ListUserServlet extends HttpServlet {
    private UserService userService = UserServiceImpl.getUserService();

    public ListUserServlet() throws Exception {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("main servlet");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        List<User> listUser = null;
        try {
            listUser = userService.selectAllUsers();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("listUser", listUser);
        request.getRequestDispatcher("/list-user.jsp").forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
    }
}
