package ir.maktab.authenticationhibernate.util;

import ir.maktab.authenticationhibernate.repository.UserRepository;
import ir.maktab.authenticationhibernate.repository.UserRepositoryImpl;
import ir.maktab.authenticationhibernate.service.UserService;
import ir.maktab.authenticationhibernate.service.UserServiceImpl;
import lombok.Getter;

@Getter
public class ApplicationContext {

    private  final static UserRepository userRepository;
    private static UserService userService;

    static {
        userRepository = new UserRepositoryImpl();
        userService = new UserServiceImpl(userRepository);
    }


    public static UserService getUserService() {
        return userService;
    }
}
