package br.com.serratec.biblioteca.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.biblioteca.model.Manga;
import br.com.serratec.biblioteca.repository.MangaRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/mangas")
public class MangaController {

    @Autowired
    private MangaRepository mangaRepository;

    @GetMapping
    public ResponseEntity<List<Manga>> listar() {
        return ResponseEntity.ok(mangaRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Manga> buscar(@PathVariable Long id) {
        Optional<Manga> mangaOpt = mangaRepository.findById(id);
        if (mangaOpt.isPresent()) {
            return ResponseEntity.ok(mangaOpt.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Manga inserir(@Valid @RequestBody Manga manga) {
        return mangaRepository.save(manga);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Manga> atualizar(@PathVariable Long id, @Valid @RequestBody Manga manga) {
        if (!mangaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        manga.setId(id);
        manga = mangaRepository.save(manga);
        return ResponseEntity.ok(manga);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        if (!mangaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        mangaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
