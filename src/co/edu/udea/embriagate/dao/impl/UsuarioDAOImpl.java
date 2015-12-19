package co.edu.udea.embriagate.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import co.edu.udea.embriagate.dao.UsuarioDAO;
import co.edu.udea.embriagate.dto.UsuarioDTO;
import co.edu.udea.embriagate.exception.MyException;
/**
 * Clase que implementa todas las operaciones que se pueden hacer sobre la tabla usuarios
 * @author William Molina
 * @author Adrian Jimenez
 * @author Rafael Patiño
 */
public class UsuarioDAOImpl extends HibernateDaoSupport implements UsuarioDAO {
	/**
	 * Guarda un usuario en la base de datos
	 * @param usuario objeto de tipo UsuarioDTO que representa al usuario que se guardará en la base de datos
	 * @return void 
	 */
	@Override
	public void crear(UsuarioDTO usuario) throws MyException {
		//Se instancia una session
		Session session=null;
		try {
			//Se obtiene la session
			session=getSession();
			//Se inicia una nueva transaccion
			Transaction tx=session.beginTransaction();
			//Se guarda el usuario en la base de datos
			session.save(usuario);
			//Se realiza el commit
			tx.commit();
		} catch (HibernateException e) {
			//Se maneja la excepcion
			throw new MyException(e);
		}
	}
	/**
	 * Obtiene el usuario identificado con dicho login
	 * @param login texto que representa el login del usuario que se quiere obtener
	 * @return UsuarioDTO usuario correspondiente a dicho login, null si no se
	 *  encuentra ningun usuario al que corresponda el login dado
	 */
	@Override
	public UsuarioDTO consultar(String login) throws MyException {
		//Se instancia un usuario
		UsuarioDTO usuario=null;
		//Se instancia una sesion
		Session session=null;
		try{
		//Se obtiene la sesion
			session=getSession();
			//Se obtiene el usuario dado el login
			usuario=(UsuarioDTO)session.get(UsuarioDTO.class,login);			
		}catch(HibernateException e){
			//Se captura y trata la excepcion
			throw new MyException(e);
		}
		//se retorna el usuario
		return usuario;
	}
	/**
	 * Modifica un usuario
	 * @param usuario objeto de tipo UsuarioDTO que representa al usuario que se modificará en la base de datos
	 * @return void 
	 */
	@Override
	public void modificar(UsuarioDTO usuario) throws MyException {
		//Se instancia una sesion
		Session session=null;
		try {
			//se obtiene la sesion
			session=getSession();
			//se inicia una transaccion 
			Transaction tx=session.beginTransaction();
			//Se procede a actualizar el usuario
			session.update(usuario);
			//se hace el commit de la transaccion
			tx.commit();
		} catch (HibernateException e) {
			//Si ocurre alguna excepcion de hibernate se lanza una nueva excepcion propia
			throw new MyException(e);
		}		
	}
	/**
	 * Obtiene todos los usuarios
	 * @return List<UsuarioDTO> lista de usuarios del sistema
	 */
	@Override
	public List<UsuarioDTO> consultarTodos() throws MyException {
		//Se instancia la lista de usuarios
		List<UsuarioDTO> lista=new ArrayList<UsuarioDTO>();
		//Se instancia una sesion
		Session session=null;
		try {
			//Se obtiene la sesion
			session=getSession();
			//Se crea un criteria para obtener todos los usuarios
			Criteria criteria=session.createCriteria(UsuarioDTO.class);
			//Se listan todos los usuarios
			lista=criteria.list();
		} catch (HibernateException e) {
			throw new MyException(e);
		}
		return lista;
	}

}