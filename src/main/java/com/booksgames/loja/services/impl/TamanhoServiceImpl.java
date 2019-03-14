package com.booksgames.loja.services.impl;

import com.booksgames.loja.documents.Tamanho;
import com.booksgames.loja.dto.TamanhoDTO;
import com.booksgames.loja.repository.TamanhoRepository;
import com.booksgames.loja.repository.reactive.TamanhoReactiveRespository;
import com.booksgames.loja.services.TamanhoService;
import com.booksgames.loja.services.exceptions.DataIntegrityException;
import com.booksgames.loja.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 15 02 2019
 */

@Service
public class TamanhoServiceImpl implements TamanhoService {

    @Autowired
    private TamanhoRepository tamanhoRepository;

    @Autowired
    private  TamanhoReactiveRespository tamanhoReactiveRespository;

    private static ObjectNotFoundException get() {
        return new ObjectNotFoundException(
                "Objeto não encontrado! Id: , Tipo: " + Tamanho.class.getName());
    }

    public Tamanho findId(String _id) {
        Optional<Tamanho> obj = tamanhoRepository.findById(_id);
        return obj.orElseThrow(TamanhoServiceImpl::get);
    }

    @Transactional
    public Tamanho insert(Tamanho obj) {
        obj.set_id(null);
        return tamanhoRepository.save(obj);
    }

    @Transactional
    public Tamanho update(String _id) {
        Tamanho newObj = findId(_id);
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
    public Flux<Tamanho> findAll( ) {
        Flux<Tamanho> obj = tamanhoReactiveRespository.findAll();
        return tamanhoReactiveRespository.findAll();
    }

    public Mono<Tamanho> findById(String id) {
        return tamanhoReactiveRespository.findById( id );
    }

    public Flux<Tamanho>  findByDescricao(String descricao) {
        return tamanhoReactiveRespository.findByDescricao( descricao );
    }

    public List<Tamanho> findByNomeGoogle() {
        return tamanhoRepository.findAll();
    }

    public Mono<Tamanho> save(Tamanho cor) {
        return tamanhoReactiveRespository.save( cor );
    }

    public Page<Tamanho> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
        return tamanhoRepository.findAll(pageRequest);
    }

    public Tamanho fromDTO(TamanhoDTO objDto) {
        return new Tamanho(
                objDto.get_id(),
                objDto.getDescricao()
        );
    }

    private void updateData(Tamanho newObj, Tamanho obj) {
        newObj.setDescricao(obj.getDescricao());
    }
}
