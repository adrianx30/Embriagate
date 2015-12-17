package co.edu.udea.embriagate.dto;

public class LicoresPorCompraDTO {
	private Long numeroItem;
	private Long cantidad;
	private CompraDTO compra;
	private LicoresDTO licor;
	private Long precio;
	
	public Long getNumeroItem() {
		return numeroItem;
	}
	public void setNumeroItem(Long numeroItem) {
		this.numeroItem = numeroItem;
	}
	public Long getCantidad() {
		return cantidad;
	}
	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}
	public CompraDTO getCompra() {
		return compra;
	}
	public void setCompra(CompraDTO compra) {
		this.compra = compra;
	}
	public LicoresDTO getLicor() {
		return licor;
	}
	public void setLicor(LicoresDTO licor) {
		this.licor = licor;
	}
	public Long getPrecio() {
		return precio;
	}
	public void setPrecio(Long precio) {
		this.precio = precio;
	}
}
