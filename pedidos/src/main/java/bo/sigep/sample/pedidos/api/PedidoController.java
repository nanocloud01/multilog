package bo.sigep.sample.pedidos.api;

import bo.sigep.sample.pedidos.application.CrearPedidoUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private static final Logger logger = LoggerFactory.getLogger(PedidoController.class);

    private final CrearPedidoUseCase useCase;

    public PedidoController(CrearPedidoUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping("/{clienteId}")
    public Long crear(@PathVariable Long clienteId) {
        logger.info("Exec method create");
        return useCase.ejecutar(clienteId);
    }

    @GetMapping
    public String getMessage() {
        logger.info("Ingresando al metodo getMessage()");
        return "response service";
    }
}
