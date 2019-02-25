package com.booksgames.loja.repository.reactive;

import com.booksgames.loja.documents.Cor;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 15 02 2019
 */

public interface CorReactiveRespository extends ReactiveMongoRepository<Cor, String>{

    Flux<Cor> findByNome(String nome);
 /*   List<Cor> findByNomeGoogle();*/
}
