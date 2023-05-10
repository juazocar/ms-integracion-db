package cl.duoc.msintegraciondb.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoriaDTO {
    
    @JsonProperty("id_categoria")
    private int id;
    @JsonProperty("nombre_categoria")
    private String nombre;
}
