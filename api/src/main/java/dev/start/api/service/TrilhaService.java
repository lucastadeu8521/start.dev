package dev.start.api.service;

import dev.start.api.domain.Trilha;
import dev.start.api.domain.Curso;
import dev.start.api.dto.TrilhaRequest;
import dev.start.api.dto.TrilhaResponse;
import dev.start.api.mapper.TrilhaMapper;
import dev.start.api.repository.TrilhaRepository;
import dev.start.api.repository.CursoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrilhaService {

    private final TrilhaRepository trilhaRepository;
    private final CursoRepository cursoRepository;

    public TrilhaService(TrilhaRepository trilhaRepository, CursoRepository cursoRepository) {
        this.trilhaRepository = trilhaRepository;
        this.cursoRepository = cursoRepository;
    }

    @Transactional
    public TrilhaResponse criar(TrilhaRequest request) {
        Curso curso = cursoRepository.findById(request.getCursoId())
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));

        Trilha trilha = TrilhaMapper.toEntity(request, curso);
        return TrilhaMapper.toResponse(trilhaRepository.save(trilha));
    }

    public List<TrilhaResponse> listarPorCurso(Long cursoId) {
        return trilhaRepository.findByCursoId(cursoId).stream()
                .map(TrilhaMapper::toResponse)
                .collect(Collectors.toList());
    }

    public TrilhaResponse buscarPorId(Long id) {
        Trilha trilha = trilhaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trilha não encontrada"));
        return TrilhaMapper.toResponse(trilha);
    }

    @Transactional
    public TrilhaResponse atualizar(Long id, TrilhaRequest request) {
        Trilha trilha = trilhaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trilha não encontrada"));

        trilha.setTitulo(request.getTitulo());
        trilha.setDescricao(request.getDescricao());

        return TrilhaMapper.toResponse(trilhaRepository.save(trilha));
    }

    @Transactional
    public void deletar(Long id) {
        trilhaRepository.deleteById(id);
    }
}
