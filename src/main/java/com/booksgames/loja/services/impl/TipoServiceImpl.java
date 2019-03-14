package com.booksgames.loja.services.impl;

import com.booksgames.loja.documents.Tipo;
import com.booksgames.loja.dto.TipoDTO;
import com.booksgames.loja.repository.TipoRepository;
import com.booksgames.loja.repository.reactive.TipoReactiveRespository;
import com.booksgames.loja.services.TipoService;
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
 * Santiago Chile 28 02 2019
 */

@Service
public class TipoServiceImpl implements TipoService {

    @Autowired
    private TipoRepository tipoRepository;

    @Autowired
    private TipoReactiveRespository tipoReactiveRespository;
    private TipoDTO objDto;

    private static ObjectNotFoundException get() {
        return new ObjectNotFoundException(
                "Objeto não encontrado! Id: , Tipo: " + Tipo.class.getName());
    }

    public Tipo findId(String _id) {
        Optional<Tipo> obj = tipoRepository.findById(_id);
        return obj.orElseThrow(TipoServiceImpl::get);
    }

    @Transactional
    public Tipo insert(Tipo obj) {
        obj.set_id(null);
        return tipoRepository.save(obj);
    }

    @Transactional
    public Tipo update(String _id) {
        Tipo newObj = findId(_id);
        updateData(newObj, newObj);
        return tipoRepository.save(newObj);
    }

    @Transactional
    public void delete(String _id) {
        findId(_id);
        try {
            tipoRepository.deleteById(_id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir uma cor que possui produtos");
        }
    }
    // WEB FLUX METODOS
    public Flux<Tipo> findAll( ) {
        Flux<Tipo> obj = tipoReactiveRespository.findAll();
        return tipoReactiveRespository.findAll();
    }

    public Mono<Tipo> findById(String id) {
        return tipoReactiveRespository.findById( id );
    }

    public Flux<Tipo>  findByDescricao(String descricao) {
        return tipoReactiveRespository.findByDescricao( descricao );
    }

    public List<Tipo> findByNomeGoogle() {
        return tipoRepository.findAll();
    }

    public Mono<Tipo> save(Tipo devolucao) {
        return tipoReactiveRespository.save( devolucao );
    }

    public Page<Tipo> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
        return tipoRepository.findAll(pageRequest);
    }

    public Tipo fromDTO(TipoDTO objDto) {
           return new Tipo(
                objDto.get_id(),
                objDto.getDescricao()
        );
    }

    private void updateData(Tipo newObj, Tipo obj) {
        newObj.setDescricao(obj.getDescricao());
    }
}
