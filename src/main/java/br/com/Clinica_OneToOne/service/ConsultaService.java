package br.com.Clinica_OneToOne.service;

import br.com.Clinica_OneToOne.exception.ClinicaNotFoundException;
import br.com.Clinica_OneToOne.exception.ResourceNotFoundException;
import br.com.Clinica_OneToOne.models.Consulta;
import br.com.Clinica_OneToOne.models.Paciente;
import br.com.Clinica_OneToOne.repository.ConsultaRepository;
import br.com.Clinica_OneToOne.repository.PacienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConsultaService {
    @Autowired
    private final ConsultaRepository consultaRepository;
    @Autowired
    private final PacienteRepository pacienteRepository;


    public ConsultaService(ConsultaRepository consultaRepository, PacienteRepository pacienteRepository) {
        this.consultaRepository = consultaRepository;
		this.pacienteRepository = pacienteRepository;
    }

    public Consulta createConsulta(Consulta consulta) {

        return consultaRepository.save(consulta);

    }
    public Consulta getConsultaById(long id) throws ClinicaNotFoundException {
        Optional<Consulta> result = consultaRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }else{
            throw new ResourceNotFoundException();
        }
    }

    public void deleteConsulta(long id)  throws ClinicaNotFoundException{
        Consulta consulta = consultaRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException());

        consultaRepository.delete(consulta);
    }

    public Consulta updateById(Consulta consultaRequest,Long id) throws ClinicaNotFoundException{
        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException());
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException());
        //consulta
        consulta.setData_hora(consultaRequest.getData_hora());
        consulta.setEspecialidade(consultaRequest.getEspecialidade());
        consulta.setNumero(consultaRequest.getNumero());
        //paciente
        paciente.setNome(consultaRequest.getPaciente().getNome());
        //consulta e paciente
        consulta.setPaciente(paciente);
        return consultaRepository.save(consulta);

    }
}
