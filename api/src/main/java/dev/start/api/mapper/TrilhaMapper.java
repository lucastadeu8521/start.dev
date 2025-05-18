package dev.start.api.mapper;

import dev.start.api.domain.Trilha;
import dev.start.api.domain.Curso;
import dev.start.api.dto.TrilhaRequest;
import dev.start.api.dto.TrilhaResponse;

public class TrilhaMapper {

    public static Trilha toEntity(TrilhaRequest request, Curso curso) {
        Trilha trilha = new Trilha();
        trilha.setTitulo(request.getTitulo());
        trilha.setDescricao(request.getDescricao());
        trilha.setCurso(curso);
        return trilha;
    }

    public static TrilhaResponse toResponse(Trilha trilha) {
        return new TrilhaResponse(
                trilha.getId(),
                trilha.getTitulo(),
                trilha.getDescricao()
        );
    }
}
