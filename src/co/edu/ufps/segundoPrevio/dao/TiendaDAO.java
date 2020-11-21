package co.edu.ufps.segundoPrevio.dao;


import co.edu.ufps.segundoPrevio.model.Tienda;
import co.edu.ufps.segundoPrevio.util.Conexion;

public class TiendaDAO extends Conexion<Tienda> implements GenericDao<Tienda>{

	public TiendaDAO(){
		super(Tienda.class);
	}

	@Override
	public <E> Tienda find(E id) {
		// TODO Auto-generated method stub
		return null;
	}
}
