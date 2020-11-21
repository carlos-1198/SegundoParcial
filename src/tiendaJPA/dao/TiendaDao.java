package tiendaJPA.dao;

import tiendaJPA.dao.GenericDao;
import tiendaJPA.model.Tienda;
import tiendaJPA.util.Conexion;

public class TiendaDao extends Conexion<Tienda> 
implements GenericDao<Tienda>  {

	public TiendaDao() {
		super(Tienda.class);
	}
	
	public Tienda findEmail(String email){
		Tienda t = new Tienda();
		t = (Tienda) this.getEm().createNamedQuery("Tienda.findEmail")
			.setParameter("email", email).getSingleResult();
		
		return t;
	}

}
