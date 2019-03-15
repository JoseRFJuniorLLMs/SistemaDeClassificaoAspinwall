package com.booksgames.loja.controllers;

import com.booksgames.loja.documents.Embalagem;
import com.booksgames.loja.repository.EmbalagemRepository;
import com.booksgames.loja.repository.reactive.EmbalagemReactiveRespository;
import com.booksgames.loja.services.impl.EmbalagemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 15 02 2019
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/embalagens/v1/embalagem")
public class EmbalagemController {

    @Autowired
    private EmbalagemRepository embalagemRepositoryRepository;

    @Autowired
    private EmbalagemReactiveRespository embalagemReactiveRespository;

    @Autowired
    private EmbalagemServiceImpl embalagemServiceImpl;

    @GetMapping(value="/flux", produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.OK)
    public Flux<Embalagem> getEmbalagem(){
        return embalagemServiceImpl.findAll();
    }
}