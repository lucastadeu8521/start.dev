package dev.start.api.dto;

import java.util.List;

public class CursoRequest {
    private String nome;
    private String descricao;
    private List<TrilhaRequest> trilhas;

    public CursoRequest() {}

    public CursoRequest(String nome, String descricao, List<TrilhaRequest> trilhas) {
        this.nome = nome;
        this.descricao = descricao;
        this.trilhas = trilhas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<TrilhaRequest> getTrilhas() {
        return trilhas;
    }

    public void setTrilhas(List<TrilhaRequest> trilhas) {
        this.trilhas = trilhas;
    }
}
