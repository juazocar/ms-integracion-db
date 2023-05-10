package cl.duoc.msintegraciondb.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.duoc.msintegraciondb.model.entities.Instrumento;

public interface InstrumentoRepository extends JpaRepository<Instrumento, Integer>{
    
}
