
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Monir
 */
@WebServlet(urlPatterns = {"/svlt803"})
public class svlt803 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        
            String driver = "com.mysql.jdbc.Driver";
            String Url = "jdbc:mysql://localhost:3306/";
            String Database = "myproject";
            String user="root";
            String password="";
            
            String id= request.getParameter("id");
            String name= request.getParameter("username");
            String email= request.getParameter("email");
            int age= LocalDate.now().getYear()- Integer.parseInt(request.getParameter("yob"));
        
        //Work on database part here
       
        try{
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(Url+Database, user, password);
           // Statement stmt= conn.createStatement();
           // String sqlinsert= "insert into user(id, name, email, age) values('"+id+"','"+name+"','"+email+"',"+age+")";
          
           //lets use prepared statement
            String sqlinsert= "insert into user(id, name, email, age) values(?,?,?,?)";
            PreparedStatement ps= conn.prepareStatement(sqlinsert);
            
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setString(3, email);
            ps.setInt(4, age);
            ps.executeUpdate();
            log(sqlinsert);
            
            conn.close();
            response.sendRedirect("viewAll.jsp");
        }
        catch(Exception ex){}
        

    }
}

    