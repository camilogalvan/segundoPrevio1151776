package co.edu.ufps.segundoPrevio.dao;

import co.edu.ufps.segundoPrevio.model.Seguir;
import co.edu.ufps.segundoPrevio.util.Conexion;

public class SeguirDAO extends Conexion<Seguir> implements GenericDao<Seguir>{

	public SeguirDAO(){
		super(Seguir.class);
	}

	@Override
	public <E> Seguir find(E id) {
		// TODO Auto-generated method stub
		return null;
	}
}
