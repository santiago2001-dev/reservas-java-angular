package com.app.crudspringBootthymeleaft.Services;


import com.app.crudspringBootthymeleaft.Entidaddb.product;
import com.app.crudspringBootthymeleaft.Repositories.repositorioProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Service

public class serviceImpProduct implements  ServiceProduct {
    @Autowired
    private repositorioProducto repoProd;
    @Override
    public List<product> getAllProducts() {
        return repoProd.findAll();
    }

    @Override
    public product getProductByid(Integer codigoProducto) {
        return repoProd.findById(codigoProducto).get();
    }

    @Override
    public product addProduct(product prod) {
        return repoProd.save(prod);
    }

    @Override
    public void deleteProduct(Integer codgioProducto) {
         repoProd.deleteById(codgioProducto);
    }

    @Override
    public product actualizarPorId(Integer codigoProd, Map<Object, Object> objectMap) {
        product prod= repoProd.findById(codigoProd).get();
        objectMap.forEach((key, value) ->{
            Field field= ReflectionUtils.findField(product.class, (String) key);
            field.setAccessible(true);
            ReflectionUtils.setField(field, prod, value);
        });
        return  repoProd.save(prod);
    }

    @Override
    public List<product> proximoPorAgotar() {

    return repoProd.proximoEnTerminar();
    }

}
