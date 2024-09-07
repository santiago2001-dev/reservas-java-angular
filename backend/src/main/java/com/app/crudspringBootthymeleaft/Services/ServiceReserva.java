package com.app.crudspringBootthymeleaft.Services;

import com.app.crudspringBootthymeleaft.Entidaddb.reservas;

import java.util.List;
import java.util.Map;

public interface ServiceReserva {
    public List<reservas> getAllReservas();
    public reservas getReservatByid(Long codiReserva);


    public reservas addProduct(reservas reseva);
    public void deleteReserva(Long codgiReser);
    public reservas actualizarPorId(Long codigoReser, Map<Object, Object> objectMap);

}
