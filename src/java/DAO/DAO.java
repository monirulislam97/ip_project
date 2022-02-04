/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.User;
import java.util.List;

/**
 *
 * @author Monir
 */
public interface  DAO {
    
    //define all the method available to access user table
    public List<User> getAllUser();
    public User getUser(String id);
    public void insertUser(User u);
    public void deleteUser(String id);
    public void updateUser(User u);
    
}
