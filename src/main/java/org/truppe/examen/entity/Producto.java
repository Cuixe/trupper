package org.truppe.examen.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCTOS")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "producto_id")
    @Getter@Setter
    private int id;

    @Column
    @Getter@Setter
    private String codigo;

    @Column
    @Getter@Setter
    private String descripcion;

    @Column
    @Getter@Setter
    private double precio;
}
