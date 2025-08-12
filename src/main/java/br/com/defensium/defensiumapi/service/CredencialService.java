package br.com.defensium.defensiumapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.defensium.defensiumapi.entity.CredencialEntity;
import br.com.defensium.defensiumapi.repository.CredencialRepository;

@Service
public class CredencialService {

    private CredencialRepository credencialRepository;

    public CredencialService(CredencialRepository credencialRepository) {
        this.credencialRepository = credencialRepository;
    }

    public CredencialEntity saveOne(CredencialEntity credencialEntity) {
        return this.credencialRepository.save(credencialEntity);
    }

    public List<CredencialEntity> getAll() {
        return this.credencialRepository.findAll();
    }

    public CredencialEntity getCredencial(Long codigo) {
        return this.credencialRepository.findById(codigo).get();
    }

    public CredencialEntity updateOne(CredencialEntity credencialEntity) {
        return this.credencialRepository.save(credencialEntity);
    }

}
