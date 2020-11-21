package tiendaJPA.dao;

import tiendaJPA.model.Cliente;
import tiendaJPA.util.Conexion;

public class ClienteDao extends Conexion<Cliente> 
implements GenericDao<Cliente>  {

	public ClienteDao() {
		super(Cliente.class);
	}

}
