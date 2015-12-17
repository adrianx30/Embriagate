package co.edu.udea.embriagate.dto;

import java.util.Date;

public class ClienteDTO {
	private String numeroDocumento;
	private String nombres;
	private String apellidos;
	private String email;
	private Date fechaNacimiento;
	private String telefono;
	private UsuarioDTO usuarioCrea;
	private Date fechaCreacion;
	private UsuarioDTO usuarioModifica;
	private Date fechaMofificacion;
	private UsuarioDTO usuarioElimina;
	private Date fechaEliminacion;
	private boolean eliminado;
	
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public UsuarioDTO getUsuarioCrea() {
		return usuarioCrea;
	}
	public void setUsuarioCrea(UsuarioDTO usuarioCrea) {
		this.usuarioCrea = usuarioCrea;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public UsuarioDTO getUsuarioModifica() {
		return usuarioModifica;
	}
	public void setUsuarioModifica(UsuarioDTO usuarioModifica) {
		this.usuarioModifica = usuarioModifica;
	}
	public Date getFechaMofificacion() {
		return fechaMofificacion;
	}
	public void setFechaMofificacion(Date fechaMofificacion) {
		this.fechaMofificacion = fechaMofificacion;
	}
	public UsuarioDTO getUsuarioElimina() {
		return usuarioElimina;
	}
	public void setUsuarioElimina(UsuarioDTO usuarioElimina) {
		this.usuarioElimina = usuarioElimina;
	}
	public Date getFechaEliminacion() {
		return fechaEliminacion;
	}
	public void setFechaEliminacion(Date fechaEliminacion) {
		this.fechaEliminacion = fechaEliminacion;
	}
	public boolean isEliminado() {
		return eliminado;
	}
	public void setEliminado(boolean eliminado) {
		this.eliminado = eliminado;
	}
	
	
}
