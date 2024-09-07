package com.app.crudspringBootthymeleaft.Controllers;

import com.app.crudspringBootthymeleaft.Entidaddb.reservas;
import com.app.crudspringBootthymeleaft.Services.ServiceImpReserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/api/reserva")
@RestController

public class ControllerReserva {

    @Autowired
    ServiceImpReserva servReserva;

    @GetMapping
    public ResponseEntity<List<reservas>> getAllReserva() {
        try {
            List<reservas> reservasList = servReserva.getAllReservas();
            return ResponseEntity.ok(reservasList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @GetMapping("/{codigoReserva}")
    public ResponseEntity<reservas> getbyid(@PathVariable("codigoReserva") Long codReserva) {
        try {
            reservas reserva = servReserva.getReservatByid(codReserva);
            return ResponseEntity.ok(reserva);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<reservas> addReservva(@RequestBody reservas reserva) {
        try {
            reservas newReserva = servReserva.addProduct(reserva);
            return ResponseEntity.status(HttpStatus.CREATED).body(newReserva);
        } catch (Exception e) {
            // Manejo de excepción, por ejemplo, para errores de validación
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PutMapping("/{codigoReserva}")
    public ResponseEntity<reservas> updateReserva(@PathVariable("codigoReserva") Long codigoReserva, @RequestBody Map<Object, Object> objectMap) {
        try {
            reservas updatedReserva = servReserva.actualizarPorId(codigoReserva, objectMap);
            return ResponseEntity.ok(updatedReserva);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{codigoReserva}")
    public ResponseEntity<Void> deleteProdcut(@PathVariable("codigoReserva") Long codigoReserva) {
        try {
            servReserva.deleteReserva(codigoReserva);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
