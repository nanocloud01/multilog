package bo.sigep.sample.test;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PrvLoginService {

    private final PrvLoginRepository prvLoginRepository;

    public PrvLoginService(PrvLoginRepository prvLoginRepository) {
        this.prvLoginRepository = prvLoginRepository;
    }

    public Optional<PrvLoginEntity> getById(String id) {
        return prvLoginRepository.findById(id);
    }

}
