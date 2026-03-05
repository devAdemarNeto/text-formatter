package br.com.ademar.textformatter.repository;

import br.com.ademar.textformatter.model.RemoverDoAD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RemoverDoADRepository extends JpaRepository<RemoverDoAD, Long> {
}
