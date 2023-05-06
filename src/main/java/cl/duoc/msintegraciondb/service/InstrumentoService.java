package cl.duoc.msintegraciondb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.duoc.msintegraciondb.model.entities.Categoria;
import cl.duoc.msintegraciondb.model.entities.Instrumento;
import cl.duoc.msintegraciondb.model.repository.CategoriaRepository;
import cl.duoc.msintegraciondb.model.repository.InstrumentoRepository;

@Service
public class InstrumentoService {
    
    @Autowired
    InstrumentoRepository instrumentoRepository;

    @Autowired
    CategoriaRepository categoriaRepository;
    
    public String getSaludo(){
        return "saludo desde ms-integracion-db";
    }

    public List<Instrumento> obtenerTodosLosInstrumentos(){
        return instrumentoRepository.findAll();
    }

    public List<Categoria> obtenerTodasLasCategorias(){
        return categoriaRepository.findAll();
    }
}
