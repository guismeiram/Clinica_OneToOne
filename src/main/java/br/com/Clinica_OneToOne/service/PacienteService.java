package br.com.Clinica_OneToOne.service;

import br.com.Clinica_OneToOne.exception.ClinicaNotFoundException;
import br.com.Clinica_OneToOne.exception.ResourceNotFoundException;
import br.com.Clinica_OneToOne.models.Paciente;
import br.com.Clinica_OneToOne.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {
    @Autowired
    private final PacienteRepository pacienteRepository;

    @Autowired
    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public Paciente createPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public List<Paciente> findAll() {
        return pacienteRepository.findAll();

    }

    public Paciente getMedicoById(long id) throws ClinicaNotFoundException{
        Optional<Paciente> result = pacienteRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }else{
            throw new ResourceNotFoundException();
        }
    }

    public void deleteMedico(long id)  throws ClinicaNotFoundException{
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException());

        pacienteRepository.delete(paciente);
    }

    public Paciente updateById(Long id, Paciente pacienteRequest) throws ClinicaNotFoundException{
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException());

        paciente.setNome(pacienteRequest.getNome());
        return paciente;
    }

}
