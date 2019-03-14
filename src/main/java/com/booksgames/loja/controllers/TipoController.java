package com.booksgames.loja.controllers;

import com.booksgames.loja.documents.Tipo;
import com.booksgames.loja.services.impl.TipoServiceImpl;
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
@RequestMapping("/tipos/v1/tipo")
public class TipoController {

    @Autowired
    private TipoServiceImpl tipoServiceImpl;

    @GetMapping(value="/flux")
    public Flux<Tipo> getTipo(){
        return tipoServiceImpl.findAll();
    }

}