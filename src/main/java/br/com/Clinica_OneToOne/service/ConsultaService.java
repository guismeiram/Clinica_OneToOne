package br.com.Clinica_OneToOne.service;

import br.com.Clinica_OneToOne.exception.ClinicaNotFoundException;
import br.com.Clinica_OneToOne.exception.ResourceNotFoundException;
import br.com.Clinica_OneToOne.models.Consulta;
import br.com.Clinica_OneToOne.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConsultaService {
    @Autowired
    private final ConsultaRepository consultaRepository;

    public ConsultaService(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
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
        consultaRequest = consultaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException());

        //consulta
        consultaRequest.getData_hora();
        consultaRequest.getEspecialidade();
        consultaRequest.getNumero();

        //paciente
        consultaRequest.getPaciente().getNome();



        return consultaRequest;

    }
}
