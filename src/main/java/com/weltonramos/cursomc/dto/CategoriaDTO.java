package com.weltonramos.cursomc.dto;

import java.io.Serializable;

import com.weltonramos.cursomc.domain.Categoria;

public class CategoriaDTO implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;

	public CategoriaDTO() {
	}
	
	public CategoriaDTO(Categoria categoria) {
		id = categoria.getId();
		nome = categoria.getNome();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return nome;
	}

	public void setName(String name) {
		this.nome = name;
	}
}
