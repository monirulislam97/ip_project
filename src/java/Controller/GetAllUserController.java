
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
@WebServlet(name = "GetAllUserController", urlPatterns = {"/GetAllUserController"})
public class GetAllUserController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        //get all the user record from database record
        //put it into session object 9model user)
        //forward to appropriate jsp/view page
        DAO dao= new DAOImpl();
        List<User>ul = dao.getAllUser();
        request.setAttribute("ul", ul);
        request.getRequestDispatcher("/View/viewAllUser.jsp").forward(request, response);
           
    }
}
   