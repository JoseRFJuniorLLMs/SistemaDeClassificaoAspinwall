package com.booksgames.loja.repository.reactive;

import com.booksgames.loja.documents.Embalagem;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 15 02 2019
 */

public interface EmbalagemReactiveRespository extends ReactiveMongoRepository<Embalagem, String>{

    Flux<Embalagem> findByDescricao(String descricao);
}
