package br.com.Clinica_OneToOne.repository;

import br.com.Clinica_OneToOne.models.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    Consulta findById(long id);
}
