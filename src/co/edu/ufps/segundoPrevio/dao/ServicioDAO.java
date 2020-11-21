package co.edu.ufps.segundoPrevio.dao;


import co.edu.ufps.segundoPrevio.model.Servicio;
import co.edu.ufps.segundoPrevio.util.Conexion;

public class ServicioDAO extends Conexion<Servicio> implements GenericDao<Servicio>{

	public ServicioDAO(){
		super(Servicio.class);
	}

	@Override
	public <E> Servicio find(E id) {
		// TODO Auto-generated method stub
		return null;
	}
}
