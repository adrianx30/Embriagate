package co.edu.udea.embriagate.dao;

import java.util.List;

import co.edu.udea.embriagate.dto.LicoresDTO;
import co.edu.udea.embriagate.dto.LicoresPorVentaDTO;
import co.edu.udea.embriagate.dto.VentaDTO;
import co.edu.udea.embriagate.exception.MyException;

//Intefaz para licores por venta
public interface LicoresPorVentaDAO {
	
		//M�todo para crear un LicoresPorVenta
		public void crearLicoresPorVenta(LicoresPorVentaDTO licor)throws MyException;
		
		//M�todo para obtener licoresPorVenta dada una venta
		public List<LicoresPorVentaDTO> obtenerPorVenta(VentaDTO venta)throws MyException;
		
		//m�todo para obtener LicoresPorVenta dado un Licor
		public List<LicoresPorVentaDTO> obtenerPorLicor(LicoresDTO licor)throws MyException;

}
