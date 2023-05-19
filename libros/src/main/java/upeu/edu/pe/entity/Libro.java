package upeu.edu.pe.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "libro")
public class Libro {
	@Id
	@Column(name = "idlibro")
	private String idlibro;
	private String titulo;
	private String descripcion;
	private int paginas;
	private String edicion;

	@ManyToOne
	@JoinColumn(name = "idautor")
	private Autor autor;

	@ManyToOne
	@JoinColumn(name = "ideditorial")
	private Editorial editorial;
}
