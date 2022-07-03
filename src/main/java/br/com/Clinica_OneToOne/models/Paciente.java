package br.com.Clinica_OneToOne.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "TB_PACIENTE")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;

    public long getAllId() {
        return (id.equals(0) ? null : id);

    }
}
