package cl.duoc.msintegraciondb.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;


import javax.persistence.*;

@Data
@Entity
@Table(name = "instrumento")
public class Instrumento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_instrumento")
    private int    idInstrumento;

    @Basic
    @Column (name = "nombre")
    private String nombre;

    @Basic
    @Column (name = "marca")
    private String marca;

    @Basic
    @Column(name = "id_categoria")
    private int idCategoria;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="id_categoria", referencedColumnName = "id" , insertable = false, updatable = false)
    @JsonBackReference
    private Categoria categoriaByCategoriaIdFk;
    
}