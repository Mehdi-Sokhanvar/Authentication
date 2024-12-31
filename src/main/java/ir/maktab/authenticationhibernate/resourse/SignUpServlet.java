package ir.maktab.authenticationhibernate.resourse;

import ir.maktab.authenticationhibernate.model.dto.UserRequestDTO;
import ir.maktab.authenticationhibernate.model.dto.UserResponseDTO;
import ir.maktab.authenticationhibernate.service.UserService;
import ir.maktab.authenticationhibernate.service.UserServiceImpl;
import ir.maktab.authenticationhibernate.util.ApplicationContext;
import ir.maktab.authenticationhibernate.util.UserNameGenerator;

import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        UserRequestDTO build = UserRequestDTO.builder()
                .email(request.getParameter("email"))
                .username(request.getParameter(UserNameGenerator.getUsername(request.getParameter("email"))))
                .password(request.getParameter("password"))
                .phoneNumber(request.getParameter("phonenumber"))
                .country(request.getParameter("country"))
                .build();

        Set<ConstraintViolation<UserRequestDTO>> constraintViolations =validator.validate(build);
        if (constraintViolations.isEmpty()) {
            Optional<UserResponseDTO> userResponseDTO = ApplicationContext.getUserService().signUp(build);
            if (userResponseDTO.isPresent()) {
                response.sendRedirect("dashboard/panel.jsp");
            } else {
                request.setAttribute("error", "Email is already in use");
                response.sendRedirect("signup.jsp");
            }
        } else {
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<UserRequestDTO> constraintViolation : constraintViolations) {
                sb.append(constraintViolation.getMessage());
            }
            request.setAttribute("error",String.valueOf(sb));
            request.getRequestDispatcher("signup.jsp").forward(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }
}
