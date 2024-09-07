package com.app.crudspringBootthymeleaft.Services;

import com.app.crudspringBootthymeleaft.Entidaddb.product;
import com.app.crudspringBootthymeleaft.Entidaddb.reservas;
import com.app.crudspringBootthymeleaft.Repositories.ReservasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
@Service
public class ServiceImpReserva  implements  ServiceReserva{

@Autowired ReservasRepository repoReserva;
    @Override
    public List<reservas> getAllReservas() {
        return repoReserva.findAll();

    }



    @Override
    public reservas getReservatByid(Long codiReserva) {
        return repoReserva.findById(codiReserva).get();
    }

    @Override
    public reservas addProduct(reservas reserva) {
        return repoReserva.save(reserva);
    }

    @Override
    public void deleteReserva(Long codgiReser) {
        repoReserva.deleteById(codgiReser);

    }

    @Override
    public reservas actualizarPorId(Long codigoReser, Map<Object, Object> objectMap) {
        reservas reser= repoReserva.findById(codigoReser).get();
        objectMap.forEach((key, value) ->{
            Field field= ReflectionUtils.findField(product.class, (String) key);
            field.setAccessible(true);
            ReflectionUtils.setField(field, reser, value);
        });
        return  repoReserva.save(reser);
    }
}
