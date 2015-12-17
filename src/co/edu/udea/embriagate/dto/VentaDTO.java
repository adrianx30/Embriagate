package co.edu.udea.embriagate.dto;

import java.util.Date;

public class VentaDTO {
	private Long numeroVenta;
	private Date fechaVenta;
	private Long valor;
	private ClienteDTO cliente;
	private UsuarioDTO usuario;
	
	public Long getNumeroVenta() {
		return numeroVenta;
	}
	public void setNumeroVenta(Long numeroVenta) {
		this.numeroVenta = numeroVenta;
	}
	public Date getFechaVenta() {
		return fechaVenta;
	}
	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}
	public Long getValor() {
		return valor;
	}
	public void setValor(Long valor) {
		this.valor = valor;
	}
	public ClienteDTO getCliente() {
		return cliente;
	}
	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}
	public UsuarioDTO getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}
}
