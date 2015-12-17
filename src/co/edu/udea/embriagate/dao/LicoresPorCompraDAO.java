package co.edu.udea.embriagate.dao;

import java.util.List;

import co.edu.udea.embriagate.dto.CompraDTO;
import co.edu.udea.embriagate.dto.LicoresDTO;
import co.edu.udea.embriagate.dto.LicoresPorCompraDTO;
import co.edu.udea.embriagate.exception.MyException;

//Interfaz para licores por compra
public interface LicoresPorCompraDAO {

	//M�todo para crear un LicoresPorCompra
	public void crearLicoresPorCompra(LicoresPorCompraDTO licor)throws MyException;
	
	//M�todo para obtener licoresPorCompra dada una compra
	public List<LicoresPorCompraDTO> obtenerPorCompra(CompraDTO compra)throws MyException;
	
	//m�todo para obtener LicoresPorCompra dado un Licor
	public List<LicoresPorCompraDTO> obtenerPorLicor(LicoresDTO licor)throws MyException;
}
