import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class LifeCycle extends GenericServlet {
    // Life cycle of Servlet are
    // init()
    // service()
    //destroy()

    //init()
    public void init() throws ServletException{
        System.out.println("init method --- Initialized servlet");

    }
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("service() called -- Handling Request");
        res.setContentType("text/html");
        PrintWriter out= res.getWriter();
        out.println("<h2>Hello from Life cycle</h2>");

    }
    public void destroy(){
        System.out.println("destroy() called -- servlet destroyed");

    }
}
