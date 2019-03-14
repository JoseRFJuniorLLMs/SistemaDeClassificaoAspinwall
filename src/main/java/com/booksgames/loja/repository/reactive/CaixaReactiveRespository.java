package com.booksgames.loja.repository.reactive;

import com.booksgames.loja.documents.Caixa;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 04 03 2019
 */

public interface CaixaReactiveRespository extends ReactiveMongoRepository<Caixa, String>{

    Flux<Caixa> findByDescricao(String descricao);
}
