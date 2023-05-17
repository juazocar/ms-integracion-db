package cl.duoc.msintegraciondb.service;

import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import cl.duoc.msintegraciondb.model.dto.CommonResponseDTO;
import cl.duoc.msintegraciondb.model.dto.InstrumentoDTO;
import cl.duoc.msintegraciondb.model.entities.Instrumento;
import cl.duoc.msintegraciondb.model.repository.InstrumentoRepository;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class InstrumentoService {
    
    @Autowired
    InstrumentoRepository instrumentoRepository;

    @Autowired
    CategoriaService categoriaService;
    
    public String getSaludo(){
        return "saludo desde ms-integracion-db";
    }

    public CommonResponseDTO obtenerTodosLosInstrumentos(){
        CommonResponseDTO commonResponseDTO = new CommonResponseDTO();
    
        log.info("Request cl.duoc.msintegraciondb.service.InstrumentoService[obtenerTodosLosInstrumentos]");
        
        List<InstrumentoDTO> listaInstrumentos = new ArrayList<>();

        for(Instrumento instrumento : instrumentoRepository.findAll()){
            InstrumentoDTO instrumentoDTO = new InstrumentoDTO();
            instrumentoDTO.setIdInstrumento(instrumento.getIdInstrumento());
            instrumentoDTO.setNombre(instrumento.getNombre());
            instrumentoDTO.setMarca(instrumento.getMarca());           
            instrumentoDTO.setCategoria(categoriaService.getCategoriaById(instrumento.getIdCategoria()));

            listaInstrumentos.add(instrumentoDTO);
        }

        commonResponseDTO.setResponseCode("200");
        commonResponseDTO.setResponseMessage("OK");
        commonResponseDTO.setData(listaInstrumentos);

        log.info("[obtenerTodosLosInstrumento] Response: "+commonResponseDTO.toString());
        return commonResponseDTO;
     
    }

    public ResponseEntity<CommonResponseDTO> crearInstrumento(InstrumentoDTO instrumentoDTO){
        Instrumento instrumento = new Instrumento();
        instrumento.setNombre(instrumentoDTO.getNombre());
        instrumento.setMarca(instrumentoDTO.getMarca());
        instrumento.setIdCategoria(instrumentoDTO.getCategoria().getId());

        Instrumento newInstrumento = instrumentoRepository.save(instrumento);

        CommonResponseDTO commonResponseDTO = new CommonResponseDTO();
        commonResponseDTO.setResponseCode("200");
        commonResponseDTO.setResponseMessage("OK");
        commonResponseDTO.setData(newInstrumento);

        return new ResponseEntity<CommonResponseDTO>(commonResponseDTO, HttpStatus.OK);
    }
  
}
