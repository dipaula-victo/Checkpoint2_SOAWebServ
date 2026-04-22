package br.com.fiap3esph.checkpoint2.service;

import br.com.fiap3esph.checkpoint2.model.Pedido;
import br.com.fiap3esph.checkpoint2.repository.PedidoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido createPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> readAllPedidos() {
        return pedidoRepository.findAll();
    }

    public Pedido readPedidoById(Long id) {
        return pedidoRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Pedido não encontrado")
        );
    }
}