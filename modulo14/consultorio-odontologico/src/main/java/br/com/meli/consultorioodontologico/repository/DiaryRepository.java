package br.com.meli.consultorioodontologico.repository;

import br.com.meli.consultorioodontologico.domain.Diary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaryRepository extends JpaRepository<Diary, Long> {
}
