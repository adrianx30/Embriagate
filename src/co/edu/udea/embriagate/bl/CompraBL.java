package co.edu.udea.embriagate.bl;

import java.util.Date;
import java.util.List;

import co.edu.udea.embriagate.dto.CompraDTO;
import co.edu.udea.embriagate.exception.MyException;

public interface CompraBL {
	
	//M�todo para guardar una compra
	public void guardar(Long valor, String usuario) throws MyException;
	
	//M�todo para obtener todas las compras
	public List<CompraDTO> obtenerCompras() throws MyException;
	
	//Metodo para obtener las compras de un usuario en especifico, dado su n�mero de documento
	public List<CompraDTO> obtenerCompras(String nroDocumento) throws MyException;
	
	//M�todo para obtener las compras en un rango de fechas
	public List<CompraDTO> obtenerCompras(Date desde, Date hasta) throws MyException;
	
	//Metodo para obtener una compra dado su numero
	public CompraDTO obtenerCompra(Long nroCompra) throws MyException;

}
