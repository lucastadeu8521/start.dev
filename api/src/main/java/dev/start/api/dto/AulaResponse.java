package dev.start.api.dto;

public class AulaResponse {
    private Long id;
    private String titulo;
    private String descricao;
    private String link;
    private String categoria;
    private boolean ativa;

    public AulaResponse() {}

    public AulaResponse(Long id, String titulo, String descricao, String link, String categoria, boolean ativa) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.link = link;
        this.categoria = categoria;
        this.ativa = ativa;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getLink() { return link; }
    public void setLink(String link) { this.link = link; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public boolean isAtiva() { return ativa; }
    public void setAtiva(boolean ativa) { this.ativa = ativa; }
}
