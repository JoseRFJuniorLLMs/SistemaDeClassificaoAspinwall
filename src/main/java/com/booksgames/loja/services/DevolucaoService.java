package com.booksgames.loja.services;

import com.booksgames.loja.documents.Devolucao;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 28 02 2019
 */

public interface DevolucaoService {

    Devolucao insert(Devolucao tamanho);
    Devolucao update(String id);
    void delete(String id);

    //WebFluxo
    Flux<Devolucao> findAll();
    Mono<Devolucao> findById(String id);
    Flux<Devolucao> findByDescricao(String descricao);
    Mono<Devolucao> save(Devolucao tamanho);

}
