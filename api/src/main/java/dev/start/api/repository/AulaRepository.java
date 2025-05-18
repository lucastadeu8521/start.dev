package dev.start.api.repository;

import dev.start.api.domain.Aula;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AulaRepository extends JpaRepository<Aula, Long> {
    List<Aula> findByAtivaTrue();
}
