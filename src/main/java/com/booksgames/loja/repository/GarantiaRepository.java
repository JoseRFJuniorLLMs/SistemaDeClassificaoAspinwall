package com.booksgames.loja.repository;

import com.booksgames.loja.documents.Garantia;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 28 02 2019
 */

public interface GarantiaRepository extends MongoRepository<Garantia, String> {

    Garantia findBy_id(String _id);

}