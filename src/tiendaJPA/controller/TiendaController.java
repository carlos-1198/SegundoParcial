package tiendaJPA.controller;

import java.io.IOException;
import java.util.List;

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
				/*
			case "buscar":
				buscarHeroe(request, response);
				break;
			case "insert":
				registrarHeroe(request, response);
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
	
}
