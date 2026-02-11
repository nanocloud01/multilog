package bo.sigep.sample.test;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name="PRV_SICOES_LOGIN")
public class PrvLoginEntity {

    @Id
    @Column(name = "ID", nullable = false, length = 150)
    private String id;

    @Column(name = "USUARIO", length = 30)
    private String usuario;

    @Column(name = "PASSWORD", length = 40)
    private String password;

    @Column(name = "FECHA")
    private LocalDateTime fecha;

    public PrvLoginEntity() {
    }

    public PrvLoginEntity(String id, String usuario, String password, LocalDateTime fecha) {
        this.id = id;
        this.usuario = usuario;
        this.password = password;
        this.fecha = fecha;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}