package com.gg.cursomc.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gg.cursomc.domain.Cliente;
import com.gg.cursomc.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {
	
	@Autowired
	ClienteService clienteService;
	
	@RequestMapping(value = "/todos")
	public ResponseEntity<?> buscarClientes(){
		List<Cliente> clientes = clienteService.buscarTodos();
		return ResponseEntity.ok().body(clientes);
	}
	
}
