package cl.duoc.msintegraciondb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
