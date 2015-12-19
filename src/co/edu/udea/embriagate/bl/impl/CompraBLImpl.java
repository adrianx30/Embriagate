package co.edu.udea.embriagate.bl.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import co.edu.udea.embriagate.bl.CompraBL;
import co.edu.udea.embriagate.dao.CompraDAO;
import co.edu.udea.embriagate.dao.UsuarioDAO;
import co.edu.udea.embriagate.dto.CompraDTO;
import co.edu.udea.embriagate.dto.UsuarioDTO;
import co.edu.udea.embriagate.exception.MyException;

public class CompraBLImpl implements CompraBL{
	
	public UsuarioDAO usuarioDAO;
	public CompraDAO compraDAO;
	
	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	public CompraDAO getCompraDAO() {
		return compraDAO;
	}

	public void setCompraDAO(CompraDAO compraDAO) {
		this.compraDAO = compraDAO;
	}

	/**
	 * Envia los datos necesarios para la creacion de una compra en la base de datos
	 * @param valor número con el valor de la compra, usuario texto que indica el numero de documento del usuario que realiza la compra
	 * @return void
	 */
	@Override
	public void guardar(Long valor, String usuario) throws MyException {
		//Creamos el objeto necesario para guardar los datos recibidos
		CompraDTO compra = new CompraDTO();
		//Creamos el usuario el cual será el asociado a la compra
		UsuarioDTO usuarioDTO = null;
		//Validamos que el campo valor no este vacio o sea nulo, de ser así se devuelve una excepcion indicandolo
		if("".equals(valor.toString())){
			throw new MyException("Valor no puede estar vacio");
		}
		//Validamos que el campo usuario no este vacio , de ser así se devuelve una excepcion indicandolo
		if("".equals(usuario)){
			throw new MyException("usuario no puede estar vacio");
		}
		//Validamos que el campo usuario no sea nulo, de ser así se devuelve una excepcion indicandolo
		if(usuario == null){
			throw new MyException("usuario no puede ser nulo");
		}
		//Realizamos la consulta de usuario dado el nroDocumento recibido
		usuarioDTO = usuarioDAO.consultar(usuario);
		//Validamos que exista este usuario, de no ser así se devuelve una excepcion indicandolo
		if(usuarioDTO==null){
			throw new MyException("El usuario ingresado no existe!");
		}else{
			//Asignamos a la compra los datos a guardar
			Date d = new Date();
			compra.setFechaVenta(d);
			compra.setUsuario(usuarioDTO);
			compra.setValor(valor);
			//Ejecutamos el metodo que guarda la compra en la base de datos
			compraDAO.crearCompra(compra);
			
		}
		
	}

	/**
	 * Ejecuta la operacion para retornar las compras que existen en el sistema
	 * @return una lista con las compras que existen en la base de datos
	 * retorna nulo si no existen compras
	 */
	@Override
	public List<CompraDTO> obtenerCompras() throws MyException {
		//Creamos la lista a devolver
		List<CompraDTO> lista = new ArrayList<CompraDTO>();
		//Ejecutamos el metodo que trae la compra en la base de datos
		lista = compraDAO.obtenerTodasLasCompras();
		//Retornamos la lista con los resultados obtenidos
		return lista;
	}

	/**
	 * Envia los datos necesarios para la consulta de compras realizadas por un usuario
	 * @param nroDocumento número con el identificador de un usuario
	 * @return una lista con las compras que existen en la base de datos realizadas por el usuario
	 * retorna nulo si no hay compras realizadas por el usuario mencionado
	 */
	@Override
	public List<CompraDTO> obtenerCompras(String nroDocumento) throws MyException {
		//Creamos la lista a devolver
		List<CompraDTO> lista = new ArrayList<CompraDTO>();
		//Instanciamos un usuario, el cual será quien realizó las compras
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		//Validamos que el numero de documento no este vacio, de ser así se devuelve una excepcion indicandolo
		if("".equals(nroDocumento)){
			throw new MyException("Numero de documento no puede estar vacio");
		}
		//Validamos que el nroDocumento no sea nulo, de ser así se devuelve una excepcion indicandolo
		if(nroDocumento == null){
			throw new MyException("Numero de documento no puede ser nulo");
		}
		//Realizamos la consulta de usuario dado el nroDocumento recibido
		usuarioDTO = usuarioDAO.consultar(nroDocumento);
		//Validamos que exista este usuario, de no ser así se devuelve una excepcion indicandolo
		if (usuarioDTO == null){
			throw new MyException("El usuario ingresado no existe!");
		}else{
			//Ejecutamos la busqueda de las compras realizadas por el usuario
			lista = compraDAO.obtenerComprasPorUsuario(usuarioDTO);
			//Retornamos la lista de compras encontrada
			return lista;
		}
	}
	
	/**
	 * Envia los datos necesarios para la consulta de compras realizadas en un rango de fechas
	 * @param desde, hasta, fechas entre las cuales se quiere encontrar las compras realizadas
	 * @return una lista con las compras que existen en la base de datos realizadas durante las fechas mencionadas
	 * retorna null si no hay compras entre las fechas indicadas
	 */
	@Override
	public List<CompraDTO> obtenerCompras(Date desde, Date hasta) throws MyException {
		//Creamos la lista a devolver
		List<CompraDTO> lista = new ArrayList<CompraDTO>();
		//Instanciamos un objeto tipo Date con la fecha actual
		Date d = new Date();
		//Validamos que la fecha inicial no este vacio, de ser así se devuelve una excepcion indicandolo
		if("".equals(desde)){
			throw new MyException("La fecha inicial no puede estar vacia");
		}
		//Validamos que la fecha inicial no sea nulo, de ser así se devuelve una excepcion indicandolo
		if(desde == null){
			throw new MyException("La fecha inicial no puede ser nula");
		}
		//Validamos que la fecha final no este vacio, de ser así se devuelve una excepcion indicandolo
		if("".equals(hasta)){
			throw new MyException("La fecha final no puede estar vacia");
		}
		//Validamos que la fecha final no sea nulo, de ser así se devuelve una excepcion indicandolo
		if(hasta == null){
			throw new MyException("La fecha final no puede ser nula");
		}
		//Validamos que la fecha inicial no sea una fecha futura, de ser así se devuelve una excepcion indicandolo
		if(desde.after(d)){
			throw new MyException("La fecha inicial no puede ser una fecha futura");
		}
		//Validamos que la fecha final no sea una fecha futura, de ser así se devuelve una excepcion indicandolo
		if(hasta.after(d)){
			throw new MyException("La fecha final no puede ser una fecha futura");
		}
		//Validamos que la fecha inicial no sea posterior a la final, de ser así se devuelve una excepcion indicandolo
		if(desde.after(hasta)){
			throw new MyException("La fecha inicial no puede ser posterior a la final");
		}else{
			//Ejecutamos la busqueda de las compras realizadas durante el rango de fechas
			lista = compraDAO.obtenerComprasPorRangoFecha(desde, hasta);
			//Retornamos la lista de compras encontrada
			return lista;
		}
		
	}
	
	/**
	 * Envia los datos necesarios para la consulta de una compra en particular
	 * @param nroCompra número con el identificador de una compra
	 * @return una compra que existen en la base de datos, retorna null si no existe una compra asociada a dicho numero
	 */
	@Override
	public CompraDTO obtenerCompra(Long nroCompra) throws MyException {
		// Creamos la instancia de Compra a devolver
		CompraDTO compra = new CompraDTO();
		//Validamos que el campo nroCompra no este vacio o sea nulo, de ser así se devuelve una excepcion indicandolo
		if("".equals(nroCompra.toString())){
			throw new MyException("Numero de compra no puede estar vacio");
		}
		//Ejecutamos la busqueda de la compra dado el nro de compra dado
		compra = compraDAO.obtenerCompraPorNumero(nroCompra);
		//Retornamos la compra
		return compra;
	}

}
