package com.booksgames.loja.repository;

import com.booksgames.loja.documents.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 15 02 2019
 */

public interface ClienteRepository extends MongoRepository<Cliente, String> {
    Cliente findBy_id(String _id);
}

