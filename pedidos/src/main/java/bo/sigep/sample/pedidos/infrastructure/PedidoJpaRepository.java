package bo.sigep.sample.pedidos.infrastructure;

import bo.sigep.sample.pedidos.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoJpaRepository extends JpaRepository<Pedido, Long> {

}
