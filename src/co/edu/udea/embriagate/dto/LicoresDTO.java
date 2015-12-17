package co.edu.udea.embriagate.dto;

public class LicoresDTO {
	private String codigo;
	private String nombre;
	private String fabricante;
	private Long presentacion;
	private Long existencias;
	private int añejamiento;
	private TipoLicoresDTO tipoLicor;
	private Long precio;
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public Long getPresentacion() {
		return presentacion;
	}
	public void setPresentacion(Long presentacion) {
		this.presentacion = presentacion;
	}
	public Long getExistencias() {
		return existencias;
	}
	public void setExistencias(Long existencias) {
		this.existencias = existencias;
	}
	public int getAñejamiento() {
		return añejamiento;
	}
	public void setAñejamiento(int añejamiento) {
		this.añejamiento = añejamiento;
	}
	public TipoLicoresDTO getTipoLicor() {
		return tipoLicor;
	}
	public void setTipoLicor(TipoLicoresDTO tipoLicor) {
		this.tipoLicor = tipoLicor;
	}
	public Long getPrecio() {
		return precio;
	}
	public void setPrecio(Long precio) {
		this.precio = precio;
	}
}
