package br.com.defensium.defensiumapi.service;

import org.springframework.stereotype.Service;

import br.com.defensium.defensiumapi.entity.CredencialEntity;
import br.com.defensium.defensiumapi.repository.CredencialRepository;

@Service
public class CredencialService {

    private final CredencialRepository credencialRepository;

    public CredencialService(CredencialRepository credencialRepository) {
        this.credencialRepository = credencialRepository;
    }

    public CredencialEntity saveOne(CredencialEntity credencialEntity) {
        return this.credencialRepository.save(credencialEntity);
    }

}
