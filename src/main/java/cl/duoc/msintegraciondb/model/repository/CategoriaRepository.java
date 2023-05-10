package cl.duoc.msintegraciondb.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.duoc.msintegraciondb.model.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{
    
}
