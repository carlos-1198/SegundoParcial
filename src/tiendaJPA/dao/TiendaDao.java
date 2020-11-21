package tiendaJPA.dao;

import tiendaJPA.dao.GenericDao;
import tiendaJPA.model.Tienda;
import tiendaJPA.util.Conexion;

public class TiendaDao extends Conexion<Tienda> 
implements GenericDao<Tienda>  {

	public TiendaDao() {
		super(Tienda.class);
	}

}
