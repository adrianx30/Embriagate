package co.edu.udea.embriagate.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.embriagate.dao.DireccionDAO;
import co.edu.udea.embriagate.dto.ClienteDTO;
import co.edu.udea.embriagate.dto.DireccionDTO;
import co.edu.udea.embriagate.dto.LicoresDTO;
import co.edu.udea.embriagate.exception.MyException;

public class DireccionDAOImpl extends HibernateDaoSupport implements DireccionDAO {

	/**
	 * Guarda una direccion en la base de datos
	 * @param direccion objeto de tipo DireccionDTO que representa la direccion que se guardarÃ¡ en la base de datos
	 * @return void 
	 */
	@Override
	public void crear(DireccionDTO direccion) throws MyException {
		// Creamos una instancia de session
		Session session = null;
		try {
			// Se obtiene la session
			session = getSession();
			// Se inicia la transaccion
			Transaction tx = session.beginTransaction();
			// Guardamos el objeto licor en la base de datos
			session.save(direccion);
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
	 * Elimina de manera lógica una direccion de la base de datos
	 * @param direccion DireccionDTO que representa la direccion que se desea eliminar
	 * @return void
	 */
	@Override
	public void eliminar(DireccionDTO direccion) throws MyException {
		// Creamos una instancia de session
		Session session = null;
		try {
			// Se obtiene la session
			session = getSession();
			// Se inicia la transaccion
			Transaction tx = session.beginTransaction();
			// eliminamos el objeto direccion de la base de datos
			session.delete(direccion);
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
	 * Modifica de una direccion de la base de datos
	 * @param direccion DireccionDTO que representa la direccion que se desea modificar
	 * @return void
	 */
	@Override
	public void modificar(DireccionDTO direccion) throws MyException {
		// Creamos una instancia de session
				Session session = null;
				try {
					// Se obtiene la session
					session = getSession();
					// Se inicia la transaccion
					Transaction tx = session.beginTransaction();
					// modificamos el objeto direccion de la base de datos
					session.update(direccion);
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
	 * Consulta las direcciones de la base de datos dado su cliente
	 * @param cliente ClienteDTO que representa el cliente del cual se desea consultar sus direcciones
	 * @return DireccionDTO retorna una lista de direcciones que corresponden al cliente dado,retorna null si no se encuentra
	 * una direccion que coincida con el cliente dado 
	 */
	@Override
	public List<DireccionDTO> consultar(ClienteDTO cliente) throws MyException {
		// Creamos la lista de direcciones para guardar el resultado de la consulta
		List<DireccionDTO> direcciones = new ArrayList<DireccionDTO>();
		// Creamos una instancia de session
		Session session = null;
		try {
			// Se obtiene la session
			session = getSession();
			// creamos una instancia Criteria que es donde se obtienen los resultados de la consulta
			// Añadimos también la restriccion de cliente para retornar lo deseado por el método
			Criteria criteria = session.createCriteria(DireccionDTO.class)
					.add(Restrictions.eq("Cliente", cliente.getNumeroDocumento()));
			// añadimos a nuestra lista el resultado de la consulta
			direcciones = criteria.list();
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
		// retorna las direcciones encontrados
		return direcciones;
	}

	
	/**
	 * Modifica en la base de datos la direccion preferida de un cliente
	 * @param cliente ClienteDTO que representa el cliente del cual se desea consultar sus direcciones
	 * @return DireccionDTO retorna una lista de direcciones que corresponden al cliente dado,retorna null si no se encuentra
	 * una direccion que coincida con el cliente dado 
	 */
	@Override
	public void seleccionarComoPreferida(DireccionDTO direccion) throws MyException {
		//creamos una direccion auxiliar para tratarla en el método
		DireccionDTO aux = new DireccionDTO();
		// Creamos una instancia de session
		Session session = null;
		try {
			// Se obtiene la session
			session = getSession();
			// creamos una instancia Criteria que es donde se obtienen los resultados de la consulta
			// Añadimos también la restriccion que nos permitirá verificar las direcciones del cliente
			Criteria criteria = session.createCriteria(DireccionDTO.class)
					.add(Restrictions.eq("Cliente", direccion.getId().getCliente()));
			//Añadimos una restriccion adicional
			criteria.add(Restrictions.eq("Preferida", Boolean.TRUE));
			//Realizamos un condicional, si la lista es vacia, quiere decir que no hay
			//Direccion preferida
			if(criteria.list().isEmpty()){
				//Asignamos la direccion como preferida
				direccion.setPreferida(true);
				//Realizamos la modificacion en la base de datos
				this.modificar(direccion);
			}else{
				//Si la lista no está vacia
				//nuestra variable auxiliar será el primer item de la lista del Criteria
				aux = (DireccionDTO) criteria.list().iterator().next();
				//Si las direcciones son iguales, no es necesario realizar alguna modificacion
				//Si las direcciones son diferentes
				if(!aux.equals(direccion)){			
					//Realizamos los cambios correspondientes en el campo "Preferida" en ambas direcciones
					aux.setPreferida(false);
					direccion.setPreferida(true);
					//guardamos en la base de datos ambos cambios
					this.modificar(aux);					
					this.modificar(direccion);
				}
			}
			
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
	 * Consulta la direccion preferida de un cliente en la base de datos
	 * @param cliente ClienteDTO que representa el cliente del cual se desea consultar su direccion preferida
	 * @return DireccionDTO retorna una direccion que corresponden a la preferida del cliente dado,retorna null si no se encuentra
	 * una direccion preferida que coincida con el cliente dado 
	 */
	@Override
	public DireccionDTO consultarPreferida(ClienteDTO cliente) throws MyException {
		// Creamos una direccion para guardar el resultado de la consulta
				DireccionDTO direccion = new DireccionDTO();
				// Creamos una instancia de session
				Session session = null;
				try {
					// Se obtiene la session
					session = getSession();
					// creamos una instancia Criteria que es donde se obtienen los resultados de la consulta
					// Añadimos también la restriccion de cliente para retornar lo deseado por el método
					Criteria criteria = session.createCriteria(DireccionDTO.class)
							.add(Restrictions.eq("Cliente", cliente.getNumeroDocumento()));
					//Añadimos la restriccion para tener únicamente la direccion preferida
					criteria.add(Restrictions.eq("Preferida", Boolean.TRUE));
					// añadimos a nuestra direccion el resultado de la consulta
					if(!criteria.list().isEmpty()){
						direccion = (DireccionDTO) criteria.list().iterator().next();
					}
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
				// retorna la direccion preferida
				return direccion;
	}

	

}
