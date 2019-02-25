package com.booksgames.loja.config;

import com.LojaApplication;
import com.booksgames.loja.documents.*;
import com.booksgames.loja.repository.*;
import com.mongodb.gridfs.GridFS;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;
import java.util.UUID;

@Configuration
public class Instantiation  implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(LojaApplication.class);

    @Autowired
    private EmbalagemRepository embalagemRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CorRepository corRepository;

    @Autowired
    private GrupoRepository grupoRepository;

    @Autowired
    private MarcaRepository marcaRepository;

    @Override
    public void run(String... arg0) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        Embalagem PLASTICA = new Embalagem(null,"PLASTICA");
        Grupo GRUPOA =  new Grupo(null, "DESCRICAO GRUPO");
        Cor PRETO = new Cor(null, "PRETO", "XXXXX");
        Marca MARCA = new Marca(null, "MARCA X");

        Produto COMPUTADOR = new Produto(null, UUID.randomUUID(), "COMPUTADOR", 4.1,
                PLASTICA,"SIM", 82.0, "SIM", "Ativo", GRUPOA,
                PRETO, MARCA, null,
                sdf.parse("21/03/2018"));

        Produto CELULAR = new Produto(null, UUID.randomUUID(), "CELULAR", 4.1,
                PLASTICA, "SIM", 82.0, "SIM", "Ativo", GRUPOA,
                PRETO, MARCA, null,
                sdf.parse("21/03/2018"));

        embalagemRepository.saveAll(Arrays.asList(PLASTICA));
        grupoRepository.saveAll(Arrays.asList(GRUPOA));
        corRepository.saveAll(Arrays.asList(PRETO));
        marcaRepository.saveAll(Arrays.asList(MARCA));

        embalagemRepository.save(PLASTICA);
        grupoRepository.save(GRUPOA);
        corRepository.save(PRETO);
        marcaRepository.save(MARCA);

        embalagemRepository.saveAll(Arrays.asList(PLASTICA));
        grupoRepository.saveAll(Arrays.asList(GRUPOA));
        corRepository.saveAll(Arrays.asList(PRETO));
        marcaRepository.saveAll(Arrays.asList(MARCA));
        produtoRepository.saveAll(Arrays.asList(COMPUTADOR, CELULAR));

        produtoRepository.save(COMPUTADOR);

       }
}
