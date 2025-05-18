package dev.start.api.dto;

public class AulaRequest {
    private String titulo;
    private String descricao;
    private String link;
    private String categoria;
    private Long trilhaId;

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getLink() { return link; }
    public void setLink(String link) { this.link = link; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public Long getTrilhaId() { return trilhaId; }
    public void setTrilhaId(Long trilhaId) { this.trilhaId = trilhaId; }
}
