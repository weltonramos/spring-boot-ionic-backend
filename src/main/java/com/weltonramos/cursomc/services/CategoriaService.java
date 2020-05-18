package com.weltonramos.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.weltonramos.cursomc.domain.Categoria;
import com.weltonramos.cursomc.repositories.CategoriaRepository;
import com.weltonramos.cursomc.service.exceptions.DataIntegrityException;
import com.weltonramos.cursomc.service.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public Categoria find(Integer id) {
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		return categoria
				.orElseThrow(() -> new ObjectNotFoundException("Id não encontrado" + Categoria.class.getName()));
	}

	public Categoria insert(Categoria categoria) {
		categoria.setId(null);
		return categoriaRepository.save(categoria);
	}

	public Categoria update(Categoria categoria) {
		find(categoria.getId());
		return categoriaRepository.save(categoria);
	}

	public void delete(Integer id) {
		find(id);
		try {
			categoriaRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir categorias que possuem produtos");
		}
	}
	
	public List<Categoria> findAll(){
		return categoriaRepository.findAll();
	}
}
