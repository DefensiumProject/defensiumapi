package br.com.defensium.defensiumapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.defensium.defensiumapi.entity.CredencialEntity;
import br.com.defensium.defensiumapi.service.CredencialService;

@RestController
@RequestMapping("/defensium/credencial")
@CrossOrigin(value = "*")
public class CredencialController {

    private final CredencialService credencialService;

    public CredencialController(CredencialService credencialService) {
        this.credencialService = credencialService;
    }

    @PostMapping
    public ResponseEntity<CredencialEntity> saveOne(@RequestBody CredencialEntity credencialEntity) {
        return ResponseEntity.ok().body(this.credencialService.saveOne(credencialEntity));
    }

}
