package tiendaJPA.dao;

import tiendaJPA.model.Servicio;
import tiendaJPA.util.Conexion;

public class ServicioDao extends Conexion<Servicio> 
implements GenericDao<Servicio>  {

	public ServicioDao() {
		super(Servicio.class);
	}

}
