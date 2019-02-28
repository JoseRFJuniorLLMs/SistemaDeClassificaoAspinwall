package com.booksgames.loja.services;

import com.booksgames.loja.documents.Garantia;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 28 02 2019
 */

public interface GarantiaService {

    Garantia insert(Garantia tamanho);
    Garantia update(String id);
    void delete(String id);

    //WebFluxo
    Flux<Garantia> findAll();
    Mono<Garantia> findById(String id);
    Flux<Garantia> findByDescricao(String descricao);
    Mono<Garantia> save(Garantia tamanho);

}
