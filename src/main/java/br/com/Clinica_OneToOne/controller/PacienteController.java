package br.com.Clinica_OneToOne.controller;

import br.com.Clinica_OneToOne.dto.PacienteDTO;
import br.com.Clinica_OneToOne.exception.ClinicaNotFoundException;
import br.com.Clinica_OneToOne.models.Paciente;
import br.com.Clinica_OneToOne.service.PacienteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/api/paciente")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private ModelMapper modelMapper;

    public PacienteController(PacienteService pacienteService, ModelMapper modelMapper) {
        this.pacienteService = pacienteService;
        this.modelMapper = modelMapper;
    }
    
    @PostMapping
    public ResponseEntity<PacienteDTO> createPaciente(@RequestBody PacienteDTO pacienteDTO) {
        Paciente pacienteInsere = new Paciente();
        // convert DTO to entity
        Paciente pacienteRequest = modelMapper.map(pacienteDTO, Paciente.class);
        pacienteRequest.setNome(pacienteInsere.getNome());

        Paciente paciente = pacienteService.createPaciente(pacienteRequest);

        // convert entity to DTO
        PacienteDTO pacienteResponse = modelMapper.map(paciente, PacienteDTO.class);

        return new ResponseEntity<PacienteDTO>(pacienteResponse, HttpStatus.CREATED);
    }

    @GetMapping
    public List<PacienteDTO> getAllPaciente() {
        return pacienteService.findAll().stream().map(post -> modelMapper.map(post, PacienteDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDTO> getPacienteById(@PathVariable(name = "id") Long id) throws ClinicaNotFoundException {
        Paciente paciente = pacienteService.getMedicoById(id);

        // convert entity to DTO
        PacienteDTO pacienteResponse = modelMapper.map(paciente, PacienteDTO.class);

        return ResponseEntity.ok().body(pacienteResponse);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePaciente(@PathVariable(name = "id") Long id) throws ClinicaNotFoundException {
        pacienteService.deleteMedico(id);

    }

    @PutMapping("/{id}")
    public ResponseEntity<PacienteDTO> updatePaciente(@RequestBody PacienteDTO pacienteDTO, @PathVariable long id) throws ClinicaNotFoundException {
        Paciente pacienteRequest = modelMapper.map(pacienteDTO, Paciente.class);

        Paciente paciente = pacienteService.updateById(id, pacienteRequest);

        // convert entity to DTO
        PacienteDTO pacienteResponse = modelMapper.map(paciente, PacienteDTO.class);

        return ResponseEntity.ok().body(pacienteResponse);
    }

}
