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
import co.edu.udea.embriagate.dao.CompraDAO;
import co.edu.udea.embriagate.dto.CompraDTO;
import co.edu.udea.embriagate.dto.UsuarioDTO;
import co.edu.udea.embriagate.dto.VentaDTO;
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
		//Se instancia una sesion
				Session session=null;
				try {
					//se obtiene la sesion
					session=getSession();
					//se inicia una transaccion 
					Transaction tx=session.beginTransaction();
					//se procede a guardar el objeto compra en la base de datos
					session.save(compra);
					//se hace el commit de la transaccion
					tx.commit();
				} catch (HibernateException e) {
					//Si ocurre alguna excepcion de hibernate se lanza una nueva excepcion propia
					throw new MyException(e);
				}	
	}
	/**
	 * Obtiene todas las compras de la base de datos
	 * @return List<CompraDTO> retorna una lista de compras, retorna un ArrayList vacio si no hay compras en la base de datos
	 */
	@Override
	public List<CompraDTO> obtenerTodasLasCompras() throws MyException {
		//Se inicializa la lista de compras
		List<CompraDTO> lista=new ArrayList<CompraDTO>();
		//Se instancia la sesion
		Session session=null;
		try {
			//Se obtiene la sesion
			session=getSession();
			//Sea crea un criteria especificando lo que queremos obtener de la base de datos
			Criteria criteria=session.createCriteria(CompraDTO.class);
			//se obtiene la lista de compras
			lista=criteria.list();
		} catch (HibernateException e) {
			//Se lanza una nueva excepcion
			throw new MyException(e);
		}
		return lista;
	}
	/**
	 * Obtiene todas las compras de un usuario en especifico de la base de datos
	 * @param usuario objeto de tipo UsuarioDTO que representa el usuario del cual se quiere conocer las compras
	 * @return List<CompraDTO> retorna una lista de compras, retorna un ArrayList vacio si no hay compras en la base de datos
	 */
	@Override
	public List<CompraDTO> obtenerComprasPorUsuario(UsuarioDTO usuario) throws MyException {
		//Se inicializa la lista de compras
		List<CompraDTO> lista=new ArrayList<CompraDTO>();
		//Se instancia la sesion
		Session session=null;
		try {
			//Se obtiene la sesion
			session=getSession();
			//Sea crea un criteria especificando lo que queremos obtener de la base de datos
			Criteria criteria=session.createCriteria(CompraDTO.class).add(Restrictions.eq("usuario",usuario));
			//se obtiene la lista de compras
			lista=criteria.list();
		} catch (HibernateException e) {
			//Se lanza una nueva excepcion
			throw new MyException(e);
		}
		return lista;
	}
	/**
	 * Obtiene todas las compras dado un rango de fechas de la base de datos
	 * @param desde Date que representa la fecha inicial del rango
	 * @param hasta Date que representa la fecha limite del rango
	 * @return List<CompraDTO> retorna una lista de compras realizadas en dicho rango de fechas, retorna un ArrayList vacio si no hay compras en la base de datos
	 *
	 */
	@Override
	public List<CompraDTO> obtenerComprasPorRangoFecha(Date desde, Date hasta) throws MyException {
		//Se inicializa la lista de compras
		List<CompraDTO> lista=new ArrayList<CompraDTO>();
		//Se instancia la sesion
		Session session=null;
		try {
		//Se obtiene la sesion
			session=getSession();
			//Sea crea un criteria especificando lo que queremos obtener de la base de datos
			Criteria criteria=session.createCriteria(CompraDTO.class).add(Restrictions.between("fechaVenta",desde,hasta));
			//se obtiene la lista de compras
			lista=criteria.list();
		} catch (HibernateException e) {
			//Se lanza una nueva excepcion
			throw new MyException(e);
		}
		return lista;
	}
	/**
	 * Obtiene una compra dado su numero
	 * @param numero Long que representa el numero de la compra que se quiere obtener
	 * @return CompraDTO retorna la compra identificada con dicho numero, retorna null si no existe dicha compra
	 *
	 */
	@Override
	public CompraDTO obtenerCompraPorNumero(Long numero) throws MyException {
		//Se instancia una compra
		CompraDTO compra=null;
		//Se instancia una sesion
		Session session=null;
		try {
			//Se obtiene la sesion
			session=getSession();
			//Se obtiene la compra dado el numero de compra
			compra=(CompraDTO)session.get(CompraDTO.class, numero);
		} catch (HibernateException e) {
			//Se maneja la excepcion
			throw new MyException(e);
		}
		return compra;
	}

}
