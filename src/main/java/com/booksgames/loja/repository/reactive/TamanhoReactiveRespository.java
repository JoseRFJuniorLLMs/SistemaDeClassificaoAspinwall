package com.booksgames.loja.repository.reactive;

import com.booksgames.loja.documents.Tamanho;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 15 02 2019
 */

public interface TamanhoReactiveRespository extends ReactiveMongoRepository<Tamanho, String>{

    Flux<Tamanho> findByDescricao(String descricao);
}
