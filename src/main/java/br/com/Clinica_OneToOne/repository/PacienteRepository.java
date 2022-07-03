package br.com.Clinica_OneToOne.repository;

import br.com.Clinica_OneToOne.models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente,Long>{

}
