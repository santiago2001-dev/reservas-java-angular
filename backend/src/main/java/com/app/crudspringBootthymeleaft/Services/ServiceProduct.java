package com.app.crudspringBootthymeleaft.Services;

import com.app.crudspringBootthymeleaft.Entidaddb.product;

import java.util.List;
import java.util.Map;

public interface            ServiceProduct {
public List<product> getAllProducts();
public product getProductByid(Integer codigoProducto);
public product addProduct(product prod);
public void deleteProduct(Integer codgioProducto);
public product actualizarPorId(Integer codigoProd, Map<Object, Object> objectMap);
public List<product> proximoPorAgotar();



}
