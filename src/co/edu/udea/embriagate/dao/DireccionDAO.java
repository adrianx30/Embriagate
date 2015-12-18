package co.edu.udea.embriagate.dao;

import java.util.List;

import co.edu.udea.embriagate.dto.ClienteDTO;
import co.edu.udea.embriagate.dto.DireccionDTO;
import co.edu.udea.embriagate.exception.MyException;

//Interfaz para Direccion
public interface DireccionDAO {
	
	public void crear(DireccionDTO direccion) throws MyException; //Método para crear una direccion
	
	public void eliminar(DireccionDTO direccion) throws MyException; //Método para eliminar una direccion
	
	public void modificar(DireccionDTO direccion) throws MyException; //Método para modificar una direccion
	
	public List<DireccionDTO> consultar(ClienteDTO cliente) throws MyException; ////Método para consultar las direcciones dado un cliente

	public void seleccionarComoPreferida(DireccionDTO direccion) throws MyException; //Método para seleccionar una direccion como preferida
	
}
