package com.booksgames.loja.controllers;

import com.booksgames.loja.documents.Grupo;
import com.booksgames.loja.dto.GrupoDTO;
import com.booksgames.loja.repository.GrupoRepository;
import com.booksgames.loja.repository.reactive.GrupoReactiveRepository;
import com.booksgames.loja.services.impl.GrupoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import reactor.core.publisher.Flux;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

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