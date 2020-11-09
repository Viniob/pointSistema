package com.br.point.sistemas.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.br.point.sistemas.model.Noticia;
import com.br.point.sistemas.model.NoticiaDTO;
import com.br.point.sistemas.service.NoticiaService;

@RestController
@RequestMapping("/api/noticia")
public class NoticiaController {

	@Autowired
	private NoticiaService noticiaService;

	@PostMapping()
	public ResponseEntity<?> criarNoticia(@RequestBody NoticiaDTO noticiaDto) {
		Noticia noticiaCriada = noticiaService.criaNoticia(noticiaDto);
		return new ResponseEntity<>(noticiaCriada, HttpStatus.ACCEPTED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> atualizarNoticia(@RequestBody Noticia noticia) {
		Noticia noticiaAtualizada = noticiaService.atualizaNoticia(noticia);
		return new ResponseEntity<>(noticiaAtualizada, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarNoticia(@PathVariable Integer id) {
		noticiaService.deletarNoticia(id);
		return new ResponseEntity<>("Noticia deletada com sucesso", HttpStatus.ACCEPTED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> buscarNoticia(@PathVariable Integer id) {
		Noticia noticiaDb = noticiaService.buscarNoticia(id);
		if (noticiaDb != null) {
			return new ResponseEntity<>(noticiaDb, HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>("Noticia com id + " + id + " não localizada", HttpStatus.NOT_FOUND);
	}

	@GetMapping()
	public Iterable<Noticia> buscarNoticias() {
		Iterable<Noticia> noticias = noticiaService.listarNoticias();
		return noticias;
	}
}
