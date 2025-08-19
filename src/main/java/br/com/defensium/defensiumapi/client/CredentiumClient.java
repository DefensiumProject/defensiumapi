package br.com.defensium.defensiumapi.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.defensium.defensiumapi.transfer.UsuarioTransfer;

@FeignClient(name = "credentiumapi", url = "http://localhost:8070/credentium")
public interface CredentiumClient {
	
	@PostMapping("credentium/usuario/registrar")
	public UsuarioTransfer registrarUsuario(UsuarioTransfer usuarioTransfer);
	
}
