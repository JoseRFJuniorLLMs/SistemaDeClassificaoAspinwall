package com.booksgames.loja.services.impl;

import java.util.List;
import java.util.Optional;

import com.booksgames.loja.dto.UnidadeDTO;
import com.booksgames.loja.repository.reactive.UnidadeReactiveRespository;
import com.booksgames.loja.services.UnidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.booksgames.loja.documents.Unidade;
import com.booksgames.loja.repository.UnidadeRepository;
import com.booksgames.loja.services.exceptions.DataIntegrityException;
import com.booksgames.loja.services.exceptions.ObjectNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 28 02 2019
 */

@Service
public class UnidadeServiceImpl implements UnidadeService {

    @Autowired
    private UnidadeRepository tamanhoRepository;

    @Autowired
    private UnidadeReactiveRespository tamanhoReactiveRespository;

    private static ObjectNotFoundException get() {
        return new ObjectNotFoundException(
                "Objeto não encontrado! Id: , Tipo: " + Unidade.class.getName());
    }

    public Unidade findId(String _id) {
        Optional<Unidade> obj = tamanhoRepository.findById(_id);
        return obj.orElseThrow(UnidadeServiceImpl::get);
    }

    @Transactional
    public Unidade insert(Unidade obj) {
        obj.set_id(null);
        return tamanhoRepository.save(obj);
    }

    @Transactional
    public Unidade update(String _id) {
        Unidade newObj = findId(_id);
        updateData(newObj, newObj);
        return tamanhoRepository.save(newObj);
    }

    @Transactional
    public void delete(String _id) {
        findId(_id);
        try {
            tamanhoRepository.deleteById(_id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir uma cor que possui produtos");
        }
    }
    // WEB FLUX METODOS
    public Flux<Unidade> findAll( ) {
        Flux<Unidade> obj = tamanhoReactiveRespository.findAll();
        return tamanhoReactiveRespository.findAll();
    }

    public Mono<Unidade> findById(String id) {
        return tamanhoReactiveRespository.findById( id );
    }

    public Flux<Unidade>  findByDescricao(String descricao) {
        return tamanhoReactiveRespository.findByDescricao( descricao );
    }

    public List<Unidade> findByNomeGoogle() {
        return tamanhoRepository.findAll();
    }

    public Mono<Unidade> save(Unidade cor) {
        return tamanhoReactiveRespository.save( cor );
    }

    public Page<Unidade> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
        return tamanhoRepository.findAll(pageRequest);
    }

    public Unidade fromDTO(UnidadeDTO objDto) {
        return new Unidade(
                objDto.get_id(),
                objDto.getDescricao()
        );
    }

    private void updateData(Unidade newObj, Unidade obj) {
        newObj.setDescricao(obj.getDescricao());
    }
}
