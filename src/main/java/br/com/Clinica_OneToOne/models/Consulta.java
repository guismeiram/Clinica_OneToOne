package br.com.Clinica_OneToOne.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "TB_CONSULTA")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime data_hora;
    private String numero;
    private String especialidade;

    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="paciente_id")
    private Paciente paciente;


    public long getAllId() {
        return (id.equals(0) ? null : id);

    }
}
