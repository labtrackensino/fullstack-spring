package com.labtrackensino.javaweb.resources;

import com.labtrackensino.javaweb.controller.CarroRepository;
import com.labtrackensino.javaweb.model.Carro;
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
@RequestMapping(value = "/carro")
public class CarroResourse {


	@Autowired
	private CarroRepository repository;

	/**
	 * @param limit  pagina atual;
	 * @param offset quantos por pagina;
	 */
	@RequestMapping(method = GET, produces = APPLICATION_JSON_VALUE, path = "listar")
	public ResponseEntity listar(
			@RequestParam(value = "limit" , defaultValue = "0") int limit,
			@RequestParam(value = "offset", defaultValue = "0") int offset
	) {

        Pageable pageable = PageRequest.of(offset,limit, Sort.by(Sort.Direction.DESC, "id"));
		Iterable<Carro> carros = repository.findAll(pageable);

		return new ResponseEntity<>(carros, HttpStatus.OK);
	}

	@RequestMapping(value = "{id}", method = GET, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity get(@PathVariable Long id) {

		Carro carro = repository.findById(id).orElse(null);

		return new ResponseEntity<>(carro, HttpStatus.OK);
	}

	@RequestMapping(method = POST, consumes = APPLICATION_JSON_VALUE)
	public ResponseEntity post(@RequestBody Carro carro) {
		Carro persist = repository.save(carro);
		return new ResponseEntity<>(persist, HttpStatus.OK);
	}

	@RequestMapping(value = "{id}", method = PUT, consumes = APPLICATION_JSON_VALUE)
	public ResponseEntity put(@PathVariable("id") Long id, @RequestBody Carro carro) {
        Optional<Carro> carroOld = repository.findById(id);
        if(carroOld.isPresent()){
            carroOld.get().getId().equals(carro.getId());
            return new ResponseEntity<>(repository.save(carro), HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "{id}", method = DELETE)
	public ResponseEntity delete(@PathVariable("id") Long id) {
		repository.deleteById(id);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

}
