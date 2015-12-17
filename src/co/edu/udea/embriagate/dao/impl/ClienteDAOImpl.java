package co.edu.udea.embriagate.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.embriagate.dao.ClienteDAO;
import co.edu.udea.embriagate.dto.ClienteDTO;
import co.edu.udea.embriagate.exception.MyException;

/**
 * Clase que implementa todas las operaciones que se pueden hacer sobre la tabla clientes
 * @author William Molina
 * @author Adrian Jimenez
 * @author Rafael Patiño
 */
public class ClienteDAOImpl extends HibernateDaoSupport implements ClienteDAO{
	/**
	 * Guarda un cliente en la base de datos
	 * @param cliente objeto de tipo ClienteDTO que representa al cliente que se guardará en la base de datos
	 * @return void 
	 */
	@Override
	public void crearCliente(ClienteDTO cliente) throws MyException {
		//Se instancia una sesion
		Session session=null;
		try {
			//se obtiene la sesion
			session=getSession();
			//se inicia una transaccion 
			Transaction tx=session.beginTransaction();
			//se procede a guardar el objeto cliente en la base de datos
			session.save(cliente);
			//se hace el commit de la transaccion
			tx.commit();
		} catch (HibernateException e) {
			//Si ocurre alguna excepcion de hibernate se lanza una nueva excepcion propia
			throw new MyException(e);
		}finally{
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
	 * Actualiza un cliente en la base de datos
	 * @param cliente objeto de tipo ClienteDTO que representa al cliente que se actualizará en la base de datos
	 * @return void 
	 */
	@Override
	public void modificarCliente(ClienteDTO cliente) throws MyException {
		//Se instancia una sesion
		Session session=null;
		try {
			//se obtiene la sesion
			session=getSession();
			//se inicia una transaccion 
			Transaction tx=session.beginTransaction();
			//Se procede a actualizar el cliente
			session.update(cliente);
			//se hace el commit de la transaccion
			tx.commit();
		} catch (HibernateException e) {
			//Si ocurre alguna excepcion de hibernate se lanza una nueva excepcion propia
			throw new MyException(e);
		}finally{
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
	 * Elimina lógicamente un cliente en la base de datos
	 * @param cliente objeto de tipo ClienteDTO que representa al cliente que se eliminará de la base de datos
	 * @return void 
	 */
	@Override
	public void eliminarCliente(ClienteDTO cliente) throws MyException {
		//Se instancia una sesion
				Session session=null;
				try {
					//se obtiene la sesion
					session=getSession();
					//se inicia una transaccion 
					Transaction tx=session.beginTransaction();
					//Se procede a actualizar el cliente, como es borrado lógico, basta con actualizarlo
					session.update(cliente);
					//se hace el commit de la transaccion
					tx.commit();
				} catch (HibernateException e) {
					//Si ocurre alguna excepcion de hibernate se lanza una nueva excepcion propia
					throw new MyException(e);
				}finally{
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
	 * Consulta un cliente de la base de datos dado su numero de documento
	 * @param nroDocumento texto que representa el numero de documento del cliente que se desea consultar
	 * @return ClienteDTO retorna el cliente identificado con dicho numero de documento,retorna null si no se encuentra
	 * un cliente que coincida con el numero de documento  
	 */
	@Override
	public ClienteDTO consultar(String nroDocumento) throws MyException {
		//Se instancia un cliente
		ClienteDTO cliente=null;
		//Se instancia una sesion
		Session session=null;
		try{
			//Se obtiene la sesion
			session=getSession();
			//Se obtiene el cliente dado el numero de documento
			cliente=(ClienteDTO)session.get(ClienteDTO.class,nroDocumento);			
		}catch(HibernateException e){
			//Se captura y trata la excepcion
			throw new MyException(e);
		}
		//se retorna el cliente
		return cliente;
	}

}
