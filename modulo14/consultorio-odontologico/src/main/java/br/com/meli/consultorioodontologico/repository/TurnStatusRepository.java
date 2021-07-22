package br.com.meli.consultorioodontologico.repository;

import br.com.meli.consultorioodontologico.domain.TurnStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurnStatusRepository extends JpaRepository<TurnStatus, Long> {
}
