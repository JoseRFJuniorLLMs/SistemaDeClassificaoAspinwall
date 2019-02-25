package com.booksgames.loja.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.booksgames.loja.repository.ClienteRepository;
import com.booksgames.loja.documents.Cliente;
import com.booksgames.loja.responses.Response;
import com.booksgames.loja.services.ClienteService;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 15 02 2019
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClienteRepository clienteRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<Response<List<Cliente>>> listarTodos() {
        return ResponseEntity.ok(new Response<List<Cliente>>(this.clienteService.listarTodos()));
    }

   @GetMapping(path = "/{id}")
    public ResponseEntity<Response<Cliente>> listarPorId(@PathVariable(name = "id") String id) {
        return ResponseEntity.ok(new Response<Cliente>((Cliente) this.clienteService.listarTodos()));
    }
/*
    @PostMapping
    public ResponseEntity<Response<Cliente>> cadastrar(@Valid @RequestBody Cliente cliente, BindingResult result) {
        if (result.hasErrors()) {
            List<String> erros = new ArrayList<String>();
            result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
            return ResponseEntity.badRequest().body(new Response<Cliente>(erros));
        }

        return ResponseEntity.ok(new Response<Cliente>(this.clienteService.cadastrar(cliente)));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Response<Cliente>> atualizar(@PathVariable(name = "id") String id, @Valid @RequestBody Cliente cliente, BindingResult result) {
        if (result.hasErrors()) {
            List<String> erros = new ArrayList<String>();
            result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
            return ResponseEntity.badRequest().body(new Response<Cliente>(erros));
        }

        cliente.setId(id);
        return ResponseEntity.ok(new Response<Cliente>(this.clienteService.atualizar(cliente)));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Response<Integer>> remover(@PathVariable(name = "id") String id) {
        this.clienteService.remover(id);
        return ResponseEntity.ok(new Response<Integer>(1));
    }*/
}
