package bo.sigep.sample;

import bo.sigep.sample.clientes.domain.Cliente;
import bo.sigep.sample.clientes.infrastructure.ClienteJpaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner init(ClienteJpaRepository repo) {
        return args -> {
            repo.save(new Cliente(1L, "Juan", true));
            repo.save(new Cliente(2L, "Pedro", false));
        };
    }
}
