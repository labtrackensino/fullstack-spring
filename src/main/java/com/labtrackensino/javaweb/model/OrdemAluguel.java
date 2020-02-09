package com.labtrackensino.javaweb.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ORDEM_ALUGUEL")
@SequenceGenerator(name = "SEQ_ORDEM_ALUGUEL", allocationSize = 10, sequenceName = "SEQ_ORDEM_ALUGUEL")
@JsonIgnoreProperties( ignoreUnknown = true)
public class OrdemAluguel  implements Entidade {


	@Id
	@Column(name = "ID_ORDEM_ALUGUEL")
	@GeneratedValue(generator = "SEQ_ORDEM_ALUGUEL", strategy = GenerationType.SEQUENCE)
	private Long id;

	@ManyToOne()
	@JoinColumn(name = "ID_CLIENTE",
			foreignKey =
			@ForeignKey(name = "FK_ORDEM_ALUGUEL_CLIENTE",
					value = ConstraintMode.CONSTRAINT))
	private Cliente cliente;

	@ManyToMany(cascade = {CascadeType.DETACH}, fetch = FetchType.EAGER)
	@JoinTable(name = "CARROS_ORDEM",
			joinColumns = {
					@JoinColumn(name = "ID_ORDEM", referencedColumnName = "ID_ORDEM_ALUGUEL")
			},
			inverseJoinColumns = {
					@JoinColumn(name = "ID_CARRO", referencedColumnName = "ID_CARRO")
			})
	private List<Carro> carros = new ArrayList<>();

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DT_ALUGUEL")
	private Date dataAluguel;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DT_DEVOLUCAO")
	private Date dataDevolucao;

	@Override
	public Long getId() {
		return id;
	}

	public OrdemAluguel() {
	}
}
