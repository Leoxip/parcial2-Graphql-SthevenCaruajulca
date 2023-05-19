package upeu.edu.pe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import upeu.edu.pe.dto.LibroRequest;
import upeu.edu.pe.entity.Autor;
import upeu.edu.pe.entity.Editorial;
import upeu.edu.pe.entity.Libro;
import upeu.edu.pe.repository.AutorRepository;
import upeu.edu.pe.repository.EditorialRepository;
import upeu.edu.pe.repository.LibroRepository;

@Controller
public class LibroController {

	@Autowired
	private EditorialRepository editorialRepository;

	@Autowired
	private LibroRepository libroRepository;
	
	@Autowired
	private AutorRepository autorRepository;

	

	@QueryMapping
	public List<Libro> listarLibros() {
		return libroRepository.findAll();
	}
	
	@QueryMapping
	public List<Editorial> listarEditoriales() {
		return editorialRepository.findAll();
	}

	@QueryMapping
	public Libro listarLibrosPorId(@Argument String id) {
		return libroRepository.findById(id).orElse(null);
	}

	@MutationMapping
	
	public Libro guardarLibro(@Argument LibroRequest libroRequest) {
		Autor autor = autorRepository.findById(libroRequest.idautor()).orElse(null);
		Editorial editorial = editorialRepository.findById(libroRequest.ideditorial()).orElse(null);
		
		Libro libroBBDD = new Libro();
		libroBBDD.setTitulo(libroRequest.titulo());
		libroBBDD.setDescripcion(libroRequest.descripcion());
		libroBBDD.setPaginas(libroRequest.paginas());
		libroBBDD.setEdicion(libroRequest.edicion());
		
		libroBBDD.setAutor(autor);
		libroBBDD.setEditorial(editorial);

		return libroRepository.save(libroBBDD);
	}
	
	 @MutationMapping
	    public boolean eliminarLibros(@Argument String id){
	    	libroRepository.deleteById(id);
			return true;
	    }
	 
	 @MutationMapping
	    public Libro actualizarLibros(@Argument String id, @Argument LibroRequest libroRequest){
		 Autor autor = autorRepository.findById(libroRequest.idautor()).orElse(null);
			Editorial editorial = editorialRepository.findById(libroRequest.ideditorial()).orElse(null);
			Libro libroBBDD = new Libro();
			libroBBDD.setTitulo(libroRequest.titulo());
			libroBBDD.setDescripcion(libroRequest.descripcion());
			libroBBDD.setPaginas(libroRequest.paginas());
			libroBBDD.setEdicion(libroRequest.edicion());
	        
	        libroBBDD.setAutor(autor);
	        libroBBDD.setEditorial(editorial);

	        return libroRepository.save(libroBBDD);
		}
}
