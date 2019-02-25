package com.booksgames.loja.repository.reactive;

import com.booksgames.loja.documents.Produto;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 15 02 2019
 */

public interface ProdutoReactiveRespository extends ReactiveMongoRepository<Produto, String>{

    Flux<Produto> findByDescricao(String descicao);

}
