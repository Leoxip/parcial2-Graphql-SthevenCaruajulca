package upeu.edu.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import upeu.edu.pe.entity.Libro;

public interface LibroRepository extends JpaRepository<Libro, String> {

}
