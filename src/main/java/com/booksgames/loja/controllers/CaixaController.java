package com.booksgames.loja.controllers;

import com.booksgames.loja.documents.Caixa;
import com.booksgames.loja.dto.CaixaDTO;
import com.booksgames.loja.repository.CaixaRepository;
import com.booksgames.loja.repository.reactive.CaixaReactiveRespository;
import com.booksgames.loja.services.impl.CaixaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 04 03 2019
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/caixas/v1/caixa")
public class CaixaController {

    @Autowired
    private CaixaRepository caixaRepository;

    @Autowired
    private CaixaReactiveRespository caixaReactiveRespository;

    @Autowired
    private CaixaServiceImpl caixaServiceImpl;

    @CrossOrigin(origins = "https://erp-aspinwall.firebaseapp.com/", maxAge = 3600)
    @GetMapping(value="/flux")
    public Flux<Caixa> getCaixa(){
        return caixaServiceImpl.findAll();
    }

    @GetMapping(value="/caixa/{id}")
    public Mono<Caixa> getCaixaId(@PathVariable String id){
        return caixaServiceImpl.findById(id);
    }

    @GetMapping(value="/caixa/descricao/{descricao}")
    public Flux<Caixa> getCaixaNome(@PathVariable String descricao){
        return caixaServiceImpl.findByDescricao(descricao);
    }


    @PostMapping(value="/caixa")
    public Mono<Caixa> save(@RequestBody Caixa caixa){
        return caixaServiceImpl.save(caixa);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Caixa> getAllCaixaes() {
        return caixaRepository.findAll();
    }

    @RequestMapping(value = "/{_id}", method = RequestMethod.GET)
    public Caixa getCaixaById(@PathVariable("_id") String _id) {
        return caixaRepository.findBy_id(_id);
    }

    @RequestMapping(value = "/{_id}", method = RequestMethod.PUT)
    public void updateCaixa(@PathVariable("_id") String _id, @Valid @RequestBody Caixa caixa) {
        caixa.set_id(_id);
        caixaRepository.save(caixa);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Void> insertCaixa(@Valid @RequestBody CaixaDTO objDto) {
        Caixa obj = caixaServiceImpl.fromDTO(objDto);
        obj = caixaServiceImpl.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{_id}").buildAndExpand(obj.get_id()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{_id}", method = RequestMethod.DELETE)
    public void deleteCaixa(@PathVariable String id) {
        caixaRepository.delete(caixaRepository.findBy_id(id));
    }

    @RequestMapping(value="/page", method=RequestMethod.GET)
    public ResponseEntity<Page<CaixaDTO>> findPage(
            @RequestParam(value="page", defaultValue="0") Integer page,
            @RequestParam(value="linesPerPage", defaultValue="5") Integer linesPerPage,
            @RequestParam(value="orderBy", defaultValue="nome") String orderBy,
            @RequestParam(value="direction", defaultValue="ASC") String direction) {
        Page<Caixa> list = caixaServiceImpl.findPage(page, linesPerPage, orderBy, direction);
        Page<CaixaDTO> listDto = list.map(CaixaDTO::new);
        return ResponseEntity.ok().body(listDto);
    }
}