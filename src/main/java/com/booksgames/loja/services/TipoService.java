package com.booksgames.loja.services;

import com.booksgames.loja.documents.Tipo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 28 02 2019
 */

public interface TipoService {

    Tipo insert(Tipo tamanho);
    Tipo update(String id);
    void delete(String id);

    //WebFluxo
    Flux<Tipo> findAll();
    Mono<Tipo> findById(String id);
    Flux<Tipo> findByDescricao(String descricao);
    Mono<Tipo> save(Tipo tamanho);

}
