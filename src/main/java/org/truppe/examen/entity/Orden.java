package org.truppe.examen.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ORDENES")
public class Orden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orden_id")
    @Getter@Setter
    private int id;

    @Getter@Setter
    @Column(name = "fecha")
    private LocalDate fecha;

    @Column
    @Getter@Setter
    private double total;

    @OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name = "producto_id")
    @Getter@Setter
    private List<Producto> productos = new ArrayList<>();

}
