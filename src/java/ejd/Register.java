//
//Author:  Younggil Lee
//  Student ID: 991 395 505
//  Description: Create sign-up Application that stores users data, handles attributes
//               between logical components. Also, filter to prevent pages from unauthorized access.  
package ejd;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author yglee
 */
@WebServlet(name = "Register", urlPatterns = {"/Register"})
public class Register extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // get 5 input parameters from request
        String userId = request.getParameter("userId");
        String pass1 = request.getParameter("pass1");
        String pass2 = request.getParameter("pass2");
        String nickname = request.getParameter("nickname");
        String email = request.getParameter("email");
        
        // instance of userDatabase to access DB
        UserDatabase db = new UserDatabase();
        
        // attribute to store the current status for result/error
        String signupMessage = null;
        
        //validate all input parameters
        if (userId == null || userId.isEmpty()) {

            signupMessage = "ID is empty.";

        } else if (db.isUnique(userId)) {

            signupMessage = "ID is existed.";

        } else if (pass1 == null || pass1.isEmpty()) {

            signupMessage = "Please enter password";

        } else if (pass2 == null || pass2.isEmpty()) {

            signupMessage = "Please Re-enter password";

        } else if (nickname == null || nickname.isEmpty()) {

            signupMessage = "Please enter nickname";

        } else if (email == null || email.isEmpty()) {

            signupMessage = "Please enter email";

        } else if (!pass1.equals(pass2)) {

            signupMessage = "Passwords are not the same";

        } 

        // variable for stroing result of update DB
        int inputResult = 0;
        
        // passed validation, forword to registerResult.jsp
        if (signupMessage == null) {
            
            // update the user information to db
            inputResult = db.addUser(userId, pass1, nickname, email);
            
            // addUser() is sucessful forword to registerResult.jsp
            if (inputResult == 1) {

                RequestDispatcher rd = request.getRequestDispatcher("registerResult.jsp");

                rd.forward(request, response);
             
            // if addUser() fail. If so , set "Try again    
            } else {
                
                signupMessage = "Try again...";

                request.setAttribute("message", signupMessage);

                RequestDispatcher rd = request.getRequestDispatcher("registerResult.jsp");

                rd.forward(request, response);
           
            }
        
            //if failed input validation, forward to register.jsp
        } else {
            
            //set signupMessage as request attribute
            request.setAttribute("message", signupMessage);

            RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
            
            //forward
            rd.forward(request, response);

        }

    }

}
