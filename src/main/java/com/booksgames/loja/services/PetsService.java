package com.booksgames.loja.services;

import com.booksgames.loja.documents.Pets;

import java.util.List;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 15 02 2019
 */

public interface PetsService {

    List<Pets> listarTodos();
    Pets listarPorId(String id);

}
