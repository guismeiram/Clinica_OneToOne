package br.com.Clinica_OneToOne.dto;

import br.com.Clinica_OneToOne.models.Paciente;

import java.time.LocalDateTime;

public class ConsultaDTO {
    private Long id;
    private LocalDateTime data_hora;
    private String numero;
    private String especialidade;
    private Paciente paciente;

}
