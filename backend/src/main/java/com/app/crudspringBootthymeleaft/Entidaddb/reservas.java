package com.app.crudspringBootthymeleaft.Entidaddb;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "reservas")
public class reservas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private   Long id ;
@Column
    Long id_user ;
@Column
private LocalDate fecha;
@Column
boolean estado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}

