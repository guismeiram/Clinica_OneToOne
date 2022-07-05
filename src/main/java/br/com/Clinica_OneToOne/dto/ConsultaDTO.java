package br.com.Clinica_OneToOne.dto;

import br.com.Clinica_OneToOne.models.Paciente;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ConsultaDTO  {
    private Long id;
    private LocalDateTime data_hora;
    private String numero;
    private String especialidade;
    private Paciente paciente;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDateTime getData_hora() {
		return data_hora;
	}
	public void setData_hora(LocalDateTime data_hora) {
		this.data_hora = data_hora;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
    
    
}
