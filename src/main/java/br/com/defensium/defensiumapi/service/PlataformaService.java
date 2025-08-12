package br.com.defensium.defensiumapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.defensium.defensiumapi.entity.PlataformaEntity;
import br.com.defensium.defensiumapi.repository.PlataformaRepository;

@Service
public class PlataformaService {

    private PlataformaRepository plataformaRepository;

    public PlataformaService(PlataformaRepository plataformaRepository) {
        this.plataformaRepository = plataformaRepository;
    }

    public List<PlataformaEntity> recuperarTodos() {
        return this.plataformaRepository.findAll();
    }

}
