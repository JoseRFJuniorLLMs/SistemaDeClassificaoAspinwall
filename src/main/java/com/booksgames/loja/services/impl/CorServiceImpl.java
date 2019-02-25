package com.booksgames.loja.services.impl;

import java.util.List;
import java.util.Optional;

import com.booksgames.loja.repository.reactive.CorReactiveRespository;
import com.booksgames.loja.services.CorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.booksgames.loja.documents.Cor;
import com.booksgames.loja.dto.CorDTO;
import com.booksgames.loja.repository.CorRepository;
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
public class CorServiceImpl implements CorService {

    @Autowired
    private CorRepository corRepository;

    @Autowired
    private  CorReactiveRespository corReactiveRespository;

    private static ObjectNotFoundException get() {
        return new ObjectNotFoundException(
                "Objeto não encontrado! Id: , Tipo: " + Cor.class.getName());
    }

    public Cor findId(String _id) {
        Optional<Cor> obj = corRepository.findById(_id);
        return obj.orElseThrow(CorServiceImpl::get);
    }

    @Transactional
    public Cor insert(Cor obj) {
        obj.set_id(null);
        return corRepository.save(obj);
    }

    @Transactional
    public Cor update(String _id) {
        Cor newObj = findId(_id);
        updateData(newObj, newObj);
        return corRepository.save(newObj);
    }

    @Transactional
    public void delete(String _id) {
        findId(_id);
        try {
            corRepository.deleteById(_id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir uma cor que possui produtos");
        }
    }
    // WEB FLUX METODOS
    public Flux<Cor> findAll( ) {
        Flux<Cor> obj = corReactiveRespository.findAll();
        return corReactiveRespository.findAll();
    }

    public Mono<Cor> findById(String id) {
        return corReactiveRespository.findById( id );
    }

    public Flux<Cor>  findByNome(String nome) {
        return corReactiveRespository.findByNome( nome );
    }

    public List<Cor> findByNomeGoogle() {
          return corRepository.findAll();
    }

    public Mono<Cor> save(Cor cor) {
        return corReactiveRespository.save( cor );
    }

    public Page<Cor> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
        return corRepository.findAll(pageRequest);
    }

    public Cor fromDTO(CorDTO objDto) {
        return new Cor(
                objDto.get_id(),
                objDto.getNome(),
                objDto.getHex());
    }

    private void updateData(Cor newObj, Cor obj) {
        newObj.setNome(obj.getNome());
    }
}
