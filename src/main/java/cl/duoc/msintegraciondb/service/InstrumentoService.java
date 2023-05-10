package cl.duoc.msintegraciondb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.duoc.msintegraciondb.model.dto.InstrumentoDTO;
import cl.duoc.msintegraciondb.model.entities.Instrumento;
import cl.duoc.msintegraciondb.model.repository.InstrumentoRepository;

@Service
public class InstrumentoService {
    
    @Autowired
    InstrumentoRepository instrumentoRepository;

    @Autowired
    CategoriaService categoriaService;
    
    public String getSaludo(){
        return "saludo desde ms-integracion-db";
    }

    public List<InstrumentoDTO> obtenerTodosLosInstrumentos(){
        List<InstrumentoDTO> listaInstrumentos = new ArrayList<>();

        for(Instrumento instrumento : instrumentoRepository.findAll()){
            InstrumentoDTO instrumentoDTO = new InstrumentoDTO();
            instrumentoDTO.setIdInstrumento(instrumento.getIdInstrumento());
            instrumentoDTO.setNombre(instrumento.getNombre());
            instrumentoDTO.setMarca(instrumento.getMarca());           
            instrumentoDTO.setCategoria(categoriaService.getCategoriaById(instrumento.getIdCategoria()));

            listaInstrumentos.add(instrumentoDTO);
        }
        return listaInstrumentos;
    }

  
}
