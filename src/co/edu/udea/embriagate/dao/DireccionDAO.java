package co.edu.udea.embriagate.dao;

import java.util.List;

import co.edu.udea.embriagate.dto.ClienteDTO;
import co.edu.udea.embriagate.dto.DireccionDTO;
import co.edu.udea.embriagate.exception.MyException;

//Interfaz para Direccion
public interface DireccionDAO {
	
	public void crear(DireccionDTO direccion) throws MyException; //M�todo para crear una direccion
	
	public void eliminar(DireccionDTO direccion) throws MyException; //M�todo para eliminar una direccion
	
	public List<DireccionDTO> consultar(ClienteDTO cliente) throws MyException; ////M�todo para consultar las direcciones dado un cliente

}
