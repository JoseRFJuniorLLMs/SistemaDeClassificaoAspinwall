package com.booksgames.loja.repository.reactive;

import com.booksgames.loja.documents.Grupo;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 15 02 2019
 */

public interface GrupoReactiveRepository extends ReactiveMongoRepository<Grupo, String> {

    Flux<Grupo> findByDescricao(String descricao);

}
