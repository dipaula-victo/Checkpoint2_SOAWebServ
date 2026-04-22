package br.com.fiap3esph.checkpoint2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "Pedidos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pedido{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "O preenchimento do nome é obrigatório")
    private String clienteNome;

    private LocalDate dataPedido;

    @DecimalMin(value = "0.0", message = "O valor total não pode ser negativo")
    @Positive
    private double valorTotal;

    @PrePersist
    public void prePersist() {
        if (this.dataPedido == null) {
            this.dataPedido = LocalDate.now();
        }
    }
}