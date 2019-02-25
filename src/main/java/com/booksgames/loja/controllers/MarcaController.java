package com.booksgames.loja.controllers;

import com.booksgames.loja.documents.Marca;
import com.booksgames.loja.dto.MarcaDTO;
import com.booksgames.loja.repository.MarcaRepository;
import com.booksgames.loja.repository.reactive.MarcaReactiveRespository;
import com.booksgames.loja.services.impl.MarcaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 15 02 2019
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/marcas/v1/marca")
public class MarcaController {

    @Autowired
    private MarcaRepository marcaRepository;

    @Autowired
    private MarcaReactiveRespository marcaReactiveRespository;

    @Autowired
    private MarcaServiceImpl marcaServiceImpl;

    @GetMapping(value="/flux")
    public Flux<Marca> getMarca(){
        return marcaServiceImpl.findAll();
    }

    @GetMapping(value="/marca/{id}")
    public Mono<Marca> getMarcaId(@PathVariable String id){
        return marcaServiceImpl.findById(id);
    }

    @GetMapping(value="/marca/descricao/{descricao}")
    public Flux<Marca> getMarcaDescricao(@PathVariable String descricao){
        return marcaServiceImpl.findByDescricao(descricao);
    }

    @PostMapping(value="/marca")
    public Mono<Marca> save(@RequestBody Marca marca){
        return marcaServiceImpl.save(marca);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Marca> getAllMarcaes() {
        return marcaRepository.findAll();
    }

    @RequestMapping(value = "/{_id}", method = RequestMethod.GET)
    public Marca getMarcaById(@PathVariable("_id") String _id) {
        return marcaRepository.findBy_id(_id);
    }

    @RequestMapping(value = "/{_id}", method = RequestMethod.PUT)
    public void updateMarca(@PathVariable("_id") String _id, @Valid @RequestBody Marca marca) {
        marca.set_id(_id);
        marcaRepository.save(marca);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Void> insertMarca(@Valid @RequestBody MarcaDTO objDto) {
        Marca obj = marcaServiceImpl.fromDTO(objDto);
        obj = marcaServiceImpl.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{_id}").buildAndExpand(obj.get_id()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{_id}", method = RequestMethod.DELETE)
    public void deleteMarca(@PathVariable String id) {
        marcaRepository.delete(marcaRepository.findBy_id(id));
    }

    @RequestMapping(value="/page", method=RequestMethod.GET)
    public ResponseEntity<Page<MarcaDTO>> findPage(
            @RequestParam(value="page", defaultValue="0") Integer page,
            @RequestParam(value="linesPerPage", defaultValue="5") Integer linesPerPage,
            @RequestParam(value="orderBy", defaultValue="descricao") String orderBy,
            @RequestParam(value="direction", defaultValue="ASC") String direction) {
        Page<Marca> list = marcaServiceImpl.findPage(page, linesPerPage, orderBy, direction);
        Page<MarcaDTO> listDto = list.map(MarcaDTO::new);
        return ResponseEntity.ok().body(listDto);
    }
}