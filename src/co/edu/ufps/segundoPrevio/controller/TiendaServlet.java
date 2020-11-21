package co.edu.ufps.segundoPrevio.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.ufps.segundoPrevio.dao.GenericDao;
import co.edu.ufps.segundoPrevio.dao.TiendaDAO;
import co.edu.ufps.segundoPrevio.model.Tienda;

/**
 * Servlet implementation class TiendaServlet
 */
@WebServlet("/TiendaServlet")
public class TiendaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private TiendaDAO tiendaDAO;

	private GenericDao<Tienda> u;

	public TiendaServlet() {
		super();
	}

	public void init() {

		tiendaDAO = new TiendaDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		System.out.println(action);

		try {
			switch (action) {
			case "new":
				showNewForm(request, response);
				break;
				
			case "log":
				showLogForm(request, response);
				break;

			case "insert":
				insert(request, response);
				break;

			case "login":
				login(request, response);
				break;

			default:
				list(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("registro.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showLogForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
	}

	private void insert(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ParseException, ServletException {
		RequestDispatcher dispatcher = null;
		if (validar(request.getParameter("email"), 1,"")==false) {
			Tienda t = new Tienda();
			t.setNombre(request.getParameter("nombre"));
			t.setEmail(request.getParameter("email"));
			t.setLema(request.getParameter("lema"));
			t.setDescripcion(request.getParameter("descripcion"));
			t.setClave(request.getParameter("contraseña"));
			t.setPropietario(request.getParameter("propietario"));
			t.setFacebook(request.getParameter("facebook"));
			t.setWeb(request.getParameter("web"));
			t.setImagen(request.getParameter("img"));
			tiendaDAO.insert(t);

			dispatcher = request.getRequestDispatcher("index.jsp");
		} else {
			dispatcher = request.getRequestDispatcher("registro.jsp");
			request.setAttribute("correoRepetido", "Registro fallido, email existente");
		}
		dispatcher.forward(request, response);
	}

	private boolean validar(String email, int opcion, String clave) {
		List<Tienda> tiendas = tiendaDAO.list();
		if (opcion == 1) {
			for (Tienda t : tiendas) {
				if (t.getEmail().equals(email)) {
					return true;
				}
			}
		}

		else {
			for (Tienda t : tiendas) {
			    if (t.getEmail().equals(email) && t.getClave().equals(clave)) {
			    	return true;
						}
					}
				}

		return false;
	}

	private void list(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Tienda> list = tiendaDAO.list();
		request.setAttribute("list", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

	private void login(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		RequestDispatcher dispatcher = null;

		if (validar(request.getParameter("email"), 2, request.getParameter("contraseña"))) {
			dispatcher = request.getRequestDispatcher("servicios.jsp");
		} else {
			dispatcher = request.getRequestDispatcher("login.jsp");
			request.setAttribute("usuarioExistente", "Usuario no encontrado");
		}
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
