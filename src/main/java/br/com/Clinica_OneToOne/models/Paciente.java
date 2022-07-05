package br.com.Clinica_OneToOne.models;

import lombok.Getter;

import lombok.Setter;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.io.Serializable;




@Entity
@Table(name = "TB_PACIENTE")
public class Paciente{
    /**
	 *texto
	 */
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;


    /*public long getAllId() {
        return (id.equals(0) ? null : id);
    }*/

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
