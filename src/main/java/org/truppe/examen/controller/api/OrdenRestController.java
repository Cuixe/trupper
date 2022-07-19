package org.truppe.examen.controller.api;

import org.springframework.web.bind.annotation.*;
import org.truppe.examen.entity.Orden;
import org.truppe.examen.service.OrdenCompraService;

@RestController
@RequestMapping("/api/orden")
public class OrdenRestController {

    private OrdenCompraService ordenCompraService;

    public OrdenRestController(OrdenCompraService ordenCompraService) {
        this.ordenCompraService = ordenCompraService;
    }

    @PostMapping()
    public Orden addOrder(@RequestBody Orden orden) {
        return ordenCompraService.registerNewOrder(orden);
    }

    @GetMapping("/{orderId}")
    public Orden findById(@PathVariable int orderId) {
        return ordenCompraService.getOrdenById(orderId);
    }

    @PutMapping()
    public Orden updateOrder(@RequestBody Orden orden) {
        return ordenCompraService.registerNewOrder(orden);
    }
}
