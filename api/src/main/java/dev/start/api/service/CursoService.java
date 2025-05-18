package dev.start.api.service;

import dev.start.api.domain.Curso;
import dev.start.api.dto.CursoRequest;
import dev.start.api.dto.CursoResponse;
import dev.start.api.mapper.CursoMapper;
import dev.start.api.repository.CursoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @Transactional
    public CursoResponse criarCurso(CursoRequest request) {
        Curso curso = CursoMapper.toEntity(request);
        return CursoMapper.toResponse(cursoRepository.save(curso));
    }

    public List<CursoResponse> listarTodos() {
        return cursoRepository.findAll().stream()
                .map(CursoMapper::toResponse)
                .collect(Collectors.toList());
    }

    public CursoResponse buscarPorId(Long id) {
        return cursoRepository.findById(id)
                .map(CursoMapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));
    }

    @Transactional
    public CursoResponse atualizarCurso(Long id, CursoRequest request) {
        Curso cursoExistente = cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));

        cursoExistente.setNome(request.getNome());
        cursoExistente.setDescricao(request.getDescricao());

        return CursoMapper.toResponse(cursoRepository.save(cursoExistente));
    }

    @Transactional
    public void deletarCurso(Long id) {
        cursoRepository.deleteById(id);
    }
}
