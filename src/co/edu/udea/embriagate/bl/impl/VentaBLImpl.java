package co.edu.udea.embriagate.bl.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import co.edu.udea.embriagate.bl.VentaBL;
import co.edu.udea.embriagate.dao.ClienteDAO;
import co.edu.udea.embriagate.dao.UsuarioDAO;
import co.edu.udea.embriagate.dao.VentaDAO;
import co.edu.udea.embriagate.dto.ClienteDTO;
import co.edu.udea.embriagate.dto.CompraDTO;
import co.edu.udea.embriagate.dto.UsuarioDTO;
import co.edu.udea.embriagate.dto.VentaDTO;
import co.edu.udea.embriagate.exception.MyException;

public class VentaBLImpl implements VentaBL{
	
	public UsuarioDAO usuarioDAO;
	public ClienteDAO clienteDAO;
	public VentaDAO ventaDAO;

	
	/**
	 * Envia los datos necesarios para la creacion de una venta en la base de datos
	 * @param valor número con el valor de la venta, usuario y cliente textos que indican el numero de documento del usuario y cliente que realizan la venta
	 * @return void
	 */
	@Override
	public void guardar(Long valor, String cliente, String usuario) throws MyException {
		//Creamos el objeto necesario para guardar los datos recibidos
		VentaDTO venta = new VentaDTO();
		//Creamos el usuario el cual será el asociado a la venta
		UsuarioDTO usuarioDTO = null;
		//Creamos el cliente el cual será el asociado a la venta
		ClienteDTO clienteDTO = null;
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
		//Validamos que el campo cliente no este vacio , de ser así se devuelve una excepcion indicandolo
		if("".equals(cliente)){
			throw new MyException("cliente no puede estar vacio");
		}
		//Validamos que el campo cliente no sea nulo, de ser así se devuelve una excepcion indicandolo
		if(cliente == null){
			throw new MyException("cliente no puede ser nulo");
		}
		//Realizamos la consulta de usuario dado el nroDocumento recibido
		usuarioDTO = usuarioDAO.consultar(usuario);
		//Realizamos la consulta de cliente dado el nroDocumento recibido
		clienteDTO = clienteDAO.consultar(cliente);
		//Validamos que exista este usuario, de no ser así se devuelve una excepcion indicandolo
		if(usuarioDTO==null){
			throw new MyException("El usuario ingresado no existe!");
		}
		if(clienteDTO==null){
			throw new MyException("El cliente ingresado no existe!");
		}else{
			//Asignamos a la venta los datos a guardar
			Date d = new Date();
			venta.setFechaVenta(d);
			venta.setUsuario(usuarioDTO);
			venta.setValor(valor);
			venta.setCliente(clienteDTO);
			//Ejecutamos el metodo que guarda la compra en la base de datos
			ventaDAO.crearVenta(venta);;
			
		}
		
	}

	/**
	 * Ejecuta la operacion para retornar las ventas que existen en el sistema
	 * @return una lista con las ventas que existen en la base de datos
	 * retorna nulo si no existen compras
	 */
	@Override
	public List<VentaDTO> obtenerVentas() throws MyException {
		//Creamos la lista a devolver
		List<VentaDTO> lista = new ArrayList<VentaDTO>();
		//Ejecutamos el metodo que trae las ventas en la base de datos
		lista = ventaDAO.obtenerTodasLasVentas();
		//Retornamos la lista con los resultados obtenidos
		return lista;
	}

	/**
	 * Envia los datos necesarios para la consulta de ventas realizadas por un usuario
	 * @param usuario número con el identificador de un usuario
	 * @return una lista con las ventas que existen en la base de datos realizadas por el usuario
	 * retorna nulo si no hay ventas realizadas por el usuario mencionado
	 */
	@Override
	public List<VentaDTO> obtenerVentasPorUsuario(String usuario) throws MyException {
		//Creamos la lista a devolver
		List<VentaDTO> lista = new ArrayList<VentaDTO>();
		//Instanciamos un usuario, el cual será quien realizó las ventas
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		//Validamos que el numero de documento no este vacio, de ser así se devuelve una excepcion indicandolo
		if("".equals(usuario)){
			throw new MyException("Numero de documento no puede estar vacio");
		}
		//Validamos que el usuario no sea nulo, de ser así se devuelve una excepcion indicandolo
		if(usuario == null){
			throw new MyException("Numero de documento no puede ser nulo");
		}
		//Realizamos la consulta de usuario dado el nroDocumento recibido
		usuarioDTO = usuarioDAO.consultar(usuario);
		//Validamos que exista este usuario, de no ser así se devuelve una excepcion indicandolo
		if (usuarioDTO == null){
			throw new MyException("El usuario ingresado no existe!");
		}else{
			//Ejecutamos la busqueda de las ventas realizadas por el usuario
			lista = ventaDAO.obtenerVentasPorUsuario(usuarioDTO);
			//Retornamos la lista de ventas encontrada
			return lista;
		}
	}

	
	/**
	 * Envia los datos necesarios para la consulta de ventas realizadas en un rango de fechas
	 * @param desde, hasta, fechas entre las cuales se quiere encontrar las ventas realizadas
	 * @return una lista con las ventas que existen en la base de datos realizadas durante las fechas mencionadas
	 * retorna null si no hay ventas entre las fechas indicadas
	 */
	@Override
	public List<VentaDTO> obtenerVentasPorRangoFecha(Date desde, Date hasta) throws MyException {
		//Creamos la lista a devolver
		List<VentaDTO> lista = new ArrayList<VentaDTO>();
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
			lista = ventaDAO.obtenerVentasPorRangoFecha(desde, hasta);
			//Retornamos la lista de compras encontrada
			return lista;
		}
	}
	
	/**
	 * Envia los datos necesarios para la consulta de ventas realizadas a un cliente
	 * @param cliente número con el identificador de un cliente
	 * @return una lista con las ventas que existen en la base de datos realizadas al usuario
	 * retorna nulo si no hay ventas realizadas al cliente mencionado
	 */
	@Override
	public List<VentaDTO> obtenerVentasPorCliente(String cliente) throws MyException {
		//Creamos la lista a devolver
		List<VentaDTO> lista = new ArrayList<VentaDTO>();
		//Instanciamos un cliente, el cual será a quien se le realizaron las ventas
		ClienteDTO clienteDTO = new ClienteDTO();
		//Validamos que el numero de documento no este vacio, de ser así se devuelve una excepcion indicandolo
		if("".equals(cliente)){
			throw new MyException("Numero de documento no puede estar vacio");
		}
		//Validamos que el cliente no sea nulo, de ser así se devuelve una excepcion indicandolo
		if(cliente == null){
			throw new MyException("Numero de documento no puede ser nulo");
		}
		//Realizamos la consulta de cliente dado el nroDocumento recibido
		clienteDTO = clienteDAO.consultar(cliente);
		//Validamos que exista este cliente, de no ser así se devuelve una excepcion indicandolo
		if (clienteDTO == null){
			throw new MyException("El cliente ingresado no existe!");
		}else{
			//Ejecutamos la busqueda de las ventas realizadas por el usuario
			lista = ventaDAO.obtenerVentasPorCliente(clienteDTO);
			//Retornamos la lista de ventas encontrada
			return lista;
		}
	}

	/**
	 * Envia los datos necesarios para la consulta de una venta en particular
	 * @param numero, número con el identificador de una venta
	 * @return una vente que existen en la base de datos, retorna null si no existe una venta asociada a dicho numero
	 */
	@Override
	public VentaDTO obtenerVenta(Long numero) throws MyException {
		// Creamos la instancia de Venta a devolver
		VentaDTO venta = new VentaDTO();
		//Validamos que el campo numero no este vacio o sea nulo, de ser así se devuelve una excepcion indicandolo
		if("".equals(numero.toString())){
			throw new MyException("Numero de compra no puede estar vacio");
		}
		//Ejecutamos la busqueda de la venta dado el nro de venta dado
		venta = ventaDAO.obtenerVentaPorNumero(numero);
		//Retornamos la compra
		return venta;
	}

}
