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
			case "login":
				showLoginForm(request, response);
				break;
			case "ingresar":
				ingresar(request, response);
				break;
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
		Tienda tienda = new Tienda();
		if(dao.findEmail(request.getParameter("inputEmail")).getEmail()!=null) {
			tienda.setClave(request.getParameter("inputPassword"));
			tienda.setDescripcion(request.getParameter("inputDescripcion"));
			tienda.setEmail(request.getParameter("inputEmail"));
			tienda.setFacebook(request.getParameter("inputFacebook"));
			tienda.setImagen("inputImagen");
			tienda.setLema(request.getParameter("inputLema"));
			tienda.setNombre(request.getParameter("inputNombre"));
			tienda.setPropietario(request.getParameter("inputPropietario"));
			tienda.setWeb(request.getParameter("inputWeb"));		
			dao.insert(tienda);		
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			response.sendRedirect("welcome.jsp");//si el correo ya esta registrado
		}
		

	}
	
	private void showLoginForm(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);
	}	
	
	private void ingresar(HttpServletRequest request, HttpServletResponse response) 
			 throws ServletException, IOException {
		Tienda tienda = new Tienda();
		tienda = dao.findEmail(request.getParameter("inputEmail"));
		String correo = tienda.getEmail();
		String password = request.getParameter("inputPassword");
		if(correo.contentEquals(tienda.getEmail())) {
			if(password.contentEquals(tienda.getClave())) {
				response.sendRedirect("index.jsp");//si esta bien
			}else {
				response.sendRedirect("servicios.jsp");
			}
		}else {
			response.sendRedirect("servicios.jsp");
		}
		
	}
	
}
