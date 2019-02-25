package com.booksgames.loja.services;

import com.booksgames.loja.documents.Grupo;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 15 02 2019
 */

public interface GrupoService {
   /* List<Grupo> findAll();

    List<Grupo> findId(String id);*/

    Grupo insert(Grupo grupo);

    Grupo update(Grupo grupo);

    void delete(String id);
}
