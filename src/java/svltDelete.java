/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
@WebServlet(urlPatterns = {"/svltDelete"})
public class svltDelete extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

      
            String driver = "com.mysql.jdbc.Driver";
            String Url = "jdbc:mysql://localhost/";
            String Database = "myproject";
            String user="root";
            String password="";
            
            String id= request.getParameter("id");
//            String name= request.getParameter("username");
//            String email= request.getParameter("email");
//            int age= LocalDate.now().getYear()- Integer.parseInt(request.getParameter("yob"));
        
        //Work on database part here
       
        try{
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(Url+Database,user,password);
            String preparedSQL = "DELETE FROM user WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(preparedSQL);
            ps.setString(1, id);
            ps.executeUpdate();
            
            conn.close();
            response.sendRedirect("viewAll.jsp");    
 
        }
        catch(Exception ex){
             ex.printStackTrace();
        }

    }
}

    