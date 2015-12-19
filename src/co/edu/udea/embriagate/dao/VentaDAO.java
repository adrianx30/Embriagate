package co.edu.udea.embriagate.dao;


import java.util.Date;
import java.util.List;

import co.edu.udea.embriagate.dto.ClienteDTO;
import co.edu.udea.embriagate.dto.UsuarioDTO;
import co.edu.udea.embriagate.dto.VentaDTO;
import co.edu.udea.embriagate.exception.MyException;

//Intefaz para venta
public interface VentaDAO {
	
	//M�todo para crear una venta
	public void crearVenta(VentaDTO venta) throws MyException;
	
	//M�todo para obtener todas las compras
	public List<VentaDTO> obtenerTodasLasVentas() throws MyException;
	
	//Metodo para obtener las ventas de un usuario en especifico
	public List<VentaDTO> obtenerVentasPorUsuario(UsuarioDTO usuario) throws MyException;
	
	//M�todo para obtener las ventas en un rango de fechas
	public List<VentaDTO> obtenerVentasPorRangoFecha(Date desde, Date hasta) throws MyException;

	//M�todo para obtener las ventas de un cliente en especifico
	public List<VentaDTO> obtenerVentasPorCliente(ClienteDTO cliente) throws MyException;
	
	//Metodo para obtener una venta dado su numero
	public VentaDTO obtenerVentaPorNumero(Long numero)throws MyException;

}
