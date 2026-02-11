package bo.sigep.sample.pedidos.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class Sample {

    private static final Logger logger = LoggerFactory.getLogger(Sample.class);

    @GetMapping("/whoami")
    public String whoAmI() {
        try {
            // Obtiene el nombre del host (en K8s es el nombre del Pod)
            String podName = InetAddress.getLocalHost().getHostName();

            // También puedes obtener la IP si prefieres
            String podIp = InetAddress.getLocalHost().getHostAddress();

            return "Respuesta atendida por el Pod: " + podName + " (IP: " + podIp + ")";

        } catch (UnknownHostException e) {
            return "No pude identificarme: " + e.getMessage();
        }
    }
}
