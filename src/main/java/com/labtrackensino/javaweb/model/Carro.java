package com.labtrackensino.javaweb.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "CARRO")
@SequenceGenerator(name = "SEQ_CARRO", allocationSize = 10, sequenceName = "SEQ_CARRO")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Carro implements Entidade, Veiculo {


	@Id
	@Column(name = "SEQ_CARRO")
	@GeneratedValue(generator = "SEQ_CARRO", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "MARCA", length = 100)
	private String marca;

	@Column(name = "ANO_FABRICACAO")
	private Integer anoFabricacao;


	@Column(name = "ANO_MODELO")
	private Integer anoModelo;

	@Column(name = "POTENCIA")
	private Double potencia;

	@Column(name = "QUILOMETRAGEM")
	private BigDecimal quilometragem;

	@Column(name = "NUMERO_MOTOR")
	private String numeroMotor;

	public String getMarca() {
		return marca;
	}

	public Integer getAnoFabricacao() {
		return anoFabricacao;
	}

	public Integer getAnoModelo() {
		return anoModelo;
	}

	public Double getPotencia() {
		return potencia;
	}

	public BigDecimal getQuilometragem() {
		return quilometragem;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public String getNumeroMotor() {
		return numeroMotor;
	}
}
