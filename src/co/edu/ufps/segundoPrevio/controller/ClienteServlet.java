package co.edu.ufps.segundoPrevio.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.ufps.segundoPrevio.dao.ClienteDAO;
import co.edu.ufps.segundoPrevio.dao.GenericDao;
import co.edu.ufps.segundoPrevio.model.Cliente;



/**
 * Servlet implementation class ClienteServlet
 */
@WebServlet("/ClienteServlet")
public class ClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ClienteDAO clienteDao;
	
	private GenericDao<Cliente> u;

	public ClienteServlet() {
		super();
	}

	public void init() {
		
		clienteDao = new ClienteDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		System.out.println(action);

		try {
			switch (action) {
			case "buscar":
				search(request, response);
				break;

			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		} 
	}


	private void search(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		String nombre= request.getParameter("nombre");
		Cliente cliente= null;
		clienteDao.delete(cliente);
		RequestDispatcher dispatcher = request.getRequestDispatcher("EmpleadoServlet?action=mostrar");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
