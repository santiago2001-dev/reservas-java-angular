package com.app.crudspringBootthymeleaft.Repositories;

import com.app.crudspringBootthymeleaft.Entidaddb.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByCorreo(String correo);


}

