package com.app.crudspringBootthymeleaft.Services;

import com.app.crudspringBootthymeleaft.Entidaddb.User;
import com.app.crudspringBootthymeleaft.Repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User saveUser(User user) {
        user.setContrasena(passwordEncoder.encode(user.getContrasena()));
        return userRepository.save(user);
    }

    public User findByUsername(String correo) {
        User user = userRepository.findByCorreo(correo);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        return user;
    }
    public List< User> findAll(){
        return userRepository.findAll();
    }

    public boolean passwordMatches(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }}
