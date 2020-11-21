package co.edu.ufps.segundoPrevio.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.ufps.segundoPrevio.dao.ServicioDAO;
import co.edu.ufps.segundoPrevio.model.Servicio;

/**
 * Servlet implementation class ServicioServlet
 */
@WebServlet("/ServicioServlet")
public class ServicioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServicioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		System.out.println(action);

		try {
			switch (action) {
			case "new":
				showNewForm(request, response);
				break;
				
			case "insert":
				insert(request, response);
				break;

			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		} 

	}
    
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("registroServicio.jsp");
		dispatcher.forward(request, response);
	}

	private void insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException {
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");

		Servicio servicio = new Servicio(nombre, descripcion);
		ServicioDAO dao = new ServicioDAO();
		dao.insert(servicio);

		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
