package com.booksgames.loja.services.impl;

import java.util.Optional;

import com.booksgames.loja.repository.reactive.ProdutoReactiveRespository;
import com.booksgames.loja.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.booksgames.loja.documents.Produto;
import com.booksgames.loja.repository.ProdutoRepository;
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
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoReactiveRespository produtoReactiveRespository;

    // WEB FLUX METODOS
    public Flux<Produto> findAll( ) {
        Flux<Produto> obj = produtoReactiveRespository.findAll();
        return produtoReactiveRespository.findAll();
    }

    public Flux<Produto>  findByDescricao(String descricao) {
        return produtoReactiveRespository.findByDescricao( descricao );
    }

    private static ObjectNotFoundException get() {
        return new ObjectNotFoundException(
                "Objeto não encontrado! Id: , Tipo: " + Produto.class.getName());
    }

    public Produto findId(String _id) {
        Optional<Produto> obj = produtoRepository.findById(_id);
        return obj.orElseThrow(ProdutoServiceImpl::get);
    }

   /* public List<Produto> findAll() {
        return produtoRepository.findAll();
    }*/

    @Transactional
    public Produto insert(Produto obj) {
        obj.set_id(null);
        return produtoRepository.save(obj);
    }

    public Mono<Produto> save(Produto produto) {
        return produtoReactiveRespository.save( produto );
    }

    @Transactional
    public Produto update(String _id) {
        Produto newObj = findId(_id);
        updateData(newObj, newObj);
        return produtoRepository.save(newObj);
    }

    @Transactional
    public void delete(String _id) {
        findId(_id);
        try {
            produtoRepository.deleteById(_id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir uma produto que possui produtos");
        }
    }

    public Page<Produto> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
        return produtoRepository.findAll(pageRequest);
    }

/*    public Flux<Produto> findPageFlux(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
        return produtoReactiveRespository.findAll(pageRequest);
    }*/

    public Produto fromDTO(Produto objDto) {
        return new Produto(
                objDto.get_id(),
                objDto.getUuid(),
                objDto.getDescricao(),
                objDto.getPreco(),
                objDto.getDurabilidade(),
                objDto.getPeso(),
                objDto.getRotulagem(),
                objDto.getStatus(),
                objDto.getAltura(),
                objDto.getLargura(),
                objDto.getFormato(),
                objDto.getEstilo(),
                objDto.getQualidade(),
                objDto.getTamanho(),
                objDto.getDevolucao(),
                objDto.getTipo(),
                objDto.getGarantia(),
                objDto.getEmbalagem(),
                objDto.getGrupo(),
                objDto.getCor(),
                objDto.getMarca(),
                objDto.getImagem(),
                objDto.getDatacadastro());
           }

    private void updateData(Produto newObj, Produto obj) {
        newObj.setCor(obj.getCor());
        newObj.setDescricao(obj.getDescricao());
        newObj.setGrupo(obj.getGrupo());
        newObj.setPreco(obj.getPreco());
        newObj.setDatacadastro(obj.getDatacadastro());
    }
  }
