package co.edu.ufps.segundoPrevio.dao;

import co.edu.ufps.segundoPrevio.model.Cliente;
import co.edu.ufps.segundoPrevio.util.Conexion;

public class ClienteDAO extends Conexion<Cliente> implements GenericDao<Cliente>{

	public ClienteDAO(){
		super(Cliente.class);
	}

	@Override
	public <E> Cliente find(E id) {
		// TODO Auto-generated method stub
		return null;
	}
}
