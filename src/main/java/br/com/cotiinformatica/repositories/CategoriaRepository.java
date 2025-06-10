package br.com.cotiinformatica.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import br.com.cotiinformatica.entities.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, UUID> {
	
	@NonNull
	@Query("""
			SELECT c FROM Categoria c
			ORDER BY c.nome ASC			
			""")
	public List<Categoria> findAll();
	
	@Query("""
		    SELECT c FROM Categoria c
		    WHERE c.nome = :name
		""")
	public Categoria findByName(@Param("name") String name);
}
