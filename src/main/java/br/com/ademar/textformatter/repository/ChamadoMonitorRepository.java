package br.com.ademar.textformatter.repository;

import br.com.ademar.textformatter.model.ChamadoMonitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChamadoMonitorRepository extends JpaRepository<ChamadoMonitor, Long> {
}
