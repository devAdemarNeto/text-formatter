package br.com.ademar.textformatter.repository;

import br.com.ademar.textformatter.model.DevolucaoEquipamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevolucaoEquipamentoRepository extends JpaRepository<DevolucaoEquipamento, Long> {
}
