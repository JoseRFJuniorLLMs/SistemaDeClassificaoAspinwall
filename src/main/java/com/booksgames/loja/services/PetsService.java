package com.booksgames.loja.services;

import java.util.List;
import com.booksgames.loja.documents.Pets;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 15 02 2019
 */

public interface PetsService {

    List<Pets> listarTodos();
    Pets listarPorId(String id);

}
