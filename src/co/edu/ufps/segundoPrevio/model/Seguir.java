package co.edu.ufps.segundoPrevio.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

@Table(name = "seguir")

public class Seguir implements Serializable{

	@Id
	@JoinColumn(name = "cliente", nullable = false)
	@ManyToOne
	private Cliente cliente;

	@JoinColumn(name = "tienda", nullable = false)
	@ManyToOne
	private Tienda tienda;
}
