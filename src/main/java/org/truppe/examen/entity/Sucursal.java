package org.truppe.examen.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "SUCURSALES")
public class Sucursal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sucursal_id")
    @Getter
    @Setter
    private int id;

    @Getter@Setter
    @Column(name = "nombre")
    private String name;

    @OneToMany
    @JoinColumn(name = "order_id")
    @Getter
    private List<Orden> ordenes;

}
