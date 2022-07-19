package org.truppe.examen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.truppe.examen.OrdenCompraDao;
import org.truppe.examen.entity.Orden;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class OrdenCompraServiceImp implements OrdenCompraService {

    private OrdenCompraDao ordenCompraDao;

    @Autowired
    public OrdenCompraServiceImp(OrdenCompraDao ordenCompraDao) {
        this.ordenCompraDao = ordenCompraDao;
    }

    @Override
    public Orden registerNewOrder(Orden orden) {
        return ordenCompraDao.save(orden);
    }

    @Override
    public Orden getOrdenById(int ordenId) {
        Optional<Orden> ordenOptional = ordenCompraDao.findById(ordenId);
        if (ordenOptional.isPresent()) {
            return ordenOptional.get();
        } else {
            throw new RuntimeException("Orden no encontrada");
        }
    }

    @Override
    public Orden updateOrden(Orden orden) {
        return ordenCompraDao.save(orden);
    }
}
