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
import javax.servlet.http.HttpSession;

/**
 *
 * @author yglee
 */
@WebServlet(name = "MainPage", urlPatterns = {"/MainPage"})
public class MainPage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //check session
        HttpSession session = request.getSession(false);
        
        if(session == null) {
            response.sendRedirect("Login");
            return;
        }else{
            if(session.getAttribute("user") == null){
                //already logout, go to login
                
            }
            
            //tell browser not to cache this page
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
            response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
            response.setHeader("Expires", "0"); // Proxies.
            
            // forward
            RequestDispatcher rd = request.getRequestDispatcher("mainPage.jsp");
            rd.forward(request, response);
        }       
        
        
    }

}
