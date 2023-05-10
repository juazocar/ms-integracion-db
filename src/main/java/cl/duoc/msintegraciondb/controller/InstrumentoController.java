package cl.duoc.msintegraciondb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.msintegraciondb.model.dto.InstrumentoDTO;
import cl.duoc.msintegraciondb.service.InstrumentoService;

@RestController
@RequestMapping("/instrumentos-db")
public class InstrumentoController {
    
    @Autowired
    InstrumentoService instrumentoService;
    
    @GetMapping(path = "/health-check", produces = { "application/json" })
    public String healthCheck(){
        return "OK";
    }

    @GetMapping(path = "/get-all", produces = {"application/json"})
    public List<InstrumentoDTO> findAll() {
        return instrumentoService.obtenerTodosLosInstrumentos();
    }
    

}
