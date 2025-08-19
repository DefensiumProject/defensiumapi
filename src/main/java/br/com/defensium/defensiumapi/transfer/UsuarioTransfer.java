package br.com.defensium.defensiumapi.transfer;

public class UsuarioTransfer {
	
	private String nome;
	
	private String usuario;
	
	private String senha;
	
	private Boolean isActive;
	
	public UsuarioTransfer() {
		this.isActive = true;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
    		 
}
