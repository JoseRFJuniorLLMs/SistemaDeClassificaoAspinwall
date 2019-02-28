package com.booksgames.loja.services;

import com.booksgames.loja.documents.Tamanho;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 28 02 2019
 */

public interface TamanhoService {
    
    Tamanho insert(Tamanho tamanho);
    Tamanho update(String id);
    void delete(String id);

    //WebFluxo
    Flux<Tamanho> findAll();
    Mono<Tamanho> findById(String id);
    Flux<Tamanho> findByDescricao(String descricao);
    Mono<Tamanho> save(Tamanho tamanho);

}
