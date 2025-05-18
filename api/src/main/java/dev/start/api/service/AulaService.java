package dev.start.api.service;

import dev.start.api.domain.Aula;
import dev.start.api.domain.Trilha;
import dev.start.api.dto.AulaRequest;
import dev.start.api.dto.AulaResponse;
import dev.start.api.mapper.AulaMapper;
import dev.start.api.repository.AulaRepository;
import dev.start.api.repository.TrilhaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AulaService {

    private final AulaRepository aulaRepository;
    private final TrilhaRepository trilhaRepository;

    public AulaService(AulaRepository aulaRepository, TrilhaRepository trilhaRepository) {
        this.aulaRepository = aulaRepository;
        this.trilhaRepository = trilhaRepository;
    }

    @Transactional
    public AulaResponse criar(AulaRequest request) {
        Trilha trilha = trilhaRepository.findById(request.getTrilhaId())
                .orElseThrow(() -> new RuntimeException("Trilha não encontrada"));
        Aula aula = AulaMapper.toEntity(request, trilha);
        return AulaMapper.toResponse(aulaRepository.save(aula));
    }

    public List<AulaResponse> listarTodas() {
        return aulaRepository.findByAtivaTrue().stream()
                .map(AulaMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Transactional
    public AulaResponse atualizar(Long id, AulaRequest request) {
        Aula aula = aulaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aula não encontrada"));

        aula.setTitulo(request.getTitulo());
        aula.setDescricao(request.getDescricao());
        aula.setLink(request.getLink());
        aula.setCategoria(request.getCategoria());

        return AulaMapper.toResponse(aulaRepository.save(aula));
    }

    @Transactional
    public void desativar(Long id) {
        Aula aula = aulaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aula não encontrada"));
        aula.setAtiva(false);
        aulaRepository.save(aula);
    }
}
