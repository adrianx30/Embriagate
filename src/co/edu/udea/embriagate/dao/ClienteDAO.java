package co.edu.udea.embriagate.dao;


import java.util.List;

import co.edu.udea.embriagate.dto.ClienteDTO;
import co.edu.udea.embriagate.exception.MyException;


//Interfaz para Cliente

public interface ClienteDAO {
	
	public void crearCliente(ClienteDTO cliente) throws MyException; //Metodo para crear un cliente en el sistema
	
	public void modificarCliente(ClienteDTO cliente) throws MyException; //Metodo para modificar un cliente del sistema
	
	public void eliminarCliente(ClienteDTO cliente) throws MyException; //Metodo para eliminar un cliente del sistema
	
	public ClienteDTO consultar(String nroDocumento) throws MyException; //Método para consultar algun cliente, dado su número de identifición

	List<ClienteDTO> consultarActivos() throws MyException; //Metodo obtener una lista con todos los clientes activos del sistema
}
