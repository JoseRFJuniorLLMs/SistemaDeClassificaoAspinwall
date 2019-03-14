package com.booksgames.loja.controllers;

import com.booksgames.loja.documents.Grupo;
import com.booksgames.loja.services.impl.GrupoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 15 02 2019
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/grupos/v1/grupo")
public class GrupoController {

    @Autowired
    private GrupoServiceImpl grupoServiceImpl;

    @GetMapping(value="/flux")
    public Flux<Grupo> getMarca(){
        return grupoServiceImpl.findAll();
    }

}