package com.booksgames.loja.controllers;

import com.booksgames.loja.documents.Tamanho;
import com.booksgames.loja.services.impl.TamanhoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 22 02 2019
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/tamanhos/v1/tamanho")
public class TamanhoController {

    @Autowired
    private TamanhoServiceImpl tamanhoServiceImpl;

    @GetMapping(value="/flux")
    public Flux<Tamanho> getTamanho(){
        return tamanhoServiceImpl.findAll();
    }

}