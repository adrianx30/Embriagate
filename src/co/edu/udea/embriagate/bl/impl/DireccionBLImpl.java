package co.edu.udea.embriagate.bl.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import co.edu.udea.embriagate.bl.DireccionBL;
import co.edu.udea.embriagate.dao.ClienteDAO;
import co.edu.udea.embriagate.dao.DireccionDAO;
import co.edu.udea.embriagate.dto.ClienteDTO;
import co.edu.udea.embriagate.dto.CompraDTO;
import co.edu.udea.embriagate.dto.DireccionDTO;
import co.edu.udea.embriagate.dto.UsuarioDTO;
import co.edu.udea.embriagate.exception.MyException;

public class DireccionBLImpl implements DireccionBL{
	
	DireccionDAO direccionDAO;
	ClienteDAO clienteDAO;
	
	
	public DireccionDAO getDireccionDAO() {
		return direccionDAO;
	}

	public void setDireccionDAO(DireccionDAO direccionDAO) {
		this.direccionDAO = direccionDAO;
	}

	public ClienteDAO getClienteDAO() {
		return clienteDAO;
	}

	public void setClienteDAO(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}

	/**
	 * Envia los datos necesarios para la creacion de una direccion en la base de datos
	 * @param direccion texto con la direccion, telefono texto que indica el numero de telefono
	 * ciudad número que representa el código de la ciudad, preferida booleano que indica si la direccion a guardar es preferida o no
	 * @return void
	 */
	@Override
	public void guardar(String direccion, String telefono, String ciudad, Boolean preferida)
			throws MyException {
		//Creamos el objeto necesario para guardar los datos recibidos
		DireccionDTO direccionDTO = new DireccionDTO();
		//Validamos que el campo ciudad no este vacio, de ser así se devuelve una excepcion indicandolo
		if("".equals(ciudad)){
			throw new MyException("Ciudad no puede estar vacio");
		}
		//Validamos que el campo ciudad no sea nulo, de ser así se devuelve una excepcion indicandolo
		if(direccion == null){
			throw new MyException("direccion no puede ser nulo");
		}
		//Validamos que el campo direccion no este vacio , de ser así se devuelve una excepcion indicandolo
		if("".equals(direccion)){
			throw new MyException("Direccion no puede estar vacio");
		}
		//Validamos que el campo direccion no sea nulo, de ser así se devuelve una excepcion indicandolo
		if(direccion == null){
			throw new MyException("direccion no puede ser nulo");
		}
		//Validamos que el campo telefono no este vacio , de ser así se devuelve una excepcion indicandolo
		if("".equals(telefono)){
			throw new MyException("telefono no puede estar vacio");
		}
		//Validamos que el campo telefono no sea nulo, de ser así se devuelve una excepcion indicandolo
		if(telefono == null){
			throw new MyException("telefono no puede ser nulo");
		}
		//Validamos que el campo preferida no sea nulo, de ser así se devuelve una excepcion indicandolo
		if(preferida == null){
			throw new MyException("preferida no puede ser nulo");
		}
		else{
			//Asignamos a la direccion los datos a guardar
			direccionDTO.setCiudad(ciudad);
			direccionDTO.setDireccion(direccion);
			direccionDTO.setTelefono(telefono);
			direccionDTO.setPreferida(preferida);
			//Ejecutamos el metodo que guarda la direccion en la base de datos
			direccionDAO.crear(direccionDTO);
			
		}
	}
	
	/**
	 * Envia los datos necesarios para la modificacion de una direccion en la base de datos
	 * @param direccion texto con la direccion, telefono texto que indica el numero de telefono
	 * ciudad número que representa el código de la ciudad, preferida booleano que indica si la direccion a guardar es preferida o no
	 * @return void
	 */
	@Override
	public void modificar(String direccion, String cliente, String telefono, String ciudad, Boolean preferida)
			throws MyException {
		//Creamos el objeto necesario para guardar los datos recibidos
		DireccionDTO direccionDTO = new DireccionDTO();
		//Validamos que el campo ciudad no este vacio, de ser así se devuelve una excepcion indicandolo
		if("".equals(ciudad)){
			throw new MyException("Ciudad no puede estar vacio");
		}
		//Validamos que el campo ciudad no sea nulo, de ser así se devuelve una excepcion indicandolo
		if(direccion == null){
			throw new MyException("direccion no puede ser nulo");
		}
		//Validamos que el campo direccion no este vacio , de ser así se devuelve una excepcion indicandolo
		if("".equals(direccion)){
			throw new MyException("Direccion no puede estar vacio");
		}
		//Validamos que el campo direccion no sea nulo, de ser así se devuelve una excepcion indicandolo
		if(direccion == null){
			throw new MyException("direccion no puede ser nulo");
		}
		//Validamos que el campo telefono no este vacio , de ser así se devuelve una excepcion indicandolo
		if("".equals(telefono)){
			throw new MyException("telefono no puede estar vacio");
		}
		//Validamos que el campo telefono no sea nulo, de ser así se devuelve una excepcion indicandolo
		if(telefono == null){
			throw new MyException("telefono no puede ser nulo");
		}
		//Validamos que el campo preferida no sea nulo, de ser así se devuelve una excepcion indicandolo
		if(preferida == null){
			throw new MyException("preferida no puede ser nulo");
		}
		else{
			//Asignamos a la direccion los datos a guardar
			direccionDTO.setCiudad(ciudad);
			direccionDTO.setDireccion(direccion);
			direccionDTO.setTelefono(telefono);
			direccionDTO.setPreferida(preferida);
			//Ejecutamos el metodo que guarda la direccion en la base de datos
			direccionDAO.modificar(direccionDTO);
			
		}
		
	}

	
	/**
	 * Ejecuta la operacion para retornar las direcciones que existen en el sistema dado un cliente en particular
	 * @param cliente texto con el numero de documento perteneciente al cliente del cual se desean las direcciones
	 * @return una lista con las direcciones que existen en la base de datos pertenecientes al cliente dado
	 * retorna nulo si no existen tales direcciones
	 */
	@Override
	public List<DireccionDTO> buscar(String cliente) throws MyException {
		//Creamos la lista a devolver
		List<DireccionDTO> lista = new ArrayList<DireccionDTO>();
		//Instanciamos un cliente, de quien nos interezan las direcciones
		ClienteDTO clienteDTO = new ClienteDTO();
		//Validamos que cliente no este vacio, de ser así se devuelve una excepcion indicandolo
		if("".equals(cliente)){
			throw new MyException("cliente no puede estar vacio");
		}
		//Validamos que cliente no sea nulo, de ser así se devuelve una excepcion indicandolo
		if(cliente == null){
			throw new MyException("cliente no puede ser nulo");
		}
		//Realizamos la consulta de cliente dado el nroDocumento recibido
		clienteDTO = clienteDAO.consultar(cliente);
		//Validamos que exista este cliente, de no ser así se devuelve una excepcion indicandolo
		if (clienteDTO == null){
			throw new MyException("El cliente ingresado no existe!");
		}else{
			//Ejecutamos la busqueda de las direcciones del cliente
			lista = direccionDAO.consultar(clienteDTO);
			//Retornamos la lista de compras encontrada
			return lista;
		}
	}
	
	/**
	 * Ejecuta la operacion para retornar la direccion preferida que existen en el sistema dado un cliente en particular
	 * @param cliente texto con el numero de documento perteneciente al cliente del cual se desea la direccion preferida
	 * @return una direccion preferida perteneciente al cliente dado
	 * retorna nulo si no existen tal direccion
	 */
	@Override
	public DireccionDTO consultarPreferida(String cliente) throws MyException {
		//Creamos la lista a devolver
		DireccionDTO direccionDTO = new DireccionDTO();
		//Instanciamos un cliente, de quien nos interezan las direcciones
		ClienteDTO clienteDTO = new ClienteDTO();
		//Validamos que cliente no este vacio, de ser así se devuelve una excepcion indicandolo
		if("".equals(cliente)){
			throw new MyException("cliente no puede estar vacio");
		}
		//Validamos que cliente no sea nulo, de ser así se devuelve una excepcion indicandolo
		if(cliente == null){
			throw new MyException("cliente no puede ser nulo");
		}
		//Realizamos la consulta de cliente dado el nroDocumento recibido
		clienteDTO = clienteDAO.consultar(cliente);
		//Validamos que exista este cliente, de no ser así se devuelve una excepcion indicandolo
		if (clienteDTO == null){
			throw new MyException("El cliente ingresado no existe!");
		}else{
			//Ejecutamos la busqueda de las direcciones del cliente
			direccionDTO = direccionDAO.consultarPreferida(clienteDTO);
			//Retornamos la lista de compras encontrada
			return direccionDTO;
		}
	}

	/**
	 * Ejecuta la operacion para asignar la direccion preferida de un cliente, dada dicha direccion
	 * @param direccion texto con direccion que será asignada como preferida
	 * @return void
	 */
	@Override
	public void seleccionarPreferida(String direccion, String telefono, String ciudad) throws MyException {
		//Creamos el objeto necesario para guardar los datos recibidos
		DireccionDTO direccionDTO = new DireccionDTO();
		//Validamos que el campo ciudad no este vacio, de ser así se devuelve una excepcion indicandolo
		if("".equals(ciudad)){
			throw new MyException("Ciudad no puede estar vacio");
		}
		//Validamos que el campo ciudad no sea nulo, de ser así se devuelve una excepcion indicandolo
		if(direccion == null){
			throw new MyException("direccion no puede ser nulo");
		}
		//Validamos que el campo direccion no este vacio , de ser así se devuelve una excepcion indicandolo
		if("".equals(direccion)){
			throw new MyException("Direccion no puede estar vacio");
		}
		//Validamos que el campo direccion no sea nulo, de ser así se devuelve una excepcion indicandolo
		if(direccion == null){
			throw new MyException("direccion no puede ser nulo");
		}
		//Validamos que el campo telefono no este vacio , de ser así se devuelve una excepcion indicandolo
		if("".equals(telefono)){
			throw new MyException("telefono no puede estar vacio");
		}
		//Validamos que el campo telefono no sea nulo, de ser así se devuelve una excepcion indicandolo
		if(telefono == null){
			throw new MyException("telefono no puede ser nulo");
		}
		else{
			//Asignamos a la direccion los datos a guardar
			direccionDTO.setCiudad(ciudad);
			direccionDTO.setDireccion(direccion);
			direccionDTO.setTelefono(telefono);
			direccionDTO.setPreferida(true);
			//Ejecutamos el metodo que guardarla como preferida en la base de datos
			direccionDAO.seleccionarComoPreferida(direccionDTO);;
			
		}
		
	}

}
