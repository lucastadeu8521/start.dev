package dev.start.api.mapper;

import dev.start.api.domain.Aula;
import dev.start.api.domain.Trilha;
import dev.start.api.dto.AulaRequest;
import dev.start.api.dto.AulaResponse;

public class AulaMapper {

    public static Aula toEntity(AulaRequest request, Trilha trilha) {
        Aula aula = new Aula();
        aula.setTitulo(request.getTitulo());
        aula.setDescricao(request.getDescricao());
        aula.setLink(request.getLink());
        aula.setCategoria(request.getCategoria());
        aula.setTrilha(trilha);
        return aula;
    }

    public static AulaResponse toResponse(Aula aula) {
        return new AulaResponse(
                aula.getId(),
                aula.getTitulo(),
                aula.getDescricao(),
                aula.getLink(),
                aula.getCategoria(),
                aula.isAtiva()
        );
    }
}
