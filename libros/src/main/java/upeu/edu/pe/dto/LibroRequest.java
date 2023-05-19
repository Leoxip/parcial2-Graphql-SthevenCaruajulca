package upeu.edu.pe.dto;

public record LibroRequest(

		String idlibro,
		String titulo, 
		String descripcion, 
		int paginas,

		String edicion,
		Long idautor,
		Long ideditorial

) {

}
