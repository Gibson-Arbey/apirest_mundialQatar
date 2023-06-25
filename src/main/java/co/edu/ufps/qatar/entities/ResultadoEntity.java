package co.edu.ufps.qatar.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="resultado")
public class ResultadoEntity implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="resultado_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="resultado_id_seq")
	private Integer id;
	
    @ManyToOne
	@JoinColumn(name="partido_id", nullable = false)
    private PartidoEntity partido;

    @ManyToOne
	@JoinColumn(name="seleccion_id", nullable = false)
    private SeleccionEntity seleccion;
    
	@NotNull
	private Integer goles;
	
	@NotNull
	private Integer amarillas;
	
	@NotNull
	private Integer rojas;
}
