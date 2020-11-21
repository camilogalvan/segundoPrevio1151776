package co.edu.ufps.segundoPrevio.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import co.edu.ufps.segundoPrevio.dao.ClienteDAO;
import co.edu.ufps.segundoPrevio.dao.SeguirDAO;
import co.edu.ufps.segundoPrevio.dao.ServicioDAO;
import co.edu.ufps.segundoPrevio.dao.TiendaDAO;
import co.edu.ufps.segundoPrevio.model.Cliente;
import co.edu.ufps.segundoPrevio.model.Seguir;
import co.edu.ufps.segundoPrevio.model.Servicio;
import co.edu.ufps.segundoPrevio.model.Tienda;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("segundoPrevio");
		EntityManager em = emf.createEntityManager();

		ClienteDAO clienteDao = new ClienteDAO();
		TiendaDAO tiendaDAO = new TiendaDAO();
		SeguirDAO seguirDAO = new SeguirDAO();
		ServicioDAO servicioDAO = new ServicioDAO();

		Cliente c = new Cliente();
		c.setNombre("Camilo");
		c.setEmail("brayancamilogj@ufps.edu.co");
		c.setClave("0123");

		clienteDao.insert(c);

		Tienda tt = new Tienda();
		tt.setNombre("Tienda fUERTE");
		tt.setLema("La mejor calidad");
		tt.setDescripcion("Tienda buena");
		tt.setEmail("tt@gmail.com");
		tt.setClave("1234");
		tt.setPropietario("Pedro");
		tt.setFacebook("La tienda");
		tt.setWeb("tt.com");
		tt.setImagen("img");
		
		tiendaDAO.insert(tt);
		
		Servicio serv = new Servicio();
		serv.setNombre("Servicios Camilo");
		serv.setDescripcion("Domicilio");
		
		servicioDAO.insert(serv);
		
		Seguir se = new Seguir();

		se.setCliente(c);
		se.setTienda(tt);
		
		seguirDAO.insert(se);
		
		clienteDao.update(c);
		tiendaDAO.update(tt);
		
		tt= tiendaDAO.find(1);
		
		tt.setNombre("Tienda fUERTE");
		tt.setLema("La mejor calidad");
		tt.setDescripcion("Tienda buena");
		tt.setEmail("tt@gmail.com");
		tt.setClave("1234");
		tt.setPropietario("Francisco");
		tt.setFacebook("La tienda");
		tt.setWeb("tt.com");
		tt.setImagen("img");
		
		em.close();
	}

}
