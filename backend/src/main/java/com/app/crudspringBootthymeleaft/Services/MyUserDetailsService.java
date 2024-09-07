package com.app.crudspringBootthymeleaft.Services;
import com.app.crudspringBootthymeleaft.Repositories.UserRepository;
import com.app.crudspringBootthymeleaft.Entidaddb.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Buscar el usuario en la base de datos
        User user = userRepository.findByCorreo(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        // Retornar un UserDetails que será utilizado por Spring Security
        return new org.springframework.security.core.userdetails.User(user.getCorreo(), user.getContrasena(), new ArrayList<>());
    }
}
