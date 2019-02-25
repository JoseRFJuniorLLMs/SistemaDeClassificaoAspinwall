package com.booksgames.loja.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booksgames.loja.documents.Pets;
import com.booksgames.loja.repository.PetsRepository;
import com.booksgames.loja.services.PetsService;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 15 02 2019
 */

@Service
public class PetsServiceImpl implements PetsService {

    @Autowired
    private PetsRepository petsRepository;

    @Override
    public List<Pets> listarTodos() {
        return this.petsRepository.findAll();
    }

    @Override
    public Pets listarPorId(String id) {
        return this.petsRepository.findBy_id(id);
    }
}
