//
//Author:  Younggil Lee
//  Student ID: 991 395 505
//  Description: Create sign-up Application that stores users data, handles attributes
//               between logical components. Also, filter to prevent pages from unauthorized access.  
package ejd;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author yglee
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       //get params
       String userId = request.getParameter("user");
       String password = request.getParameter("pass");
              
       UserDatabase db = new UserDatabase();
       
       if(db.isValid(userId, password)) {
           
           //create session
           HttpSession session = request.getSession(true);
           
           // add 2 attributes
           User user = db.getUser(userId);
           session.setAttribute("user", user);
           
           ArrayList<User> users = db.getUsers();
           session.setAttribute("users", users);
           
           
           //send redirect to MainPage(servlet)
           response.sendRedirect("MainPage");         
           
       }else{
           String loginMessage = "UserId and/or Password is incorrect.";
           request.setAttribute("loginMessage", loginMessage);
           
           RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
           rd.forward(request, response);
       }
       
        
        
        
    }


}
