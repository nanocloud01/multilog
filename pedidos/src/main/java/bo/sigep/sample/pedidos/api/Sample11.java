package bo.sigep.sample.pedidos.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class Sample11 {

    private static final Logger logger = LoggerFactory.getLogger(Sample11.class);

    @GetMapping("/sample11")
    public String get() {

        logger.trace("Mensaje TRACE - muy detallado");
        logger.debug("Mensaje DEBUG - información de depuración");
        logger.info("Mensaje INFO - información general");
        logger.warn("Mensaje WARN - advertencia");
        logger.error("Mensaje ERROR - error");

        String podName = null;
        try {
            // Obtiene el nombre del host (en K8s es el nombre del Pod)
            podName = InetAddress.getLocalHost().getHostName();

            // También puedes obtener la IP si prefieres
            String podIp = InetAddress.getLocalHost().getHostAddress();

            logger.info("Respuesta atendida por el Pod: " + podName + " (IP: " + podIp + ")");

        } catch (UnknownHostException e) {
            return "No pude identificarme: " + e.getMessage();
        }

        return "Sample-11 " + podName;
    }
}
