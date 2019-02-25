package com.booksgames.loja.services.impl;

import java.util.List;
import java.util.Optional;

import com.booksgames.loja.dto.MarcaDTO;
import com.booksgames.loja.repository.reactive.MarcaReactiveRespository;
import com.booksgames.loja.services.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.booksgames.loja.documents.Marca;
import com.booksgames.loja.repository.MarcaRepository;
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
public class MarcaServiceImpl implements MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    @Autowired
    private  MarcaReactiveRespository marcaReactiveRespository;

    private static ObjectNotFoundException get() {
        return new ObjectNotFoundException(
                "Objeto não encontrado! Id: , Tipo: " + Marca.class.getName());
    }

    public Marca findId(String _id) {
        Optional<Marca> obj = marcaRepository.findById(_id);
        return obj.orElseThrow(MarcaServiceImpl::get);
    }

    @Transactional
    public Marca insert(Marca obj) {
        obj.set_id(null);
        return marcaRepository.save(obj);
    }

    @Transactional
    public Marca update(String _id) {
        Marca newObj = findId(_id);
        updateData(newObj, newObj);
        return marcaRepository.save(newObj);
    }

    @Transactional
    public void delete(String _id) {
        findId(_id);
        try {
            marcaRepository.deleteById(_id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir uma marca que possui produtos");
        }
    }
    // WEB FLUX METODOS
    public Flux<Marca> findAll( ) {
        Flux<Marca> obj = marcaReactiveRespository.findAll();
        return marcaReactiveRespository.findAll();
    }

    public Mono<Marca> findById(String id) {
        return marcaReactiveRespository.findById( id );
    }

    @Override
    public Flux<Marca> findByDescricao(String descricao) {
        return marcaReactiveRespository.findByDescricao( descricao );
    }

    public List<Marca> findByNomeGoogle() {
        return marcaRepository.findAll();
    }

    public Mono<Marca> save(Marca marca) {
        return marcaReactiveRespository.save( marca );
    }

    public Page<Marca> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
        return marcaRepository.findAll(pageRequest);
    }

    public Marca fromDTO(MarcaDTO objDto) {
        return new Marca(
                objDto.get_id(),
                objDto.getDescricao());
    }

    private void updateData(Marca newObj, Marca obj) {
        newObj.setDescricao(obj.getDescricao());
    }
}
