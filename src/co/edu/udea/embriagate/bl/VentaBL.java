package co.edu.udea.embriagate.bl;

import java.util.Date;
import java.util.List;

import co.edu.udea.embriagate.dto.VentaDTO;
import co.edu.udea.embriagate.exception.MyException;

public interface VentaBL {

	//Mï¿½todo para guardar una venta
	public void guardar(Long valor, String cliente, String usuario) throws MyException;
	
	//Mï¿½todo para obtener todas las compras
	public List<VentaDTO> obtenerVentas() throws MyException;
	
	//Metodo para obtener las compras de un usuario en especifico, dado su número de documento
	public List<VentaDTO> obtenerVentasPorUsuario(String usuario) throws MyException;
	
	//Mï¿½todo para obtener las compras en un rango de fechas
	public List<VentaDTO> obtenerVentasPorRangoFecha(Date desde, Date hasta) throws MyException;
	
	//Metodo para obtener las compras de un cliente en especifico, dado su número de documento
	public List<VentaDTO> obtenerVentasPorCliente(String cliente) throws MyException;
	
	//Metodo para obtener una compra dado su numero
	public VentaDTO obtenerVenta(Long numero) throws MyException;
	
	
}
