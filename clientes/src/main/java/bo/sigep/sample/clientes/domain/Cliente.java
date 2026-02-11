package bo.sigep.sample.clientes.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    private Long id;

    private String nombre;

    private boolean activo;

    protected Cliente() {}

    public Cliente(Long id, String nombre, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.activo = activo;
    }

    public boolean isActivo() {
        return activo;
    }

    public Long getId() {
        return id;
    }
}
