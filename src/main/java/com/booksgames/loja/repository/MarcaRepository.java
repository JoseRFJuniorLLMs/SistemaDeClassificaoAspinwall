package com.booksgames.loja.repository;

import com.booksgames.loja.documents.Marca;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 15 02 2019
 */

public interface MarcaRepository extends MongoRepository<Marca, String> {

     Marca findBy_id(String _id);

}