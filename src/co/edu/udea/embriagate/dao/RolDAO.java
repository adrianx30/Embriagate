package co.edu.udea.embriagate.dao;

import java.util.List;

import co.edu.udea.embriagate.dto.RolDTO;
import co.edu.udea.embriagate.exception.MyException;

//Interfaz para Rol
public interface RolDAO {

	public List<RolDTO> consultar() throws MyException; //Método para consultar los roles existentes en el sistema
	
}
