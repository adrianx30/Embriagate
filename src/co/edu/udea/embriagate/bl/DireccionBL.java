package co.edu.udea.embriagate.bl;

import java.util.List;

import co.edu.udea.embriagate.dto.DireccionDTO;
import co.edu.udea.embriagate.exception.MyException;

public interface DireccionBL {
	
	//Mï¿½todo para guardar una direccion
	public void guardar(String direccion, String telefono, String ciudad, Boolean preferida)throws MyException;
	
	//Mï¿½todo para modificar una direccion
	public void modificar(String direccion, String cliente, String telefono, String ciudad, Boolean preferida)throws MyException;
  
    //Metodo para obtener las direcciones de un usuario en especifico, dado su número de documento
    public List<DireccionDTO> buscar(String cliente) throws MyException;
    
    //Metodo para obtener la direccion preferida de un usuario en especifico, dado su número de documento
    public DireccionDTO consultarPreferida(String cliente) throws MyException;
    
    //Metodo para asignar la direccion preferida de un usuario en especifico, dada dicha direccion
    public void seleccionarPreferida(String direccion, String telefono, String ciudad) throws MyException;
}
