package com.booksgames.loja.services.impl;

import com.booksgames.loja.documents.Garantia;
import com.booksgames.loja.dto.GarantiaDTO;
import com.booksgames.loja.repository.GarantiaRepository;
import com.booksgames.loja.repository.reactive.GarantiaReactiveRespository;
import com.booksgames.loja.services.GarantiaService;
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
public class GarantiaServiceImpl implements GarantiaService {

    @Autowired
    private GarantiaRepository tamanhoRepository;

    @Autowired
    private GarantiaReactiveRespository tamanhoReactiveRespository;

    private static ObjectNotFoundException get() {
        return new ObjectNotFoundException(
                "Objeto não encontrado! Id: , Tipo: " + Garantia.class.getName());
    }

    public Garantia findId(String _id) {
        Optional<Garantia> obj = tamanhoRepository.findById(_id);
        return obj.orElseThrow(GarantiaServiceImpl::get);
    }

    @Transactional
    public Garantia insert(Garantia obj) {
        obj.set_id(null);
        return tamanhoRepository.save(obj);
    }

    @Transactional
    public Garantia update(String _id) {
        Garantia newObj = findId(_id);
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
    public Flux<Garantia> findAll( ) {
        Flux<Garantia> obj = tamanhoReactiveRespository.findAll();
        return tamanhoReactiveRespository.findAll();
    }

    public Mono<Garantia> findById(String id) {
        return tamanhoReactiveRespository.findById( id );
    }

    public Flux<Garantia>  findByDescricao(String descricao) {
        return tamanhoReactiveRespository.findByDescricao( descricao );
    }

    public List<Garantia> findByNomeGoogle() {
        return tamanhoRepository.findAll();
    }

    public Mono<Garantia> save(Garantia cor) {
        return tamanhoReactiveRespository.save( cor );
    }

    public Page<Garantia> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
        return tamanhoRepository.findAll(pageRequest);
    }

    public Garantia fromDTO(GarantiaDTO objDto) {
        return new Garantia(
                objDto.get_id(),
                objDto.getDescricao(),
                objDto.getInicio(),
                objDto.getFim()
        );
    }

    private void updateData(Garantia newObj, Garantia obj) {
        newObj.setDescricao(obj.getDescricao());
    }
}
