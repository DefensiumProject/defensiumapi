package br.com.defensium.defensiumapi.service;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import br.com.defensium.defensiumapi.entity.CredencialEntity;
import br.com.defensium.defensiumapi.repository.CredencialRepository;

@Service
public class CredencialService {

	private static final Logger log = LoggerFactory.getLogger(CredencialService.class);

    private CredencialRepository credencialRepository;

    public CredencialService(CredencialRepository credencialRepository) {
        this.credencialRepository = credencialRepository;
    }

    public CredencialEntity saveOne(CredencialEntity credencialEntity) {
        return this.credencialRepository.save(credencialEntity);
    }

    public List<CredencialEntity> getAll() {
        return this.credencialRepository.findByActiveTrue();
    }

    public CredencialEntity getCredencial(Long codigo) {
        return this.credencialRepository.findById(codigo).orElse(null);
    }

    public CredencialEntity updateOne(CredencialEntity credencialEntity) {
        return this.credencialRepository.save(credencialEntity);
    }

    public boolean inativarCredencial(Long codigoCredencial) {
		log.warn("CredencialController -> InativarCredencial -> Código: {}", codigoCredencial);
        return this.credencialRepository.findById(codigoCredencial).map(credencial -> {
            credencial.setActive(false);
			credencial.setDataEdicao(LocalDateTime.now());
            this.updateOne(credencial);
            return true;
        }).orElse(false);
    }

	public boolean reativarCredencial(Long codigoCredencial) {
		log.info("CredencialController -> ReativarCredencial -> Código: {}", codigoCredencial);
        return this.credencialRepository.findById(codigoCredencial).map(credencial -> {
            credencial.setActive(true);
			credencial.setDataEdicao(LocalDateTime.now());
            this.updateOne(credencial);
            return true;
        }).orElse(false);
    }

}
