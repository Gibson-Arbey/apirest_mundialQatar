package co.edu.ufps.qatar.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="partido")
public class PartidoEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	  
    @Id
	@SequenceGenerator(name="partido_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="partido_id_seq")
    private Integer id;

	@NotNull
    private Timestamp fecha;

    @JsonIgnore
    @OneToMany(mappedBy="partido", cascade = CascadeType.ALL)
	private List<ResultadoEntity> resultado;

    @ManyToOne
	@JoinColumn(name="estadio_id", nullable = false)
    private EstadioEntity estadio;
}
