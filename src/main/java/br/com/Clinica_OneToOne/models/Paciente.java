package br.com.Clinica_OneToOne.models;

import lombok.Getter;

import lombok.Setter;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.io.Serializable;


@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)

@Setter
@Getter
@Entity
@Table(name = "TB_PACIENTE")
public class Paciente implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    public long getAllId() {
        return (id.equals(0) ? null : id);
    }


}
