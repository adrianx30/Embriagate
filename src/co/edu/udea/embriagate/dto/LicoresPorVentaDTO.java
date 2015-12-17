package co.edu.udea.embriagate.dto;

public class LicoresPorVentaDTO {
	private Long numeroItem;
	private Long cantidad;
	private VentaDTO venta;
	private LicoresDTO licor;
	private Long precio;
	
	public Long getPrecio() {
		return precio;
	}
	public void setPrecio(Long precio) {
		this.precio = precio;
	}
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
	public VentaDTO getVenta() {
		return venta;
	}
	public void setVenta(VentaDTO venta) {
		this.venta = venta;
	}
	public LicoresDTO getLicor() {
		return licor;
	}
	public void setLicor(LicoresDTO licor) {
		this.licor = licor;
	}

}
