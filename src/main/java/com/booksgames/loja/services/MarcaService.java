package com.booksgames.loja.services;

import com.booksgames.loja.documents.Marca;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 15 02 2019
 */

public interface MarcaService {
   /* List<Marca> findAll();
    List<Marca> findId(String id);*/

    Marca insert(Marca marca);
    Marca update(String id);
    void delete(String id);

    //WebFluxo
    Flux<Marca> findAll();
    Mono<Marca> findById(String id);
    Flux<Marca> findByDescricao(String descricao);
    Mono<Marca> save(Marca marca);

    //List<Marca> findByDescricaoGoogle();
}
