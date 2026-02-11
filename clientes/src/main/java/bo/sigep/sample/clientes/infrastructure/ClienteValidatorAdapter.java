package bo.sigep.sample.clientes.infrastructure;

import bo.sigep.sample.clientes.api.ClienteValidatorPort;
import bo.sigep.sample.clientes.domain.Cliente;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ClienteValidatorAdapter implements ClienteValidatorPort {

    private static final Logger logger = LoggerFactory.getLogger(ClienteValidatorAdapter.class);

    private final ClienteJpaRepository repository;

    public ClienteValidatorAdapter(ClienteJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public void validarClienteActivo(Long clienteId) {

        logger.info("Ingresando al metodo validarClienteActivo()");

        Cliente cliente = repository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente no existe"));

        if (!cliente.isActivo()) {
            logger.error("El cliente no esta activo *****************");
            throw new RuntimeException("Cliente inactivo");
        }
    }
}
