package co.edu.udea.embriagate.dto;

public class UsuarioDTO {
	private String login;
	private String contrase�a;
	private RolDTO rol;
	private ClienteDTO cliente;
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getContrase�a() {
		return contrase�a;
	}
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
	public RolDTO getRol() {
		return rol;
	}
	public void setRol(RolDTO rol) {
		this.rol = rol;
	}
	public ClienteDTO getCliente() {
		return cliente;
	}
	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}
	
}