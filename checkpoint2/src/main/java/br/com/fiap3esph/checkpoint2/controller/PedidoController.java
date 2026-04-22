package br.com.fiap3esph.checkpoint2.controller;

import br.com.fiap3esph.checkpoint2.model.Pedido;
import br.com.fiap3esph.checkpoint2.service.PedidoService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<Object> createPedido(@Valid @RequestBody Pedido pedido) {
        try {
            Pedido novoPedido = pedidoService.createPedido(pedido);
            return new ResponseEntity<>(novoPedido, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public List<Pedido> readPedidos() {
        return pedidoService.readAllPedidos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getPedido(@PathVariable Long id) {
        try {
            Pedido pedidoEncontrado = pedidoService.readPedidoById(id);
            return new ResponseEntity<>(pedidoEncontrado, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}