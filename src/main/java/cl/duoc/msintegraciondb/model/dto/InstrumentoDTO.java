package cl.duoc.msintegraciondb.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class InstrumentoDTO {
    
    private int idInstrumento;
    private String nombre;
    private String marca;
    @JsonProperty("categoria_instrumento")
    private CategoriaDTO categoria;
}
