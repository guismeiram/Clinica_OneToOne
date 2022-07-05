package br.com.Clinica_OneToOne.dto;

import java.io.Serializable;

public class PacienteDTO {
    private Long id;
    private String nome;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
    
    
}
