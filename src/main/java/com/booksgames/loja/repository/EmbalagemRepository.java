package com.booksgames.loja.repository;

import com.booksgames.loja.documents.Embalagem;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 15 02 2019
 */

public interface EmbalagemRepository extends MongoRepository<Embalagem, String> {

    Embalagem findBy_id(String _id);

}