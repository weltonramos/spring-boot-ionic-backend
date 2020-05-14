package com.weltonramos.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weltonramos.cursomc.domain.Categoria;
import com.weltonramos.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria buscar(Integer id) {
		return categoriaRepository.findById(id).orElse(null);
	}
}
