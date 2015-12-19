package co.edu.udea.embriagate.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.embriagate.dao.LicoresPorCompraDAO;
import co.edu.udea.embriagate.dto.CompraDTO;
import co.edu.udea.embriagate.dto.LicoresDTO;
import co.edu.udea.embriagate.dto.LicoresPorCompraDTO;
import co.edu.udea.embriagate.exception.MyException;
/**
 * Clase que implementa todas las operaciones que se pueden hacer sobre la tabla licoresPorCompra
 * @author William Molina
 * @author Adrian Jimenez
 * @author Rafael Patiño
 */
public class LicoresPorCompraDAOImpl extends HibernateDaoSupport implements LicoresPorCompraDAO{
	/**
	 * Guarda un registro en la tabla licoresPorCompra de la base de datos
	 * @param licor objeto de tipo licoresPorCompraDTO que representa al registro que se guardará en la base de datos
	 * @return void 
	 */
	@Override
	public void crearLicoresPorCompra(LicoresPorCompraDTO licor) throws MyException {
		//Se instancia una nueva sesion
		Session session=null;
		try {
			//Se obtiene la sesion
			session=getSession();
			//Se inicia una transaccion
			Transaction tx=session.beginTransaction();
			//Se guarda el objeto licor en la base de datos
			session.save(licor);
			//Se realiza el commit
			tx.commit();
		} catch (HibernateException e){
			//Se maneja la excepcion
			throw new MyException(e);
		}
	}
	/**
	 * Obtiene los licores incluidos en una compra
	 * @param compra objeto de tipo CompraDTO que representa la compra de la que se desea conocer la información
	 * @return List<LicoresPorCompraDTO> retorna los licores incluidos en una compra, retorna una lista vacia si no hay licores en dicha compra 
	 */
	@Override
	public List<LicoresPorCompraDTO> obtenerPorCompra(CompraDTO compra) throws MyException {
		List<LicoresPorCompraDTO> lista=new ArrayList<LicoresPorCompraDTO>();
		//Se instancia una nueva sesion
		Session session=null;
		try {
			//Se obtiene la sesion
			session=getSession();
			Criteria criteria=session.createCriteria(LicoresPorCompraDTO.class).add(Restrictions.eq("compra",compra));
			lista=criteria.list();
		} catch (HibernateException e){
			//Se maneja la excepcion
			throw new MyException(e);
		}
		return lista;
	}
	/**
	 *Obtiene las compras en las que está incluido un licor determinado
	 * @param licor objeto de tipo LicoresDTO que representa al licor 
	 * del que queremos conocer las compras en las que está incluido
	 * @return void 
	 */
	@Override
	public List<LicoresPorCompraDTO> obtenerPorLicor(LicoresDTO licor) throws MyException {
		List<LicoresPorCompraDTO> lista=new ArrayList<LicoresPorCompraDTO>();
		//Se instancia una nueva sesion
		Session session=null;
		try {
			//Se obtiene la sesion
			session=getSession();
			Criteria criteria=session.createCriteria(LicoresPorCompraDTO.class).add(Restrictions.eq("licor",licor));
			lista=criteria.list();
		} catch (HibernateException e){
			//Se maneja la excepcion
			throw new MyException(e);
		}
		return lista;
	}

}