package br.com.ademar.textformatter.repository;

import br.com.ademar.textformatter.model.ChamadoPje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChamadoPjeRepository extends JpaRepository<ChamadoPje, Long> {
}
