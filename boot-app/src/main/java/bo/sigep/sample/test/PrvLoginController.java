package bo.sigep.sample.test;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/log")
public class PrvLoginController {

    private final PrvLoginService service;

    public PrvLoginController(PrvLoginService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrvLoginEntity> obtenerPersona(@PathVariable String id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
