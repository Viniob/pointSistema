package com.br.point.sistemas.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.point.sistemas.model.Noticia;
import com.br.point.sistemas.model.NoticiaDTO;
import com.br.point.sistemas.repository.NoticiaRepository;

@Service
public class NoticiaService {

	@Autowired
	private NoticiaRepository noticiaRepo;

	public Noticia criaNoticia(NoticiaDTO noticiaDto) {
		Noticia noticia = new Noticia(noticiaDto.getTitulo(), noticiaDto.getNoticia(), noticiaDto.getNomeAutor());
		Noticia noticiaSaved = noticiaRepo.save(noticia);
		return noticiaSaved;
	}

	public Noticia atualizaNoticia(Noticia noticia) {
		Optional<Noticia> noticiaDb = noticiaRepo.findById(noticia.getId());
		Noticia noticiaAtualizada = new Noticia();
		if (noticiaDb.isPresent()) {
			noticiaAtualizada = noticiaDb.get();
			noticiaAtualizada = noticia;
			noticiaAtualizada.setDataAtualizacao(new Date());
			noticiaRepo.save(noticiaAtualizada);
		}
		return noticiaAtualizada;
	}

	public void deletarNoticia(Integer id) {
		noticiaRepo.deleteById(id);
	}

	public Noticia buscarNoticia(Integer id) {
		Optional<Noticia> findNoticiaById = noticiaRepo.findById(id);
		Noticia noticiaDb = new Noticia();
		if(findNoticiaById.isPresent()) {
			noticiaDb = findNoticiaById.get();
		}
		return noticiaDb;
	}

	public Iterable<Noticia> listarNoticias() {
		Iterable<Noticia> noticias = noticiaRepo.findAll();
		return  noticias;
	}

}
