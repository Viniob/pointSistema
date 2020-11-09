package com.br.point.sistemas.model;

public class NoticiaDTO {

	private String titulo;
	private String noticia;
	private String nomeAutor;
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getNoticia() {
		return noticia;
	}
	public void setNoticia(String noticia) {
		this.noticia = noticia;
	}
	public String getNomeAutor() {
		return nomeAutor;
	}
	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}
	@Override
	public String toString() {
		return "NoticiaDTO [titulo=" + titulo + ", noticia=" + noticia + ", nomeAutor=" + nomeAutor + "]";
	}
	
	
}
