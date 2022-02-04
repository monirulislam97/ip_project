<%-- 
    Document   : viewSingleUser
    Created on : Feb 1, 2022, 3:23:26 PM
    Author     : Monir
--%>

<%@page import="Model.User"%>
<%@page import="Model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" crossorigin="anonymous">
        <title>viewSingleUser.JSP</title>
    </head>
    <body>
        <div class="container">   
            <h1>This is viewSingleUser.jsp</h1>
            <table class="table table-dark">
                <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Name</th>
                        <th scope="col">Email</th>
                        <th scope="col">Age</th>
                    </tr>
                </thead>
                <%   
                    User u =(User)request.getAttribute("u");
                %>
                <tbody>
                    <tr>
                        <td><%= u.getId() %></td>
                        <td><%= u.getName() %></td>
                        <td><%= u.getEmail()%></td>
                        <td><%= u.getAge()%></td>
                    </tr>
            </table>

        <a href='View/update.html'> <button  class="btn btn-success"  >Update User</button></a>
        <a href='View/delete.html'><button type="reset" class="btn btn-warning" >Delete User</button></a>
        <a href='View/viewSingleUser.html'><button class="btn btn-info" >Display Single User</button></a>
        <a href='View/index.html'><button class="btn btn-primary" >Insert new User</button></a>   



    </div>   
</body>
</html>
