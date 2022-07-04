package br.com.Clinica_OneToOne.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)

@Entity
@Getter
@Setter
@Table(name = "TB_CONSULTA")
public class Consulta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime data_hora;
    private String numero;
    private String especialidade;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paciente")
    private Paciente paciente;

    public long getAllId() {
        return (id.equals(0) ? null : id);
    }

}
