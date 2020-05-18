package com.weltonramos.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weltonramos.cursomc.domain.Pedido;
import com.weltonramos.cursomc.repositories.PedidoRepository;
import com.weltonramos.cursomc.service.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository categoriaRepository;
	
	public Pedido buscar(Integer id) {
		Optional<Pedido> categoria = categoriaRepository.findById(id);
		return categoria.orElseThrow(() -> new ObjectNotFoundException("Id não encontrado" + Pedido.class.getName()));
	}
}
