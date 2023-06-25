package co.edu.ufps.qatar.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "seleccion")
public class SeleccionEntity implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="seleccion_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seleccion_id_seq")
	private Integer id;

    @Column(length = 100, nullable = false)
    @NotEmpty
    private String nombre;

    @ManyToOne
    @JoinColumn(name="continente_id", nullable = false)
    private ContinenteEntity continente;

    @Column(length = 1, nullable = false)
    @NotEmpty
    private String grupo;

    @JsonIgnore
	@OneToMany(mappedBy = "seleccion", cascade = CascadeType.ALL)
	private List<ResultadoEntity> resultado;
}
