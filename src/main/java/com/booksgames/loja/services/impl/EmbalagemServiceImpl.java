package com.booksgames.loja.services.impl;

import java.util.List;
import java.util.Optional;

import com.booksgames.loja.dto.EmbalagemDTO;
import com.booksgames.loja.repository.reactive.EmbalagemReactiveRespository;
import com.booksgames.loja.services.EmbalagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.booksgames.loja.documents.Embalagem;
import com.booksgames.loja.repository.EmbalagemRepository;
import com.booksgames.loja.services.exceptions.DataIntegrityException;
import com.booksgames.loja.services.exceptions.ObjectNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 15 02 2019
 */

@Service
public class EmbalagemServiceImpl implements EmbalagemService {

    @Autowired
    private EmbalagemRepository embalagemRespository;

    @Autowired
    private  EmbalagemReactiveRespository marcaReactiveRespository;

    private static ObjectNotFoundException get() {
        return new ObjectNotFoundException(
                "Objeto não encontrado! Id: , Tipo: " + Embalagem.class.getName());
    }

    public Embalagem findId(String _id) {
        Optional<Embalagem> obj = embalagemRespository.findById(_id);
        return obj.orElseThrow(EmbalagemServiceImpl::get);
    }

    @Transactional
    public Embalagem insert(Embalagem obj) {
        obj.set_id(null);
        return embalagemRespository.save(obj);
    }

    @Transactional
    public Embalagem update(String _id) {
        Embalagem newObj = findId(_id);
        updateData(newObj, newObj);
        return embalagemRespository.save(newObj);
    }

    @Transactional
    public void delete(String _id) {
        findId(_id);
        try {
            embalagemRespository.deleteById(_id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir uma marca que possui produtos");
        }
    }
    // WEB FLUX METODOS
    public Flux<Embalagem> findAll( ) {
        Flux<Embalagem> obj = marcaReactiveRespository.findAll();
        return marcaReactiveRespository.findAll();
    }

    public Mono<Embalagem> findById(String id) {
        return marcaReactiveRespository.findById( id );
    }

    @Override
    public Flux<Embalagem> findByDescricao(String descricao) {
        return marcaReactiveRespository.findByDescricao( descricao );
    }

    public List<Embalagem> findByNomeGoogle() {
        return embalagemRespository.findAll();
    }

    public Mono<Embalagem> save(Embalagem marca) {
        return marcaReactiveRespository.save( marca );
    }

    public Page<Embalagem> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
        return embalagemRespository.findAll(pageRequest);
    }

    public Embalagem fromDTO(EmbalagemDTO objDto) {
        return new Embalagem(
                objDto.get_id(),
                objDto.getDescricao());
    }

    private void updateData(Embalagem newObj, Embalagem obj) {

        newObj.setDescricao(obj.getDescricao());
    }
}
