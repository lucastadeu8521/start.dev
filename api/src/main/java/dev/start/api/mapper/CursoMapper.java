package dev.start.api.mapper;

import dev.start.api.domain.Curso;
import dev.start.api.domain.Trilha;
import dev.start.api.dto.CursoRequest;
import dev.start.api.dto.CursoResponse;
import dev.start.api.dto.TrilhaRequest;
import dev.start.api.dto.TrilhaResponse;

import java.util.List;
import java.util.stream.Collectors;

public class CursoMapper {

    public static Curso toEntity(CursoRequest request) {
        Curso curso = new Curso();
        curso.setNome(request.getNome());
        curso.setDescricao(request.getDescricao());

        if (request.getTrilhas() != null) {
            List<Trilha> trilhas = request.getTrilhas().stream()
                    .map(trilhaReq -> {
                        Trilha trilha = new Trilha();
                        trilha.setTitulo(trilhaReq.getTitulo());
                        trilha.setDescricao(trilhaReq.getDescricao());
                        trilha.setCurso(curso); // link reverso
                        return trilha;
                    }).collect(Collectors.toList());
            curso.setTrilhas(trilhas);
        }

        return curso;
    }

    public static CursoResponse toResponse(Curso curso) {
        CursoResponse response = new CursoResponse();
        response.setId(curso.getId());
        response.setNome(curso.getNome());
        response.setDescricao(curso.getDescricao());

        if (curso.getTrilhas() != null) {
            List<TrilhaResponse> trilhas = curso.getTrilhas().stream()
                    .map(trilha -> new TrilhaResponse(trilha.getId(), trilha.getTitulo(), trilha.getDescricao()))
                    .collect(Collectors.toList());
            response.setTrilhas(trilhas);
        }

        return response;
    }
}
