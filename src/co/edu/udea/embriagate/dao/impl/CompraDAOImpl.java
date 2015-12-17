package co.edu.udea.embriagate.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.embriagate.dao.CompraDAO;
import co.edu.udea.embriagate.dto.CompraDTO;
import co.edu.udea.embriagate.dto.UsuarioDTO;
import co.edu.udea.embriagate.exception.MyException;
/**
 * Clase que implementa todas las operaciones que se pueden hacer sobre la tabla compras
 * @author William Molina
 * @author Adrian Jimenez
 * @author Rafael Patiño
 */
public class CompraDAOImpl extends HibernateDaoSupport implements CompraDAO{
	/**
	 * Guarda una compra en la base de datos
	 * @param compra objeto de tipo CompraDTO que representa la compra que se guardará en la base de datos
	 * @return void 
	 */
	@Override
	public void crearCompra(CompraDTO compra) throws MyException {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Obtiene todas las compras de la base de datos
	 * @return List<CompraDTO> retorna una lista de compras, retorna null si no hay compras en la base de datos
	 */
	@Override
	public List<CompraDTO> obtenerTodasLasCompras() throws MyException {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Obtiene todas las compras de un usuario en especifico de la base de datos
	 * @param usuario objeto de tipo UsuarioDTO que representa el usuario del cual se quiere conocer las compras
	 * @return List<CompraDTO> retorna una lista de compras, retorna null si no hay compras en la base de datos
	 */
	@Override
	public List<CompraDTO> obtenerComprasPorUsuario(UsuarioDTO usuario) throws MyException {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Obtiene todas las compras dado un rango de fechas de la base de datos
	 * @param desde Date que representa la fecha inicial del rango
	 * @param hasta Date que representa la fecha limite del rango
	 * @return List<CompraDTO> retorna una lista de compras realizadas en dicho rango de fechas, retorna null si no hay compras en la base de datos
	 *
	 */
	@Override
	public List<CompraDTO> obtenerComprasPorRangoFecha(Date desde, Date hasta) throws MyException {
		// TODO Auto-generated method stub
		return null;
	}

}
