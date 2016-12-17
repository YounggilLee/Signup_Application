//
//Author:  Younggil Lee
//  Student ID: 991 395 505
//  Description: Create sign-up Application that stores users data, handles attributes
//               between logical components. Also, filter to prevent pages from unauthorized access.    


package ejd;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FilterPage implements Filter
{
    public FilterPage()
    {
    }
    public void init(FilterConfig filterConfig)
    {        
    }
    public void destroy()
    {        
    }    
    
    ///////////////////////////////////////////////////////////////////////////
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException, ServletException
    {
        // pre-process the request
        System.out.println("Filtering the request...");

        // get URI
        String uri = ((HttpServletRequest)request).getRequestURI();
        System.out.println("URI: " + uri);

        // prevent user from accessing simple.jsp directly
        // If so, redirect to error.jsp
        if(uri.endsWith("mainPage.jsp")|| uri.endsWith("registerResult.jsp"))
                
        {
            System.out.println("Unauthorized Access...");
            ((HttpServletResponse)response).sendRedirect("error.jsp");
        }
        else
        {
            // pass the request along the filter chain
            chain.doFilter(request, response);
        }

        // post-process the response
        System.out.println("Filtering the response...\n");
    }
}
