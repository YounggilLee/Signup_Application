import ejd.User;
import ejd.UserDatabase;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestDatabase")
public class TestDatabase extends HttpServlet
{
    ///////////////////////////////////////////////////////////////////////////
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        // get printwriter
        PrintWriter out = response.getWriter();
        
        // create an instance of Model component
        UserDatabase db = new UserDatabase();
        
        // test addUser()
        out.println("Try to add \"test\" to DB...\n");
        int result = db.addUser("test",
                                "password",
                                "nickname",
                                "email.com");
        out.println("addUser(): " + result);
        
        // test getUser()
        User user = db.getUser("test");
        out.println("getUser(): " + user);
        
        // test isUnique()
        out.println("\nTry to test if \"test\" is in DB...\n");
        boolean unique = db.isUnique("test");
        out.println("isUnique(): " + unique);
        
        // test isValid()
        boolean valid = db.isValid("test", "password");
        out.println("isValid(): " + valid);
    }


  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        doGet(request, response);
    }
}
