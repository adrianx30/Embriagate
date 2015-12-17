package co.edu.udea.embriagate.dto;

import java.io.Serializable;

public class DireccionIdDTO implements Serializable {
	private Long codigo;
	private ClienteDTO cliente;
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public ClienteDTO getCliente() {
		return cliente;
	}
	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}
	
}
