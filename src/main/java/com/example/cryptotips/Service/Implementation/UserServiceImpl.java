//package com.example.cryptotips.Service.Implementation;
//
//import com.example.cryptotips.Model.Enumerations.Role;
//import com.example.cryptotips.Model.Exceptions.InvalidUsernameOrPasswordException;
//import com.example.cryptotips.Model.Exceptions.PasswordsDoNotMatchException;
//import com.example.cryptotips.Model.Exceptions.UsernameAlreadyExistsException;
//import com.example.cryptotips.Model.User;
//import com.example.cryptotips.Repository.UserRepository;
//import com.example.cryptotips.Service.UserService;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserServiceImpl implements UserService {
//
//    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;
//
//    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Override
//    public User register(String username, String password, String repeatPassword, String name, String surname, Role userRole) {
//        if (username==null || username.isEmpty()  || password==null || password.isEmpty())
//            throw new InvalidUsernameOrPasswordException();
//        if (!password.equals(repeatPassword))
//            throw new PasswordsDoNotMatchException();
//        if(this.userRepository.findByUsername(username).isPresent())
//            throw new UsernameAlreadyExistsException();
//        User user = new User(username,passwordEncoder.encode(password),name,surname,userRole);
//        return userRepository.save(user);
//
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
//    }
//}
