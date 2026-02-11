package bo.sigep.sample.clientes.infrastructure;

import bo.sigep.sample.clientes.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteJpaRepository extends JpaRepository<Cliente, Long> {

}
