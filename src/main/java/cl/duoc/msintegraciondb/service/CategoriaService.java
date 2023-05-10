package cl.duoc.msintegraciondb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.duoc.msintegraciondb.model.dto.CategoriaDTO;
import cl.duoc.msintegraciondb.model.entities.Categoria;
import cl.duoc.msintegraciondb.model.repository.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    public CategoriaDTO getCategoriaById(int idCategoria){      
        Categoria categoria = categoriaRepository.getReferenceById(idCategoria);

        CategoriaDTO categoriaDTO = new CategoriaDTO();
        categoriaDTO.setId(categoria.getId());
        categoriaDTO.setNombre(categoria.getNombre());
        
        return categoriaDTO;
    }
    
}
