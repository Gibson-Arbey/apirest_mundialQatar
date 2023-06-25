package co.edu.ufps.qatar.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="continente")
public class ContinenteEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	  
    @Id
	@SequenceGenerator(name="continente_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="continente_id_seq")
    private Integer id;

	@Column(length = 50, nullable = false)
    private String nombre;

	@JsonIgnore
	@OneToMany(mappedBy = "continente", cascade = CascadeType.ALL)
	private List<SeleccionEntity> seleccion;
}
