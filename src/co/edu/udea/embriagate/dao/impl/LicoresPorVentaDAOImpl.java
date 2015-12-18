package co.edu.udea.embriagate.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.embriagate.dao.LicoresPorVentaDAO;
import co.edu.udea.embriagate.dto.LicoresDTO;
import co.edu.udea.embriagate.dto.LicoresPorVentaDTO;
import co.edu.udea.embriagate.dto.VentaDTO;
import co.edu.udea.embriagate.exception.MyException;

public class LicoresPorVentaDAOImpl extends HibernateDaoSupport implements LicoresPorVentaDAO {

	/**
	 * Guarda un licorPorVenta en la base de datos
	 * @param licor objeto de tipo LicoresPorVentaDTO que representa al Licor que se guardarÃ¡ en la base de datos
	 * @return void 
	 */
	@Override
	public void crearLicoresPorVenta(LicoresPorVentaDTO licor) throws MyException {
		// Creamos una instancia de session
		Session session = null;
		try {
			// Se obtiene la session
			session = getSession();
			// Se inicia la transaccion
			Transaction tx = session.beginTransaction();
			// Guardamos el objeto licor en la base de datos
			session.save(licor);
			// Realizamos el commit de la transaccion
			tx.commit();
		} catch (HibernateException e) {
			// Si ocurre alguna excepcion de hibernate se lanza una nueva
			// excepcion propia
			throw new MyException(e);
		} finally {
			// Por ultimo, si la sesion no es nula se procede a cerrarla
			if (session != null) {
				try {
					session.close();
				} catch (HibernateException e) {
					// capturar cualquier exception de hibernate que se pueda
					// presentar
					throw new MyException(e);
				}
			}
		}
	}

	/**
	 * Consulta los licoresPorVenta de la base de datos que correspondan a una venta en particular
	 * @param venta VentaDTO que representa la venta en la que se vendieron los licores que se desea consultar
	 * @return LicoresPorVenta retorna una lista de LicoresPorVenta que corresponden a la venta dada,retorna null si no se encuentra
	 * un licor que coincida con la venta dada
	 */
	@Override
	public List<LicoresPorVentaDTO> obtenerPorVenta(VentaDTO venta) throws MyException {
		//Creamos la lista de licores para guardar el resultado de la consulta
		List<LicoresPorVentaDTO> licores = new ArrayList<LicoresPorVentaDTO>();
		//Creamos una instancia de session
		Session session = null;
		try {
			//Se obtiene la session
			session = getSession();
			//creamos una instancia Criteria que es donde se obtienen los resultados de la consulta
			//Añadimos también la restriccion de venta para retornar lo deseado por el método
			Criteria criteria = session.createCriteria(LicoresPorVentaDTO.class)
					.add(Restrictions.eq("Venta", venta.getNumeroVenta()));
			//añadimos a nuestra lista el resultado de la consulta
			licores = criteria.list();
		} catch (HibernateException e) {
			//Si ocurre alguna excepcion de hibernate se lanza una nueva excepcion propia
			throw new MyException(e);
		} finally {
			// Por ultimo, si la sesion no es nula se procede a cerrarla
			if (session != null) {
				try {
					session.close();
				} catch (HibernateException e) {
					// capturar cualquier exception de hibernate que se pueda
					// presentar
					throw new MyException(e);
				}
			}
		}
		//retorna los licoresPorVenta encontrados
		return licores;
	}

	/**
	 * Consulta los licoresPorVenta de la base de datos dado un licor
	 * @param licor LicoresDTO que representa el licor vendido que se desea consultar
	 * @return LicoresPorVentaDTO retorna una lista de LicoresPorVenta que corresponden al licor dado,retorna null si no se encuentra
	 * LicoresPorVenta que coincida con el licor dado 
	 */
	@Override
	public List<LicoresPorVentaDTO> obtenerPorLicor(LicoresDTO licor) throws MyException {
		//Creamos la lista de licores para guardar el resultado de la consulta
		List<LicoresPorVentaDTO> licores = new ArrayList<LicoresPorVentaDTO>();
		//Creamos una instancia de session
		Session session = null;
		try {
			//Se obtiene la session
			session = getSession();
			//creamos una instancia Criteria que es donde se obtienen los resultados de la consulta
			//Añadimos también la restriccion de licor para retornar lo deseado por el método
			Criteria criteria = session.createCriteria(LicoresPorVentaDTO.class)
					.add(Restrictions.eq("Licor", licor.getCodigo()));
			//añadimos a nuestra lista el resultado de la consulta
			licores = criteria.list();
		} catch (HibernateException e) {
			//Si ocurre alguna excepcion de hibernate se lanza una nueva excepcion propia
			throw new MyException(e);
		} finally {
			// Por ultimo, si la sesion no es nula se procede a cerrarla
			if (session != null) {
				try {
					session.close();
				} catch (HibernateException e) {
					// capturar cualquier exception de hibernate que se pueda
					// presentar
					throw new MyException(e);
				}
			}
		}
		//retorna los licoresPorVenta encontrados
		return licores;
	}

}
