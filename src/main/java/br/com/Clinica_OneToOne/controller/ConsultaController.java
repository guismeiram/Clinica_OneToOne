package br.com.Clinica_OneToOne.controller;

import br.com.Clinica_OneToOne.dto.ConsultaDTO;
import br.com.Clinica_OneToOne.exception.ClinicaNotFoundException;
import br.com.Clinica_OneToOne.models.Consulta;
import br.com.Clinica_OneToOne.service.ConsultaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/api/consulta")
public class ConsultaController {
    @Autowired
    private ConsultaService consultaService;

    @Autowired
    private ModelMapper mapper;

    public ConsultaController(ConsultaService consultaService, ModelMapper mapper) {
        this.consultaService = consultaService;
        this.mapper = mapper;
    }

    @PostMapping
    @Transactional
    public ConsultaDTO createConsulta(@RequestBody ConsultaDTO consultaDTO)
    {
        Consulta consultaRequest = mapper.map(consultaDTO, Consulta.class);
        //consultaRequest.getConsultorio().forEach(c ->c.setNumero(c.getNumero()));
        //Paciente
       consultaRequest.getPaciente().getNome();
       //consulta
        consultaRequest.getNumero();
        consultaRequest.getEspecialidade();
        consultaRequest.getData_hora();

        //Grava na Memoria
        Consulta consulta = consultaService.createConsulta(consultaRequest);
        // convert entity to DTO
        return mapper.map(consulta, ConsultaDTO.class);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultaDTO> getConsultaById(@PathVariable(name = "id") Long id) throws ClinicaNotFoundException {
        Consulta consulta = consultaService.getConsultaById(id);

        // convert entity to DTO
        ConsultaDTO consultaResponse = mapper.map(consulta, ConsultaDTO.class);

        return ResponseEntity.ok().body(consultaResponse);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteConsulta(@PathVariable(name = "id") Long id) throws ClinicaNotFoundException {
        consultaService.deleteConsulta(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsultaDTO> updateConsulta(@RequestBody ConsultaDTO consultaDTO, @PathVariable long id) throws ClinicaNotFoundException {
        Consulta consultaRequest = mapper.map(consultaDTO, Consulta.class);

        Consulta consulta = consultaService.updateById(consultaRequest, id);

        // convert entity to DTO
        ConsultaDTO consultaResponse = mapper.map(consulta, ConsultaDTO.class);

        return ResponseEntity.ok().body(consultaResponse);
    }

}
