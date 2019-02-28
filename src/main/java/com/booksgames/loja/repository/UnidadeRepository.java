package com.booksgames.loja.repository;

import com.booksgames.loja.documents.Unidade;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 28 02 2019
 */

public interface UnidadeRepository extends MongoRepository<Unidade, String> {

    Unidade findBy_id(String _id);

}