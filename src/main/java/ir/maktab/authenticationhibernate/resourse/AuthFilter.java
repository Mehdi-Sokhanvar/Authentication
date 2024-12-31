package ir.maktab.authenticationhibernate.resourse;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

@WebFilter("/dashboard/*")
public class AuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = ((HttpServletRequest) request).getSession();

        if (username == null && password == null) {
            request.setAttribute("error", "You must Login first");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            Optional<Object> userOptional = Optional.ofNullable(session.getAttribute("username"));
            Optional<Object> passOptional = Optional.ofNullable(session.getAttribute("password"));
            if (userOptional.isPresent() && passOptional.isPresent()) {
                chain.doFilter(request, response);
            } else {
                request.setAttribute("error", "You are not logged in");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        }
    }
}
