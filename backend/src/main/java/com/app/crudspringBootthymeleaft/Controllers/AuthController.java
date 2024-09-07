package com.app.crudspringBootthymeleaft.Controllers;

import com.app.crudspringBootthymeleaft.Entidaddb.reservas;
import com.app.crudspringBootthymeleaft.Requests.AuthRequest;
import com.app.crudspringBootthymeleaft.Services.UserService;
import com.app.crudspringBootthymeleaft.utils.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import com.app.crudspringBootthymeleaft.Entidaddb.User;

import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    public AuthController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        try {
            // Guarda el usuario en la base de datos
            userService.saveUser(user);
            return ResponseEntity.ok().body(Map.of("message", "Usuario creado de forma correcta!"));
        } catch (Exception e) {
            // Retorna un error si algo falla
            return ResponseEntity.badRequest().body(Map.of("error", "Fallo al registrar usuario "));
        }
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUser() {
        try {
            List<User> reservasList = userService.findAll();
            return ResponseEntity.ok(reservasList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
        try {
            // Encuentra el usuario por correo
            User user = userService.findByUsername(authRequest.getCorreo());
            if (user != null && userService.passwordMatches(authRequest.getContrasena(), user.getContrasena())) {
                // Genera un token si las credenciales son válidas
                String token = jwtUtil.generateToken(user.getCorreo());
                return ResponseEntity.ok().body(Map.of("token", token, "message", "Inicio de sesión correcto!"));
            } else {
                return ResponseEntity.status(401).body(Map.of("error", "Fallo de credenciales"));
            }
        } catch (Exception e) {
            // Retorna un error si algo falla
            return ResponseEntity.badRequest().body(Map.of("error", "Fallo al iniciar sesión"+e.getMessage()));
        }
    }
}
