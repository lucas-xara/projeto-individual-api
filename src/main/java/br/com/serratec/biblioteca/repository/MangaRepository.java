package br.com.serratec.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.serratec.biblioteca.model.Manga;

@Repository
public interface MangaRepository extends JpaRepository<Manga, Long> {
}
