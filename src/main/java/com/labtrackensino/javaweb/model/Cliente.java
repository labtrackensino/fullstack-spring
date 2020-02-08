package com.labtrackensino.javaweb.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "CLIENTES")
@SequenceGenerator(name = "SEQ_CLIENTE", allocationSize = 1, sequenceName = "SEQ_CLIENTE")
public class Cliente implements Entidade {

	@Id
	@Column(name = "ID_CLIENTE")
	@GeneratedValue(generator = "SEQ_CLIENTE", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Size(min = 11, max = 20)
	@Column(name = "NR_DOCUMENTO", length = 20)
	private String documento;

	@NotNull
	@Size(min = 5, max = 80)
	@Column(name = "NOME_CLIENTE", length = 80)
	private String nome;

	@Column(name = "TELEFONE", length = 20)
	private String telefone;

	@Email
	@Column(name = "EMAIL", length = 120)
	private String email;

	@Override
	public Long getId() {
		return id;
	}
}
