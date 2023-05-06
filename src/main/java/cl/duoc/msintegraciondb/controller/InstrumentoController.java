package cl.duoc.msintegraciondb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.msintegraciondb.model.entities.Categoria;
import cl.duoc.msintegraciondb.model.entities.Instrumento;
import cl.duoc.msintegraciondb.service.InstrumentoService;

@RestController
@RequestMapping("/instrumentos-db")
public class InstrumentoController {
    
    @Autowired
    InstrumentoService instrumentoService;
    
    @GetMapping(path = "/saludo", produces = { "application/json" })
    public String getSaludo(){
        return instrumentoService.getSaludo();
    }

    @GetMapping(path = "/get-all", produces = {"application/json"})
    public List<Instrumento> findAll() {
        return instrumentoService.obtenerTodosLosInstrumentos();
    }
    

    @GetMapping(path = "/get-all-categoria", produces = {"application/json"})
    public List<Categoria> findAllCategoria() {
        return instrumentoService.obtenerTodasLasCategorias();
    }
}
