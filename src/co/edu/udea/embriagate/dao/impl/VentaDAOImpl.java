package co.edu.udea.embriagate.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.embriagate.dao.VentaDAO;
import co.edu.udea.embriagate.dto.ClienteDTO;
import co.edu.udea.embriagate.dto.UsuarioDTO;
import co.edu.udea.embriagate.dto.VentaDTO;
import co.edu.udea.embriagate.exception.MyException;
/**
 * Clase que implementa todas las operaciones que se pueden hacer sobre la tabla clientes
 * @author William Molina
 * @author Adrian Jimenez
 * @author Rafael Patiño
 */
public class VentaDAOImpl extends HibernateDaoSupport implements VentaDAO {
	/**
	 * Guarda una  venta en la base de datos
	 * @param venta objeto de tipo VentaDTO que representa la venta que se guardará en la base de datos
	 * @return void 
	 */
	@Override
	public void crearVenta(VentaDTO venta) throws MyException {
		//Se instancia una sesion
		Session session=null;
		try {
			//Se obtiene la session
			session=getSession();
			//Se inicia una nueva transaccion
			Transaction tx=session.beginTransaction();
			//se guarda la venta en la base de datos
			session.save(venta);
			//Se realiza el commit
			tx.commit();
		} catch (HibernateException e) {
			//Se maneja la excepcion
			throw new MyException(e);
		}
	}
	/**
	 * Obtiene todas las ventas de la base de datos
	 * @return List<VentaDTO> retorna una lista de ventas, retorna un ArrayList vacio si no hay ventas en la base de datos
	 */
	@Override
	public List<VentaDTO> obtenerTodasLasVentas() throws MyException {
		//Se instancia una lista de ventas
		List<VentaDTO> ventas=new ArrayList<VentaDTO>();
		//Se instancia una sesion
		Session session=null;
		try {
			//Se obtiene la sesion
			session=getSession();
			//Se crea una criteria para obtener tods las ventas
			Criteria criteria=session.createCriteria(VentaDTO.class);
			//Se listan todas las ventas
			ventas=criteria.list();
		} catch (HibernateException e) {
			//Se maneja la excepcion
			throw new MyException(e);
		}
		return ventas;
	}
	/**
	 * Obtiene todas las ventas de un usuario en especifico de la base de datos
	 * @param usuario objeto de tipo UsuarioDTO que representa el usuario del cual se quiere conocer las ventas
	 * @return List<CompraDTO> retorna una lista de ventas, retorna un ArrayList vacio si no hay ventas en la 
	 * base de datos que correspondan al usuario dado
	 */
	@Override
	public List<VentaDTO> obtenerVentasPorUsuario(UsuarioDTO usuario) throws MyException {
		//Se instancia una lista de ventas
		List<VentaDTO> ventas=new ArrayList<VentaDTO>();
		//Se instancia una sesion
		Session session=null;
		try {
			//Se obtiene la sesion
			session=getSession();
			//Se crea una criteria para obtener tods las ventas de dicho usuario
			Criteria criteria=session.createCriteria(VentaDTO.class).add(Restrictions.eq("usuario",usuario));
			//Se listan todas las ventas
			ventas=criteria.list();
		} catch (HibernateException e) {
			//Se maneja la excepcion
			throw new MyException(e);
		}
		return ventas;
	}
	/**
	 * Obtiene todas las ventas dado un rango de fechas de la base de datos
	 * @param desde Date que representa la fecha inicial del rango
	 * @param hasta Date que representa la fecha limite del rango
	 * @return List<VentaDTO> retorna una lista de ventas realizadas en dicho rango de fechas, 
	 * retorna un ArrayList vacio si no hay ventas en la base de datos que correspondan al rango dado
	 *
	 */
	@Override
	public List<VentaDTO> obtenerVentasPorRangoFecha(Date desde, Date hasta) throws MyException {
		//Se instancia una lista de ventas
		List<VentaDTO> ventas=new ArrayList<VentaDTO>();
		//Se instancia una sesion
		Session session=null;
		try {
			//Se obtiene la sesion
			session=getSession();
			//Se crea una criteria para obtener tods las ventas de dicho rango
			Criteria criteria=session.createCriteria(VentaDTO.class).add(Restrictions.between("fechaVenta",desde,hasta));
			//Se listan todas las ventas
			ventas=criteria.list();
		} catch (HibernateException e) {
			//Se maneja la excepcion
			throw new MyException(e);
		}
		return ventas;
	}
	/**
	 * Obtiene todas las ventas de un cliente en especifico de la base de datos
	 * @param cliente objeto de tipo ClienteDTO que representa el usuario del cual se quiere conocer las ventas
	 * @return List<CompraDTO> retorna una lista de ventas, retorna un ArrayList vacio si no hay ventas en la 
	 * base de datos que correspondan al cliente dado
	 */
	@Override
	public List<VentaDTO> obtenerVentasPorCliente(ClienteDTO cliente) throws MyException {
		//Se instancia una lista de ventas
		List<VentaDTO> ventas=new ArrayList<VentaDTO>();
		//Se instancia una sesion
		Session session=null;
		try {
			//Se obtiene la sesion
			session=getSession();
			//Se crea una criteria para obtener tods las ventas de dicho usuario
			Criteria criteria=session.createCriteria(VentaDTO.class).add(Restrictions.eq("cliente",cliente));
			//Se listan todas las ventas
			ventas=criteria.list();
		} catch (HibernateException e) {
			//Se maneja la excepcion
			throw new MyException(e);
		}
		return ventas;
	}
	/**
	 * Obtiene una venta dado su numero
	 * @param numero Long que representa el numero de la venta que se quiere obtener
	 * @return VentaDTO retorna la venta identificada con dicho numero, retorna null si no existe dicha venta
	 *
	 */
	@Override
	public VentaDTO obtenerVentaPorNumero(Long numero) throws MyException {
		//Se instancia una venta
		VentaDTO venta=null;
		//Se instancia una sesion
		Session session=null;
		try {
			//Se obtiene la sesion
			session=getSession();
			//Se obtiene la venta dado el numero de venta
			venta=(VentaDTO)session.get(VentaDTO.class, numero);
		} catch (HibernateException e) {
			//Se maneja la excepcion
			throw new MyException(e);
		}
		return venta;
	}

}