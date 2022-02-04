
package Controller;

import DAO.DAO;
import DAO.DAOImpl;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Monir
 */
@WebServlet(name = "getSingleUser", urlPatterns = {"/getSingleUser"})
public class getSingleUser extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        DAO dao= new DAOImpl();
        User u = dao.getUser(request.getParameter("id"));
        request.setAttribute("u", u);
        request.getRequestDispatcher("/View/viewSingleUser.jsp").forward(request, response);
    }
}