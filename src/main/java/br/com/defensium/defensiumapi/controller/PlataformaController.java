package br.com.defensium.defensiumapi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.defensium.defensiumapi.entity.PlataformaEntity;
import br.com.defensium.defensiumapi.service.PlataformaService;

@RestController
@RequestMapping("/defensium/plataforma")
public class PlataformaController {

    private PlataformaService plataformaService;

    public PlataformaController(PlataformaService plataformaService) {
        this.plataformaService = plataformaService;
    }

    @GetMapping
    public ResponseEntity<List<PlataformaEntity>> recuperarTodos() {
        return ResponseEntity.ok().body(this.plataformaService.recuperarTodos());
    }

}
