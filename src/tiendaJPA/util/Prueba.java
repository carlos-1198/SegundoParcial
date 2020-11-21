package tiendaJPA.util;

import java.util.List;


import tiendaJPA.dao.ClienteDao;
import tiendaJPA.dao.ServicioDao;
import tiendaJPA.dao.TiendaDao;
import tiendaJPA.model.Cliente;
import tiendaJPA.model.Servicio;
import tiendaJPA.model.Tienda;

public class Prueba {

	public static void main(String[] args) {
		//Creacion cliente
		Cliente c = new Cliente();
		c.setNombre("Carlos");
		c.setEmail("prueba@gmail.com");
		c.setClave("1234");
		ClienteDao cdao = new ClienteDao();
		cdao.insert(c);
		
		//Creacion tienda
		Tienda t = new Tienda();
		t.setNombre("xiaomi");
		t.setLema("bienvenidos al himalaya");
		t.setDescripcion("esto es una descripcion");
		t.setEmail("xiami@gmail.com");
		t.setClave("4321");
		t.setPropietario("Goku");
		t.setFacebook("https://www.facebook.com/XiaomiColombia/");
		t.setWeb("xiaomi.com");
		t.setImagen("https://upload.wikimedia.org/wikipedia/commons/2/29/Xiaomi_logo.svg");
		TiendaDao tdao = new TiendaDao();
		tdao.insert(t);
		
		//Creacion de servicio
		Servicio s = new Servicio();
		s.setNombre("servicioPrueba");
		s.setDescripcion("descripcionPueba");
		s.setTiendaBean(t);
		ServicioDao sdao = new ServicioDao();
		sdao.insert(s);
		
		//Seguir Tienda
		ClienteDao dao2 = new ClienteDao();
		Cliente prueba2 = dao2.find(2);
		TiendaDao dao = new TiendaDao();
		Tienda prueba = dao.find(1);
		List <Cliente> clientes = prueba.getClientes();		
		clientes.add(prueba2);
		prueba.setClientes(clientes);
		dao.update(prueba);
		
		//Actualizar tienda
		TiendaDao actualizarDao = new TiendaDao();
		Tienda actualizar = actualizarDao.find(3);
		actualizar.setEmail("nuevo@lacava.com");
		actualizarDao.update(actualizar);
		
	}

}
