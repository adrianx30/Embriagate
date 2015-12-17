package co.edu.udea.embriagate.dao;

import java.util.Date;
import java.util.List;

import co.edu.udea.embriagate.dto.CompraDTO;
import co.edu.udea.embriagate.dto.UsuarioDTO;
import co.edu.udea.embriagate.exception.MyException;

//Interfaz para Compra
public interface CompraDAO {
	
	//Método para crear una compra
	public void crearCompra(CompraDTO compra) throws MyException;
	
	//Método para obtener todas las compras
	public List<CompraDTO> obtenerTodasLasCompras() throws MyException;
	
	//Metodo para obtener las compras de un usuario en especifico
	public List<CompraDTO> obtenerComprasPorUsuario(UsuarioDTO usuario) throws MyException;
	
	//Método para obtener las compras en un rango de fechas
	public List<CompraDTO> obtenerComprasPorRangoFecha(Date desde, Date hasta) throws MyException;
	

}
