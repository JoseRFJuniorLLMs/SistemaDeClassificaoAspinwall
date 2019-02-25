package com.booksgames.loja.controllers;

import com.booksgames.loja.documents.Cor;
import com.booksgames.loja.dto.CorDTO;
import com.booksgames.loja.repository.CorRepository;
import com.booksgames.loja.repository.reactive.CorReactiveRespository;
import com.booksgames.loja.services.impl.CorServiceImpl;
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
@RequestMapping("/cores/v1/cor")
public class CorController {

    @Autowired
    private CorRepository corRepository;

    @Autowired
    private CorReactiveRespository corReactiveRespository;

    @Autowired
    private CorServiceImpl corServiceImpl;

    @GetMapping(value="/flux")
    public Flux<Cor> getCor(){
        return corServiceImpl.findAll();
    }

    @GetMapping(value="/cor/{id}")
    public Mono<Cor> getCorId(@PathVariable String id){
        return corServiceImpl.findById(id);
    }

    @GetMapping(value="/cor/nome/{nome}")
    public Flux<Cor> getCorNome(@PathVariable String nome){
        return corServiceImpl.findByNome(nome);
    }

    @RequestMapping(value="/cor/nome/google", method=RequestMethod.GET)
    public ResponseEntity<List<CorDTO>> findAll() {
        List<Cor> list = corServiceImpl.findByNomeGoogle();
        List<CorDTO> listDto = list.stream()
                //.map(obj -> new CorDTO(obj))
                .map( CorDTO::new)
                .collect( Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @PostMapping(value="/cor")
    public Mono<Cor> save(@RequestBody Cor cor){
        return corServiceImpl.save(cor);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Cor> getAllCores() {
        return corRepository.findAll();
    }

    @RequestMapping(value = "/{_id}", method = RequestMethod.GET)
    public Cor getCorById(@PathVariable("_id") String _id) {
        return corRepository.findBy_id(_id);
    }

    @RequestMapping(value = "/{_id}", method = RequestMethod.PUT)
    public void updateCor(@PathVariable("_id") String _id, @Valid @RequestBody Cor cor) {
        cor.set_id(_id);
        corRepository.save(cor);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Void> insertCor(@Valid @RequestBody CorDTO objDto) {
        Cor obj = corServiceImpl.fromDTO(objDto);
        obj = corServiceImpl.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{_id}").buildAndExpand(obj.get_id()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{_id}", method = RequestMethod.DELETE)
    public void deleteCor(@PathVariable String id) {
        corRepository.delete(corRepository.findBy_id(id));
    }

    @RequestMapping(value="/page", method=RequestMethod.GET)
    public ResponseEntity<Page<CorDTO>> findPage(
            @RequestParam(value="page", defaultValue="0") Integer page,
            @RequestParam(value="linesPerPage", defaultValue="5") Integer linesPerPage,
            @RequestParam(value="orderBy", defaultValue="nome") String orderBy,
            @RequestParam(value="direction", defaultValue="ASC") String direction) {
        Page<Cor> list = corServiceImpl.findPage(page, linesPerPage, orderBy, direction);
        Page<CorDTO> listDto = list.map(CorDTO::new);
        return ResponseEntity.ok().body(listDto);
    }
}