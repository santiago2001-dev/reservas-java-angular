package com.app.crudspringBootthymeleaft.Repositories;

import com.app.crudspringBootthymeleaft.Entidaddb.product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface repositorioProducto extends JpaRepository<product,Integer> {

    @Query(value = "select * from  producto   group by codigo_prouducto,producto,precio,cantidad order by cantidad asc limit 1",nativeQuery = true)
    List<product> proximoEnTerminar();
}
