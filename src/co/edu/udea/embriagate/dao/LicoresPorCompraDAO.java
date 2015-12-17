package co.edu.udea.embriagate.dao;

import java.util.List;

import co.edu.udea.embriagate.dto.CompraDTO;
import co.edu.udea.embriagate.dto.LicoresDTO;
import co.edu.udea.embriagate.dto.LicoresPorCompraDTO;
import co.edu.udea.embriagate.exception.MyException;

//Interfaz para licores por compra
public interface LicoresPorCompraDAO {

	//Método para crear un LicoresPorCompra
	public void crearLicoresPorCompra(LicoresPorCompraDTO licor)throws MyException;
	
	//Método para obtener licoresPorCompra dada una compra
	public List<LicoresPorCompraDTO> obtenerPorCompra(CompraDTO compra)throws MyException;
	
	//método para obtener LicoresPorCompra dado un Licor
	public List<LicoresPorCompraDTO> obtenerPorLicor(LicoresDTO licor)throws MyException;
}
