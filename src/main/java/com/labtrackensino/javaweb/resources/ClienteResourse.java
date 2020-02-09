package com.labtrackensino.javaweb.resources;

import com.labtrackensino.javaweb.controller.ClienteRepository;
import com.labtrackensino.javaweb.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
//@CrossOrigin(origins = "Access-Control-Allow-Origin: *")
@RequestMapping(value = "/cliente")
public class ClienteResourse {


	@Autowired
	private ClienteRepository repository;

	/**
	 * @param limit  pagina atual;
	 * @param offset quantos por pagina;
	 */
	@RequestMapping(method = GET, produces = APPLICATION_JSON_VALUE, path = "listar")
	public ResponseEntity listar(
			@RequestParam(value = "limit", defaultValue = "0") int limit,
			@RequestParam(value = "offset", defaultValue = "0") int offset
	) {

		Pageable pageable = PageRequest.of(offset, limit, Sort.by(Sort.Direction.DESC, "id"));
		Iterable<Cliente> clientes = repository.findAll(pageable);

		return new ResponseEntity<>(clientes, HttpStatus.OK);
	}

	@RequestMapping(value = "{id}", method = GET, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity get(@PathVariable Long id) {

		Cliente cliente = repository.findById(id).orElse(null);

		return new ResponseEntity<>(cliente, HttpStatus.OK);
	}

	@RequestMapping(method = POST, consumes = APPLICATION_JSON_VALUE)
	public ResponseEntity post(@RequestBody Cliente cliente) {
		Cliente persist = repository.save(cliente);
		return new ResponseEntity<>(persist, HttpStatus.OK);
	}

	@RequestMapping(value = "{id}", method = PUT, consumes = APPLICATION_JSON_VALUE)
	public ResponseEntity put(@PathVariable("id") Long id, @RequestBody Cliente cliente) {
		Optional<Cliente> clienteOld = repository.findById(id);
		if (clienteOld.isPresent()) {
			clienteOld.get().getId().equals(cliente.getId());
			return new ResponseEntity<>(repository.save(cliente), HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "{id}", method = DELETE)
	public ResponseEntity delete(@PathVariable("id") Long id) {
		repository.deleteById(id);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

}
