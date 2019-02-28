package com.booksgames.loja.repository.reactive;

import com.booksgames.loja.documents.Tipo;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 28 02 2019
 */

public interface TipoReactiveRespository extends ReactiveMongoRepository<Tipo, String>{

    Flux<Tipo> findByDescricao(String descricao);
}
