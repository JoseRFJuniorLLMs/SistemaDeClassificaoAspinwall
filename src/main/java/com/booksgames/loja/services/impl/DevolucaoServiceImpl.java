package com.booksgames.loja.services.impl;

import java.util.List;
import java.util.Optional;

import com.booksgames.loja.dto.DevolucaoDTO;
import com.booksgames.loja.repository.reactive.DevolucaoReactiveRespository;
import com.booksgames.loja.services.DevolucaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.booksgames.loja.documents.Devolucao;
import com.booksgames.loja.repository.DevolucaoRepository;
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
public class DevolucaoServiceImpl implements DevolucaoService {

    @Autowired
    private DevolucaoRepository devolucaoRepository;

    @Autowired
    private DevolucaoReactiveRespository devolucaoReactiveRespository;

    private static ObjectNotFoundException get() {
        return new ObjectNotFoundException(
                "Objeto não encontrado! Id: , Tipo: " + Devolucao.class.getName());
    }

    public Devolucao findId(String _id) {
        Optional<Devolucao> obj = devolucaoRepository.findById(_id);
        return obj.orElseThrow(DevolucaoServiceImpl::get);
    }

    @Transactional
    public Devolucao insert(Devolucao obj) {
        obj.set_id(null);
        return devolucaoRepository.save(obj);
    }

    @Transactional
    public Devolucao update(String _id) {
        Devolucao newObj = findId(_id);
        updateData(newObj, newObj);
        return devolucaoRepository.save(newObj);
    }

    @Transactional
    public void delete(String _id) {
        findId(_id);
        try {
            devolucaoRepository.deleteById(_id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir uma cor que possui produtos");
        }
    }
    // WEB FLUX METODOS
    public Flux<Devolucao> findAll( ) {
        Flux<Devolucao> obj = devolucaoReactiveRespository.findAll();
        return devolucaoReactiveRespository.findAll();
    }

    public Mono<Devolucao> findById(String id) {
        return devolucaoReactiveRespository.findById( id );
    }

    public Flux<Devolucao>  findByDescricao(String descricao) {
        return devolucaoReactiveRespository.findByDescricao( descricao );
    }

    public List<Devolucao> findByNomeGoogle() {
        return devolucaoRepository.findAll();
    }

    public Mono<Devolucao> save(Devolucao devolucao) {
        return devolucaoReactiveRespository.save( devolucao );
    }

    public Page<Devolucao> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
        return devolucaoRepository.findAll(pageRequest);
    }

    public Devolucao fromDTO(DevolucaoDTO objDto) {
        return new Devolucao(
                objDto.get_id(),
                objDto.getDescricao()
        );
    }

    private void updateData(Devolucao newObj, Devolucao obj) {
        newObj.setDescricao(obj.getDescricao());
    }
}
