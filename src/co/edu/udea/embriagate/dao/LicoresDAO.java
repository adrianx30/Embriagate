package co.edu.udea.embriagate.dao;


import java.util.List;

import co.edu.udea.embriagate.dto.LicoresDTO;
import co.edu.udea.embriagate.dto.TipoLicoresDTO;
import co.edu.udea.embriagate.exception.MyException;

//Interfaz para licores
public interface LicoresDAO {
	
	//Metodo para crear Licor
	public void crearLicor(LicoresDTO licor) throws MyException;
	
	//Metodo para obtener licores dado un fabricante
	public List<LicoresDTO> obtenerPorFabricante(String fabricante)throws MyException;
	
	//Metodo para obtener licores por a�ejamiento
	public List<LicoresDTO> obtenerPorA�ejamiento(int a�ejamiento) throws MyException;
	
	//Metodo para obtener licores por rango de a�ejamiento
	public List<LicoresDTO> obtenerPorA�ejamiento(int desde, int hasta) throws MyException;
	
	//Metodo para obtener licores por existencia
	public List<LicoresDTO> obtenerPorExistencia(long stock) throws MyException;
	
	//Metodo para obtener licores por Tipo de licor
	public List<LicoresDTO> obtenerPorTipo(TipoLicoresDTO tipo) throws MyException;
	

}
