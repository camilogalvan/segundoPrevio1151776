package co.edu.ufps.segundoPrevio.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

@Table(name = "cliente")
@NamedQuery(name = "Cliente.findAll", query = "SELECT u FROM Cliente u")

public class Cliente implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(length = 11)
	private Integer id;
	
	@Column(length = 100)
	private String nombre;
	
	@Column(length = 100)
	private String email;
	
	@Column(length = 100)
	private String clave;
	
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	private Set<Seguir> seguir = new HashSet<Seguir>();

}
