package bo.sigep.sample.pedidos.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long clienteId;

    private String estado;

    protected Pedido() {}

    private Pedido(Long clienteId) {
        this.clienteId = clienteId;
        this.estado = "CREADO";
    }

    public static Pedido crear(Long clienteId) {
        return new Pedido(clienteId);
    }

    public void confirmar() {
        if (!estado.equals("CREADO")) {
            throw new RuntimeException("Estado inválido");
        }
        this.estado = "CONFIRMADO";
    }

    public Long getId() {
        return id;
    }
}
