package co.edu.udea.embriagate.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.embriagate.dao.LicoresDAO;
import co.edu.udea.embriagate.dto.LicoresDTO;
import co.edu.udea.embriagate.dto.TipoLicoresDTO;
import co.edu.udea.embriagate.exception.MyException;

/**
 * Clase que implementa todas las operaciones que se pueden hacer sobre la tabla Licores
 * @author William Molina
 * @author Adrian Jimenez
 * @author Rafael PatiÃ±o
 */
public class LicoresDAOImpl extends HibernateDaoSupport implements LicoresDAO{

	/**
	 * Guarda un licor en la base de datos
	 * @param cliente objeto de tipo LicoresDTO que representa al Licor que se guardarÃ¡ en la base de datos
	 * @return void 
	 */
	@Override
	public void crearLicor(LicoresDTO licor) throws MyException {
		//Creamos una instancia de session
		Session session = null;
		try{
			//Se obtiene la session
			session = getSession();
			//Se inicia la transaccion
			Transaction tx = session.beginTransaction();
			//Guardamos el objeto licor en la base de datos
			session.save(licor);
			//Realizamos el commit de la transaccion
			tx.commit();
		}catch(HibernateException e){
			//Si ocurre alguna excepcion de hibernate se lanza una nueva excepcion propia
			throw new MyException(e);
		}finally {
			//Por ultimo, si la sesion no es nula se procede a cerrarla
			if(session!=null){
				try {
					session.close();
				} catch (HibernateException e) {
					//capturar cualquier exception de hibernate que se pueda presentar
					throw new MyException(e);
				}
			}
		}
		
	}
	
	
	/**
	 * Consulta los licores de la base de datos dado su fabricante
	 * @param fabricante texto que representa el fabricante de los licores que se desea consultar
	 * @return LicoresDTO retorna una lista de Licores que corresponden al fabricante dado,retorna null si no se encuentra
	 * un licor que coincida con el fabricante dado 
	 */
	@Override
	public List<LicoresDTO> obtenerPorFabricante(String fabricante) throws MyException {
		//Creamos la lista de licores para guardar el resultado de la consulta
		List<LicoresDTO> licores = new ArrayList<LicoresDTO>();
		//Creamos una instancia de session
		Session session = null;
		try{
			//Se obtiene la session
			session = getSession();
			//creamos una instancia Criteria que es donde se obtienen los resultados de la consulta
			//Añadimos también la restriccion de fabricante para retornar lo deseado por el método
			Criteria criteria = session.createCriteria(LicoresDTO.class)
					.add(Restrictions.eq("Fabricante", fabricante));
			//añadimos a nuestra lista el resultado de la consulta
			licores = criteria.list();
		}catch(HibernateException e){
			//Si ocurre alguna excepcion de hibernate se lanza una nueva excepcion propia
			throw new MyException(e);
		}finally {
			//Por ultimo, si la sesion no es nula se procede a cerrarla
			if(session!=null){
				try {
					session.close();
				} catch (HibernateException e) {
					//capturar cualquier exception de hibernate que se pueda presentar
					throw new MyException(e);
				}
			}
		}
		//retorna los licores encontrados
		return licores;
	}

	
	/**
	 * Consulta los licores de la base de datos dado su añejamiento
	 * @param añejamiento entero que representa el añejamiento de los licores que se desea consultar
	 * @return LicoresDTO retorna una lista de Licores que corresponden al añejamiento dado, retorna null si no se encuentra
	 * un licor que coincida con el añejamiento dado 
	 */
	@Override
	public List<LicoresDTO> obtenerPorA�ejamiento(int a�ejamiento) throws MyException {
		//Creamos la lista de licores para guardar el resultado de la consulta
		List<LicoresDTO> licores = new ArrayList<LicoresDTO>();
		//Creamos una instancia de session
		Session session = null;
		try{
			//Se obtiene la session
			session = getSession();
			//creamos una instancia Criteria que es donde se obtienen los resultados de la consulta
			//Añadimos también la restriccion de añejamiento para retornar lo deseado por el método
			Criteria criteria = session.createCriteria(LicoresDTO.class)
					.add(Restrictions.eq("A�ejamiento", a�ejamiento));
			//añadimos a nuestra lista el resultado de la consulta
			licores = criteria.list();
		}catch(HibernateException e){
			//Si ocurre alguna excepcion de hibernate se lanza una nueva excepcion propia
			throw new MyException(e);
		}finally {
			//Por ultimo, si la sesion no es nula se procede a cerrarla
			if(session!=null){
				try {
					session.close();
				} catch (HibernateException e) {
					//capturar cualquier exception de hibernate que se pueda presentar
					throw new MyException(e);
				}
			}
		}
		//retorna los licores encontrados
		return licores;
	}
	
	/**
	 * Consulta los licores de la base de datos dado un rango de añejamiento
	 * @param desde, hasta enteros que representan el rango de añejamiento de los licores que se desea consultar
	 * @return LicoresDTO retorna una lista de Licores que corresponden al añejamiento dado, retorna null si no se encuentra
	 * un licor que coincida con el añejamiento dado 
	 */
	@Override
	public List<LicoresDTO> obtenerPorA�ejamiento(int desde, int hasta) throws MyException {
		//Creamos la lista de licores para guardar el resultado de la consulta
		List<LicoresDTO> licores = new ArrayList<LicoresDTO>();
		//Creamos una instancia de session
		Session session = null;
		try{
			//Se obtiene la session
			session = getSession();
			//creamos una instancia Criteria que es donde se obtienen los resultados de la consulta
			//Añadimos también la restriccion de añejamiento para retornar lo deseado por el método
			Criteria criteria = session.createCriteria(LicoresDTO.class)
					.add(Restrictions.between("A�ejamiento", desde, hasta));
			//añadimos a nuestra lista el resultado de la consulta
			licores = criteria.list();
		}catch(HibernateException e){
			//Si ocurre alguna excepcion de hibernate se lanza una nueva excepcion propia
			throw new MyException(e);
		}finally {
			//Por ultimo, si la sesion no es nula se procede a cerrarla
			if(session!=null){
				try {
					session.close();
				} catch (HibernateException e) {
					//capturar cualquier exception de hibernate que se pueda presentar
					throw new MyException(e);
				}
			}
		}
		//retorna los licores encontrados
		return licores;
	}

	/**
	 * Consulta los licores de la base de datos dada la cantidad que se posea de ellos
	 * @param stock entero que representan la cantidad de ejemplares de los licores que se desea consultar
	 * @return LicoresDTO retorna una lista de Licores que tengan stock igual o mayor al dado, retorna null si no se encuentra
	 * un licor que coincida con el stock dado 
	 */
	@Override
	public List<LicoresDTO> obtenerPorExistencia(long stock) throws MyException {
		//Creamos la lista de licores para guardar el resultado de la consulta
		List<LicoresDTO> licores = new ArrayList<LicoresDTO>();
		//Creamos una instancia de session
		Session session = null;
		try{
			//Se obtiene la session
			session = getSession();
			//creamos una instancia Criteria que es donde se obtienen los resultados de la consulta
			//Añadimos también la restriccion de stock para retornar lo deseado por el método
			Criteria criteria = session.createCriteria(LicoresDTO.class)
					.add(Restrictions.ge("Existencias", stock));
			//añadimos a nuestra lista el resultado de la consulta
			licores = criteria.list();
		}catch(HibernateException e){
			//Si ocurre alguna excepcion de hibernate se lanza una nueva excepcion propia
			throw new MyException(e);
		}finally {
			//Por ultimo, si la sesion no es nula se procede a cerrarla
			if(session!=null){
				try {
					session.close();
				} catch (HibernateException e) {
					//capturar cualquier exception de hibernate que se pueda presentar
					throw new MyException(e);
				}
			}
		}
		//retorna los licores encontrados
		return licores;
	}

	
	/**
	 * Consulta los licores de la base de datos dado el tipo de licor que sean
	 * @param tipo TipoLicoresDTo que representa el tipo de licor que se desea consultar
	 * @return LicoresDTO retorna una lista de Licores que pertenezcan al tipo dado, retorna null si no se encuentra
	 * un licor que coincida con el tipo dado 
	 */
	@Override
	public List<LicoresDTO> obtenerPorTipo(TipoLicoresDTO tipo) throws MyException {
		//Creamos la lista de licores para guardar el resultado de la consulta
		List<LicoresDTO> licores = new ArrayList<LicoresDTO>();
		//Creamos una instancia de session
		Session session = null;
		try{
			//Se obtiene la session
			session = getSession();
			//creamos una instancia Criteria que es donde se obtienen los resultados de la consulta
			//Añadimos también la restriccion de stock para retornar lo deseado por el método
			Criteria criteria = session.createCriteria(LicoresDTO.class)
					.add(Restrictions.eq("TipoLicores", tipo.getCodigo()));
			//añadimos a nuestra lista el resultado de la consulta
			licores = criteria.list();
		}catch(HibernateException e){
			//Si ocurre alguna excepcion de hibernate se lanza una nueva excepcion propia
			throw new MyException(e);
		}finally {
			//Por ultimo, si la sesion no es nula se procede a cerrarla
			if(session!=null){
				try {
					session.close();
				} catch (HibernateException e) {
					//capturar cualquier exception de hibernate que se pueda presentar
					throw new MyException(e);
				}
			}
		}
		//retorna los licores encontrados
		return licores;
	}

}