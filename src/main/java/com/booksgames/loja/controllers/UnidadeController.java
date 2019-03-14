package com.booksgames.loja.controllers;

import com.booksgames.loja.documents.Unidade;
import com.booksgames.loja.services.impl.UnidadeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 28 02 2019
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/unidades/v1/unidade")
public class UnidadeController {

    @Autowired
    private UnidadeServiceImpl unidadeServiceImpl;

    @GetMapping(value="/flux")
    public Flux<Unidade> getUnidade(){
        return unidadeServiceImpl.findAll();
    }

}