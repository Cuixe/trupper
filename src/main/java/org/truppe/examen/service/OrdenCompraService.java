package org.truppe.examen.service;

import org.truppe.examen.entity.Orden;

public interface OrdenCompraService {

    Orden registerNewOrder(Orden orden);

    Orden getOrdenById(int ordenId);

    Orden updateOrden(Orden orden);

}
