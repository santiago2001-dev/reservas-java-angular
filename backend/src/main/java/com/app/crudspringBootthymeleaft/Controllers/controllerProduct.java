package com.app.crudspringBootthymeleaft.Controllers;
import com.app.crudspringBootthymeleaft.Entidaddb.product;
import com.app.crudspringBootthymeleaft.Services.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/api/producto")
@RestController
public class controllerProduct {
    @Autowired
    private serviceImpProduct serprod;

    @GetMapping
    public List<product> getAllProduct(){
        return serprod.getAllProducts();
    }

@GetMapping("/{codigoProducto}")
public product getbyid(@PathVariable("codigoProducto")Integer codigoProducto){
        return serprod.getProductByid(codigoProducto);
}




@PostMapping
    public  product addProduct(@RequestBody product product){
        return  serprod.addProduct(product);

}

@PatchMapping("/{codigoProducto}")
    public product updateProduct(@PathVariable("codigoProducto")Integer codigoProducto,@RequestBody Map<Object, Object> objectMap){
    return  serprod.actualizarPorId(codigoProducto,objectMap);
}

@DeleteMapping("/{codigoProducto}")
    public  void deleteProdcut(@PathVariable("codigoProducto")Integer codigoProducto){
        serprod.deleteProduct(codigoProducto);
}
}



