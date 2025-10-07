package com.clinica.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "nota_pago")
public class NotaPago {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pago")
	private Integer idPago;
	
	@Column(name = "monto", nullable = false)
	private BigDecimal monto;
	
	@Column(name = "fecha_pago", insertable = false, updatable = false)
	private LocalDateTime fechaPago;
	
	@ManyToOne
	@JoinColumn(name = "id_paciente", nullable = false)
	private Paciente paciente;
	
	@ManyToOne
	@JoinColumns({
        @JoinColumn(name = "id_horario", referencedColumnName = "id_horario"),
        @JoinColumn(name = "id_medico", referencedColumnName = "id_medico"),
        @JoinColumn(name = "id_hora", referencedColumnName = "id_hora")
    })
	private HorarioMedicoHora horarioMedicoHora;
	
	public NotaPago() {
		// TODO Auto-generated constructor stub
	}

	public NotaPago(Integer idPago, BigDecimal monto, LocalDateTime fechaPago, Paciente paciente,
			HorarioMedicoHora horarioMedicoHora) {
		super();
		this.idPago = idPago;
		this.monto = monto;
		this.fechaPago = fechaPago;
		this.paciente = paciente;
		this.horarioMedicoHora = horarioMedicoHora;
	}

	public Integer getIdPago() {
		return idPago;
	}

	public void setIdPago(Integer idPago) {
		this.idPago = idPago;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public LocalDateTime getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(LocalDateTime fechaPago) {
		this.fechaPago = fechaPago;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public HorarioMedicoHora getHorarioMedicoHora() {
		return horarioMedicoHora;
	}

	public void setHorarioMedicoHora(HorarioMedicoHora horarioMedicoHora) {
		this.horarioMedicoHora = horarioMedicoHora;
	}

}
