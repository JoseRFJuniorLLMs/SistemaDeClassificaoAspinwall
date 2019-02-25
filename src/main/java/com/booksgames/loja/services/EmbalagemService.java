package com.booksgames.loja.services;

import com.booksgames.loja.documents.Embalagem;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 15 02 2019
 */

public interface EmbalagemService {

    Embalagem insert(Embalagem embalagem);
    Embalagem update(String id);
    void delete(String id);

    //WebFluxo
    Flux<Embalagem> findAll();
    Mono<Embalagem> findById(String id);
    Flux<Embalagem> findByDescricao(String descricao);
    Mono<Embalagem> save(Embalagem embalagem);

}
