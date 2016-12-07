package ejd;

// static class for printing HTML header and footer

import java.io.PrintWriter;

public final class HtmlUtil 
{
    // private ctor: prevent from instanciating this class
    private HtmlUtil()
    {
        // empty body        
    }
    
    // static methods
    public static void printHeader(PrintWriter out, 
                                   String title,
                                   String css)
    {   
        //validate params
        if(out == null)
            return;
        if(title == null)
            title = "";
        if(css == null)
            css = "";
        String header = "<!DOCTYPE html>\n" +
                        "<html lang=\"en\">\n" +
                        "<head>\n" +
                        "<meta charset=\"utf-8\">\n" +
                        "<title>" +
                        title +
                        "</title>\n" +
                        css + "\n" +
                        "</head>\n" +
                        "<body>\n";
        out.println(header);
    }
    
    // overload method with only 2 params
    public static void printHeader(PrintWriter out, String title)
    {
        printHeader(out, title, "");
    }                     
                                   
     
    public static void printFooter(PrintWriter out)
    {
        out.println("</body>\n</html>\n");
    }
}
