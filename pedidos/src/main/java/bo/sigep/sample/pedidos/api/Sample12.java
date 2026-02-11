package bo.sigep.sample.pedidos.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Sample12 {

    private static final Logger logger = LoggerFactory.getLogger(Sample12.class);

    @GetMapping("/sample12")
    public String get() {
        logger.info("Message INFO - lanzando una excepcion");
        // Con excepcion
        try {
            int c = 16 / 0;
        } catch (Exception e) {
            logger.error("Error procesando solicitud", e);
        }

        return "Sample-12";
    }
}
