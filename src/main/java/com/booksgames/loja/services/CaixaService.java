package com.booksgames.loja.services;

import com.booksgames.loja.documents.Caixa;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 15 02 2019
 */

public interface CaixaService {
    Caixa insert(Caixa caixa);
    Caixa update(String id);
    void delete(String id);
    //WebFluxo
    Flux<Caixa> findAll();
    Mono<Caixa> findById(String id);
    Flux<Caixa> findByDescricao(String descricao);
    Mono<Caixa> save(Caixa caixa);
}
