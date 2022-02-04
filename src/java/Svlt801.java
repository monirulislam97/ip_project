import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/Svlt801"})
public class Svlt801 extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<h1>Servlet Svlt801 at " + request.getContextPath() + "</h1>");
        
        try {
            
            String url="jdbc:mysql://localhost:3306/myproject";
            String user="root";
            String password="";
            
            
            //1. import sql file/package  in mysql
            //2. load and register driver also add jar file in libraries
            Class.forName("com.mysql.jdbc.Driver");
            
            //3Create connection
            Connection conn= DriverManager.getConnection(url, user, password);
            //connection checking
           // out.println("<h4> DB CONNECTION INFO:"+conn.getMetaData().getDriverName()+"</h4>"); 
           
           //4. create Sql statement
           Statement stmt= conn.createStatement();
            
           //5. exeute the statement
            String sqlselect= "Select * from user";
            ResultSet rs = stmt.executeQuery("Select * from user");
            //rs.next();
            
            //6. process the result
            while( rs.next()){
            out.println("<h4> ID: "+rs.getString("id")+"Username: "+rs.getNString("name")+"Age: " +rs.getInt("age")+"</h4>");
            }
            
            
            //7. close the connection
            conn.close();

        } catch (Exception ex) {
           ex.printStackTrace(out);
        }
        
        
        }
    
}
