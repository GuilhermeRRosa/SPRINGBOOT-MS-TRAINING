package com.gg.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gg.cursomc.domain.Cliente;
import com.gg.cursomc.repositories.ClienteRepository;
import com.gg.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public List<Cliente> buscarTodos() {
		Optional<List<Cliente>> clientes = Optional.ofNullable(clienteRepository.findAll());
		return clientes.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = clienteRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado: " + id + ", Tipo: " + Cliente.class.getName()));
	}

}
