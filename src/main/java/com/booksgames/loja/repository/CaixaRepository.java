package com.booksgames.loja.repository;

import com.booksgames.loja.documents.Caixa;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 4 03 2019
 */

public interface CaixaRepository extends MongoRepository<Caixa, String> {

   /* List<Caixa> findAll(Sort sort);
     Caixa insert(Caixa cor);
     Caixa update(String id);
     void delete(String id);*/
    Caixa findBy_id(String _id);
}