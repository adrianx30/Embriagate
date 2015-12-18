package co.edu.udea.embriagate.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.embriagate.dao.RolDAO;
import co.edu.udea.embriagate.dto.RolDTO;
import co.edu.udea.embriagate.exception.MyException;

public class RolDAOImpl extends HibernateDaoSupport implements RolDAO {

	/**
	 * Consulta los roles de la base de datos
	 * @param null
	 * @return retorna una lista de RolDTO correspondientes a los roles que existan en la base de datos
	 * retorna nulo en caso de que no haya ninguno
	 */
	@Override
	public List<RolDTO> consultar() throws MyException {
		//Creamos la lista de roles para guardar el resultado de la consulta
		List<RolDTO> lista = new ArrayList<RolDTO>();
		//Creamos una instancia de session
		Session session = null;
		try {
			//Se obtiene la session
			session = getSession();
			//creamos una instancia Criteria que es donde se obtienen los resultados de la consulta
			Criteria criteria = session.createCriteria(RolDTO.class);
			//añadimos a nuestra lista el resultado de la consulta
			lista = criteria.list();
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
		//Retornamos la lista de roles encontrados
		return lista;
	}

}
