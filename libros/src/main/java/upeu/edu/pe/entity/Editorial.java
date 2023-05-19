package upeu.edu.pe.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name = "editorial")
public class Editorial {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ideditorial")
	private Long ideditorial;
	private String nombre;
	private String pais;

	@OneToMany(mappedBy = "editorial")
	private List<Libro> libros;

}
