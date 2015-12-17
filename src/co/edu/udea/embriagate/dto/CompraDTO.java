package co.edu.udea.embriagate.dto;

import java.util.Date;

public class CompraDTO {
	private Long numeroCompra;
	private Date fechaVenta;
	private Long valor;
	private UsuarioDTO usuario;
	
	public Long getNumeroCompra() {
		return numeroCompra;
	}
	public void setNumeroCompra(Long numeroCompra) {
		this.numeroCompra = numeroCompra;
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
	public UsuarioDTO getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}
	
}
