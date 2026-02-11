package bo.sigep.sample.pedidos.application;

import bo.sigep.sample.clientes.api.ClienteValidatorPort;
import bo.sigep.sample.pedidos.domain.Pedido;
import bo.sigep.sample.pedidos.infrastructure.PedidoJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CrearPedidoUseCase {

    private static final Logger logger = LoggerFactory.getLogger(CrearPedidoUseCase.class);

    private final PedidoJpaRepository pedidoRepository;
    private final ClienteValidatorPort clienteValidator;

    public CrearPedidoUseCase(PedidoJpaRepository pedidoRepository,
                              ClienteValidatorPort clienteValidator) {
        this.pedidoRepository = pedidoRepository;
        this.clienteValidator = clienteValidator;
    }

    @Transactional
    public Long ejecutar(Long clienteId) {

        logger.info("Ingresando al metodo ejecutar()");

        clienteValidator.validarClienteActivo(clienteId);

        Pedido pedido = Pedido.crear(clienteId);

        pedidoRepository.save(pedido);

        return pedido.getId();
    }
}

