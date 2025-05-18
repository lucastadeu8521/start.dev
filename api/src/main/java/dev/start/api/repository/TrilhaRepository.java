package dev.start.api.repository;

import dev.start.api.domain.Trilha;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrilhaRepository extends JpaRepository<Trilha, Long> {
    List<Trilha> findByCursoId(Long cursoId);
}
