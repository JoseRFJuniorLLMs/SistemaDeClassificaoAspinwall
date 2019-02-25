package com.booksgames.loja.services.impl;

import java.util.Optional;

import com.booksgames.loja.dto.GrupoDTO;
import com.booksgames.loja.repository.GrupoRepository;
import com.booksgames.loja.services.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.booksgames.loja.documents.Grupo;
import com.booksgames.loja.services.exceptions.DataIntegrityException;
import com.booksgames.loja.services.exceptions.ObjectNotFoundException;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 15 02 2019
 */

@Service
public class GrupoServiceImpl implements GrupoService {

    @Autowired
    private GrupoRepository grupoRepository;

    public Grupo findId(String _id) {
        Optional<Grupo> obj = grupoRepository.findById(_id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + _id + ", Tipo: " + Grupo.class.getName()));
    }

    @Transactional
    public Grupo insert(Grupo obj) {
        obj.set_id(null);
        return grupoRepository.save(obj);
    }

    @Override
    public Grupo update(Grupo grupo) {
        return null;
    }

    public Grupo update(String _id) {
        Grupo newObj = findId(_id);
        updateData(newObj, newObj);
        return grupoRepository.save(newObj);
    }

    public void delete(String _id) {
        findId(_id);
        try {
            grupoRepository.deleteById(_id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir uma grupo que possui produtos");
        }
    }

    public Page<Grupo> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
        return grupoRepository.findAll(pageRequest);
    }

    public Grupo fromDTO(GrupoDTO objDto) {
        return new Grupo(objDto.get_id(), objDto.getNome());
    }

    private void updateData(Grupo newObj, Grupo obj) {
        newObj.setDescricao(obj.getDescricao());
    }
}
