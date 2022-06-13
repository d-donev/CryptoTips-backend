//package com.example.cryptotips.Service.Implementation;
//
//import com.example.cryptotips.Model.Exceptions.InvalidArgumentsException;
//import com.example.cryptotips.Model.Exceptions.InvalidUserCredentialsException;
//import com.example.cryptotips.Model.User;
//import com.example.cryptotips.Repository.UserRepository;
//import com.example.cryptotips.Service.AuthService;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AuthServiceImpl implements AuthService {
//
//    private final UserRepository userRepository;
//
//    public AuthServiceImpl(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public User login(String username, String password) {
//        if (username==null || username.isEmpty() || password==null || password.isEmpty()) {
//            throw new InvalidArgumentsException();
//        }
//        return userRepository.findByUsernameAndPassword(username,
//                password).orElseThrow(InvalidUserCredentialsException::new);
//
//    }
//}
