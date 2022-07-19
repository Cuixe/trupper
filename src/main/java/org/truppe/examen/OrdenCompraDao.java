package org.truppe.examen;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.truppe.examen.entity.Orden;

@Repository
public interface OrdenCompraDao extends CrudRepository<Orden, Integer> {
}
