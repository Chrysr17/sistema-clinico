package com.clinica.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "medicamento")
public class Medicamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_medicamento")
    private Integer idMedicamento;

    @Column(name = "nombre_medicamento", nullable = false, length = 100)
    private String nombreMedicamento;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    public Medicamento() {
    }

    public Medicamento(Integer idMedicamento, String descripcion, String nombreMedicamento) {
        this.idMedicamento = idMedicamento;
        this.descripcion = descripcion;
        this.nombreMedicamento = nombreMedicamento;
    }

    public Integer getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(Integer idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public String getNombreMedicamento() {
        return nombreMedicamento;
    }

    public void setNombreMedicamento(String nombreMedicamento) {
        this.nombreMedicamento = nombreMedicamento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
