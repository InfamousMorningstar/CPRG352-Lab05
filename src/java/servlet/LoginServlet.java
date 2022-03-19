package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.user;
import app.AccountService;

/**
 *
 * @author 827097
 */
public class LoginServlet extends HttpServlet {

   

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        user user = (user) session.getAttribute("user");
        
        if (user == null) {
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
        else {
            if (request.getQueryString() == null) {
                response.sendRedirect("home");
            }
            else if (request.getQueryString().equals("logout")){
                session.invalidate();
                session = request.getSession();
                request.setAttribute("message", "You have successfully logged out.");
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
                
            }
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        HttpSession session = request.getSession();
        
        AccountService accountService = new AccountService();
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        user user = accountService.login(username, password);
        
        if (user == null) {
            request.setAttribute("message", "Invalid Login");
            request.setAttribute("username", username);
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            
        }
        else {
            session.setAttribute("user", user);
            response.sendRedirect("home");
        }
    }

   
    
}
