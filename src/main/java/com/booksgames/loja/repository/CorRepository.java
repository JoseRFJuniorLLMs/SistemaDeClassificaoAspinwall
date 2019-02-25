package com.booksgames.loja.repository;

import com.booksgames.loja.documents.Cor;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 15 02 2019
 */

public interface CorRepository extends MongoRepository<Cor, String> {
   /* List<Cor> findAll();
    Cor insert(Cor cor);
    Cor update(String id);
    void delete(String id);*/
    Cor findBy_id(String _id);
    //List<Cor> findByNomeGoogle();
}