package com.booksgames.loja.services.impl;

import com.booksgames.loja.documents.Caixa;
import com.booksgames.loja.dto.CaixaDTO;
import com.booksgames.loja.repository.CaixaRepository;
import com.booksgames.loja.repository.reactive.CaixaReactiveRespository;
import com.booksgames.loja.services.CaixaService;
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
 * Santiago Chile 04 03 2019
 */

@Service
public class CaixaServiceImpl implements CaixaService {

    @Autowired
    private CaixaRepository caixaRepository;

    @Autowired
    private CaixaReactiveRespository caixaReactiveRespository;

    private static ObjectNotFoundException get() {
        return new ObjectNotFoundException(
                "Objeto não encontrado! Id: , Tipo: " + Caixa.class.getName());
    }

    public Caixa findId(String _id) {
        Optional<Caixa> obj = caixaRepository.findById(_id);
        return obj.orElseThrow(CaixaServiceImpl::get);
    }

    @Transactional
    public Caixa insert(Caixa obj) {
        obj.set_id(null);
        return caixaRepository.save(obj);
    }

    @Transactional
    public Caixa update(String _id) {
        Caixa newObj = findId(_id);
        updateData(newObj, newObj);
        return caixaRepository.save(newObj);
    }

    @Transactional
    public void delete(String _id) {
        findId(_id);
        try {
            caixaRepository.deleteById(_id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir uma cor que possui produtos");
        }
    }
    // WEB FLUX METODOS
    public Flux<Caixa> findAll( ) {
        Flux<Caixa> obj = caixaReactiveRespository.findAll();
        return caixaReactiveRespository.findAll();
    }

    public Flux<Caixa> findAllAtivo(String status) {
        Flux<Caixa> obj = caixaReactiveRespository.findByStatus(status);
        return caixaReactiveRespository.findByStatus(status);
    }

    public Mono<Caixa> findById(String id) {
        return caixaReactiveRespository.findById( id );
    }

    public Flux<Caixa>  findByDescricao(String descricao) {
        return caixaReactiveRespository.findByDescricao( descricao );
    }

    public Mono<Caixa> save(Caixa caixa) {
        return caixaReactiveRespository.save( caixa );
    }

    public Page<Caixa> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
        return caixaRepository.findAll(pageRequest);
    }

    public Caixa fromDTO(CaixaDTO objDto) {
        return new Caixa(
        objDto.get_id(),
        objDto.getUuid(),
        objDto.getDescricao(),
        objDto.getDatahora(),
        objDto.getTemperatura(),
        objDto.getLongitude(),
        objDto.getLatitude(),
        objDto.getArduino(),
        objDto.getSensorinerno(),
        objDto.getSensorexterno(),
        objDto.getInicio(),
        objDto.getFim(),
        objDto.getOrirgem(),
        objDto.getDestino(),
        objDto.getTempogasto(),
        objDto.getPessoa(),
        objDto.getVeiculo(),
        objDto.getMaterialcoletado(),
        objDto.getStatus());
    }

    private void updateData(Caixa newObj, Caixa obj) {
        newObj.setDescricao(obj.getDescricao());
    }
}
