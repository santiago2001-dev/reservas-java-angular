package com.app.crudspringBootthymeleaft.Entidaddb;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "producto")
public class product {
    @Id
    private  int codigoProuducto;
    @Column(nullable = false, length = 50)
    private String producto ;
    @Column(nullable = false)
    private int precio;
    @Column(nullable = false)
    private  int cantidad ;

    public product() {
    }

    public product(int codigoProuducto, String producto, int precio, int cantidad) {
        this.codigoProuducto = codigoProuducto;
        this.producto = producto;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public int getCodigoProuducto() {
        return codigoProuducto;
    }

    public void setCodigoProuducto(int codigoProuducto) {
        this.codigoProuducto = codigoProuducto;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
