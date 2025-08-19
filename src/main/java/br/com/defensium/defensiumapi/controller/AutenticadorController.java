package br.com.defensium.defensiumapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.defensium.defensiumapi.service.AutenticadorService;
import br.com.defensium.defensiumapi.transfer.UsuarioTransfer;

@RestController
@RequestMapping("/defensium/autenticador")
@CrossOrigin(value = "*")
public class AutenticadorController {
	
	private AutenticadorService autenticadorService;
	
	public AutenticadorController(AutenticadorService autenticadorService) {
		this.autenticadorService = autenticadorService;
	}

	@PostMapping
	public ResponseEntity<UsuarioTransfer> registrarUsuario(@RequestBody UsuarioTransfer usuarioTransfer) {
		return ResponseEntity.ok(this.autenticadorService.registrarUsuario(usuarioTransfer));
	}

}
