package com.booksgames.loja.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class Disco {

    @Value("${contato.disco.raiz}")
    private String raiz;

    @Value("${contato.disco.diretorio-imagem}")
    private String diretorioImagens;

    public void salvarImagem(MultipartFile imagem) {
        this.salvar(this.diretorioImagens, imagem);
    }

    public void salvar(String diretorio, MultipartFile arquivo) {
        Path diretorioPath = Paths.get(this.raiz, diretorio);
        Path arquivoPath = diretorioPath.resolve(arquivo.getOriginalFilename());

        try {
            Files.createDirectories(diretorioPath);
            arquivo.transferTo(arquivoPath.toFile());
        } catch (IOException e) {
            throw new RuntimeException("Problemas na tentativa de salvar arquivo.", e);
        }
    }
}