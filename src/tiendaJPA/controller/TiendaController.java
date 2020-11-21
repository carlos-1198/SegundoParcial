package tiendaJPA.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tiendaJPA.dao.TiendaDao;
import tiendaJPA.model.Tienda;



@WebServlet("/TiendaController")
public class TiendaController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	TiendaDao dao = new TiendaDao();
	public TiendaController() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		switch(action) {
			case "index":
				index(request, response);
				break;
			case "listar":
				listarTiendas(request, response);
				break;
			case "nuevo":
				showNewForm(request, response);
				break;
			case "insert":
				registrarTienda(request, response);
				break;
				/*
			case "buscar":
				buscarHeroe(request, response);
				break;
			
			case "nuevo":
				showNewForm(request, response);
				break;
			case "listar":
				listarHeroes(request, response);
				break;
			case "edit":
				editarHeroe(request, response);
				break;
			case "update":
				updateHeroe(request, response);
				break;
			case "delete":
				deleteHeroe(request, response);
				break;
			default:
				index(request, response);
				break;
			*/
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	private void index (HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		request.getRequestDispatcher("welcome.jsp").forward(request, response);
	}
	
	public void listarTiendas(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		List <Tienda> listaTiendas = dao.list();
		request.getSession().setAttribute("listTiendas", listaTiendas);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("registro.jsp");
        dispatcher.forward(request, response);
	}
	
	public void registrarTienda(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		//if (esValido(request.getParameter("nombre")) && esValido(request.getParameter("alias"))
				//&& esValido(request.getParameter("estado")) && esValido(request.getParameter("genero"))) {
		Tienda tienda = new Tienda();
		tienda.setClave(request.getParameter("InputPassword"));
		tienda.setDescripcion(request.getParameter("inputDescripcion"));
		tienda.setEmail(request.getParameter("inputEmail "));
		tienda.setFacebook(request.getParameter("inputFacebook "));
		tienda.setImagen("inputImagen");
		tienda.setLema(request.getParameter("inputLema"));
		tienda.setNombre(request.getParameter("inputNombre"));
		tienda.setPropietario(request.getParameter("inputPropietario "));
		tienda.setWeb(request.getParameter("inputWeb "));
		

		dao.insert(tienda);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
		//} else {
			//request.getRequestDispatcher("index.jsp").forward(request, response);
		//}
	}
	
}
