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
	@Column(name = "ID_CARRO")
	@GeneratedValue(generator = "SEQ_CARRO", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "NOME", length = 100)
	private String nome;

	@Column(name = "MODELO", length = 100)
	private String modelo;

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

	public String getNome() {
		return nome;
	}

	public String getModelo() {
		return modelo;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public String getNumeroMotor() {
		return numeroMotor;
	}

	public Carro() {
	}
}
