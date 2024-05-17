package br.com.serratec.biblioteca.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Manga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O título é obrigatório")
    private String titulo;
    
    @NotNull(message = "O volume é obrigatório")
    private Integer volume;

    @Embedded
    @Valid
    private InformacaoPublicacao informacaoPublicacao;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public InformacaoPublicacao getInformacaoPublicacao() {
        return informacaoPublicacao;
    }

    public void setInformacaoPublicacao(InformacaoPublicacao informacaoPublicacao) {
        this.informacaoPublicacao = informacaoPublicacao;
    }
}
