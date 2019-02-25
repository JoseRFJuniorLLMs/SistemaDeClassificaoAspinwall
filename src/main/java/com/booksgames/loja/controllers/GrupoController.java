package com.booksgames.loja.controllers;

import com.booksgames.loja.documents.Grupo;
import com.booksgames.loja.dto.GrupoDTO;
import com.booksgames.loja.repository.GrupoRepository;
import com.booksgames.loja.services.impl.GrupoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
    private GrupoRepository grupoRepository;

    @Autowired
    private GrupoServiceImpl grupoServiceImpl;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Grupo> getAllGrupos() {
        return grupoRepository.findAll();
    }

    @RequestMapping(value = "/{_id}", method = RequestMethod.GET)
    public Grupo getPetById(@PathVariable("_id") String _id) {
        return grupoRepository.findBy_id(_id);
    }

    @RequestMapping(value = "/{_id}", method = RequestMethod.PUT)
    public void modifyPetById(@PathVariable("_id") String _id, @Valid @RequestBody Grupo grupo) {
        grupo.set_id(_id);
        grupoRepository.save(grupo);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Void> createCor(@Valid @RequestBody GrupoDTO objDto) {
        Grupo obj = grupoServiceImpl.fromDTO(objDto);
        obj = grupoServiceImpl.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{_id}").buildAndExpand(obj.get_id()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{_id}", method = RequestMethod.DELETE)
    public void deletePet(@PathVariable String _id) {
        grupoRepository.delete(grupoRepository.findBy_id(_id));
    }
}