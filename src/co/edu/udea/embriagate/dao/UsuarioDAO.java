package co.edu.udea.embriagate.dao;

import java.util.List;

import co.edu.udea.embriagate.dto.UsuarioDTO;
import co.edu.udea.embriagate.exception.MyException;


//Interfaz para Usuario
public interface UsuarioDAO {
	
	public void crear(UsuarioDTO usuario) throws MyException; //M�todo para crear un usuario
	
	public UsuarioDTO consultar(String login) throws MyException; //M�todo para consultar un usuario dado su login
	
	public void modificar(UsuarioDTO usuario) throws MyException; //M�todo para modificar alguno de los datos de un usuario
	
	public List<UsuarioDTO> consultarTodos() throws MyException; //M�todo para consultar todos los usuarios del sistema
	
}
