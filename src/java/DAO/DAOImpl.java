package DAO;

import DBUtility.DBConnection;
import Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Monir
 */
public class DAOImpl implements DAO {
    
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public List<User> getAllUser() {
        //get user record from db table user
        // process the resultse--> assign it to List<User>
        //return the list to the caller
        List<User>ul= new ArrayList<User>();
        try{
            String SQL= "SELECT * FROM User";
            conn= DBConnection.openConnection();
            ps= conn.prepareStatement(SQL);
            rs= ps.executeQuery();
            
            while(rs.next()){
             // User u = new User(rs.getString("id"), rs.getString("name"), rs.getString("email")  ,rs.getInt("age") );
             User u= new User();
             u.setId(rs.getString("id"));
             u.setName(rs.getString("name"));
             u.setEmail(rs.getString("email"));
             u.setAge(rs.getInt("age"));
             ul.add(u);
            }
        }catch(Exception ex){ex.printStackTrace();}
        return ul;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User getUser(String id) {
        
        User u= new User();
        try{
            String SQL= "SELECT * FROM USER WHERE id=?";
            conn= DBConnection.openConnection();
            ps= conn.prepareStatement(SQL);
            ps.setString(1, id);
            rs= ps.executeQuery();
            
            while(rs.next()){
           //User u = new User();
             u.setId(rs.getString("id"));
             u.setName(rs.getString("name"));
             u.setEmail(rs.getString("email"));
             u.setAge(rs.getInt("age"));

            }
        }catch(Exception ex){ex.printStackTrace();}
        
        return u;
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertUser(User u) {
        
        try{
            String sqlinsert= "INSERT INTO user(id, name, email, age) values(?,?,?,?)";
            conn= DBConnection.openConnection();
            ps= conn.prepareStatement(sqlinsert);
            
            ps.setString(1, u.getId());
            ps.setString(2, u.getName());
            ps.setString(3, u.getEmail());
            ps.setInt(4, u.getAge());
            ps.executeUpdate();
            
        }
        catch(Exception ex){ex.printStackTrace();}

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteUser(String id) {
        
        try{
            String sqldelete = "DELETE FROM user WHERE id = ?";
            conn = DBConnection.openConnection();
            ps = conn.prepareStatement(sqldelete);
            ps.setString(1, id);
            ps.executeUpdate();
        }
        catch(Exception ex){
             ex.printStackTrace();
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateUser( User u) {
        
        try{
            String updateSQL = "UPDATE user SET  name = ?, email = ?,  age = ? WHERE id = ?";
            conn = DBConnection.openConnection();
            ps = conn.prepareStatement(updateSQL);
            ps.setString(1, u.getName());
            ps.setString(2, u.getEmail());
            ps.setInt(3, u.getAge());
            ps.setString(4, u.getId());
            ps.executeUpdate();    
 
        }
        catch(Exception ex){
             ex.printStackTrace();
        }
        
        
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
