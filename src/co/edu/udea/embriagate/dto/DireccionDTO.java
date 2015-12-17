package co.edu.udea.embriagate.dto;

public class DireccionDTO {
	private DireccionIdDTO id;
	private String direccion;
	private String telefono;
	private String ciudad;
	private boolean preferida;
	public DireccionIdDTO getId() {
		return id;
	}
	public void setId(DireccionIdDTO id) {
		this.id = id;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public boolean isPreferida() {
		return preferida;
	}
	public void setPreferida(boolean preferida) {
		this.preferida = preferida;
	}
	
}
