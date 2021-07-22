package br.com.meli.consultorioodontologico.repository;

import br.com.meli.consultorioodontologico.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
