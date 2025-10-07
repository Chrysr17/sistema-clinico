package com.clinica.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "analisis")
public class Analisis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_analisis")
    private Integer idAnalisis;

    @Column(name = "nombre_analisis", nullable = false, length = 100)
    private String nombreAnalisis;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    public Analisis() {
    }

    public Analisis(String nombreAnalisis, Integer idAnalisis, String descripcion) {
        this.nombreAnalisis = nombreAnalisis;
        this.idAnalisis = idAnalisis;
        this.descripcion = descripcion;
    }

    public Integer getIdAnalisis() {
        return idAnalisis;
    }

    public void setIdAnalisis(Integer idAnalisis) {
        this.idAnalisis = idAnalisis;
    }

    public String getNombreAnalisis() {
        return nombreAnalisis;
    }

    public void setNombreAnalisis(String nombreAnalisis) {
        this.nombreAnalisis = nombreAnalisis;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescricion(String descricion) {
        this.descripcion = descricion;
    }
}
