package cl.duoc.msintegraciondb.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoriaDTO {
    
    @JsonProperty("category_id")
    private int id;
    @JsonProperty("category_name")
    private String nombre;
}
