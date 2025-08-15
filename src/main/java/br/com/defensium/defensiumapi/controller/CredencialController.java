package br.com.defensium.defensiumapi.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.defensium.defensiumapi.entity.CredencialEntity;
import br.com.defensium.defensiumapi.service.CredencialService;

@RestController
@RequestMapping("/defensium/credencial")
@CrossOrigin(value = "*")
public class CredencialController {

	private static final Logger log = LoggerFactory.getLogger(CredencialController.class);

    private final CredencialService credencialService;

    public CredencialController(CredencialService credencialService) {
        this.credencialService = credencialService;
    }

    @PostMapping
    public ResponseEntity<CredencialEntity> saveOne(@RequestBody CredencialEntity credencialEntity) {
        return ResponseEntity.ok().body(this.credencialService.saveOne(credencialEntity));
    }

    @GetMapping
    public ResponseEntity<List<CredencialEntity>> getAll() {
        return ResponseEntity.ok().body(this.credencialService.getAll());
    }

    @GetMapping("/{credencialID}")
    public ResponseEntity<CredencialEntity> getAll(@PathVariable("credencialID") Long codigo) {
        return ResponseEntity.ok().body(this.credencialService.getCredencial(codigo));
    }

    @PutMapping("/{credencialID}")
    public ResponseEntity<CredencialEntity> updateOne(@RequestBody CredencialEntity credencialEntity, @PathVariable("credencialID") Long credencialID) {
        credencialEntity.setCodigo(credencialID);
        return ResponseEntity.ok().body(this.credencialService.updateOne(credencialEntity));
    }

    @PatchMapping("/{credencialCodigo}/inativar")
    public ResponseEntity<Void> inativarCredencial(@PathVariable("credencialCodigo") Long credencialCodigo) {
        log.info("CredencialController -> InativarCredencial -> Código: {}", credencialCodigo);
        if (!this.credencialService.inativarCredencial(credencialCodigo)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

	@PatchMapping("/{credencialCodigo}/reativar")
    public ResponseEntity<Void> reativarCredencial(@PathVariable("credencialCodigo") Long credencialCodigo) {
        log.info("CredencialController -> InativarCredencial -> Código: {}", credencialCodigo);
        if (!this.credencialService.reativarCredencial(credencialCodigo)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

}
