package com.booksgames.loja.services;

import com.booksgames.loja.documents.Unidade;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 28 02 2019
 */

public interface UnidadeService {

    Unidade insert(Unidade tamanho);
    Unidade update(String id);
    void delete(String id);

    //WebFluxo
    Flux<Unidade> findAll();
    Mono<Unidade> findById(String id);
    Flux<Unidade> findByDescricao(String descricao);
    Mono<Unidade> save(Unidade tamanho);

}
