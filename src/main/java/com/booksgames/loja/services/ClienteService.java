package com.booksgames.loja.services;

import com.booksgames.loja.documents.Cliente;

import java.util.List;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 15 02 2019
 */

public interface ClienteService {

    List<Cliente> listarTodos();

    List<Cliente> listarPorId(String id);

    /*Cliente cadastrar(Cliente cliente);

    Cliente atualizar(Cliente cliente);

     void remover(Integer id);*/
}
