package br.com.defensium.defensiumapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.defensium.defensiumapi.client.CredentiumClient;
import br.com.defensium.defensiumapi.transfer.UsuarioTransfer;

@Service
public class AutenticadorService {
	
	@Autowired
	private CredentiumClient credentiumClient;

	public UsuarioTransfer registrarUsuario(UsuarioTransfer usuarioTransfer) {
//		return credentiumClient.registrarUsuario(usuarioTransfer);
		return null;
	}
	
}