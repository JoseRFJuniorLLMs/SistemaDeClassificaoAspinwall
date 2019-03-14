package com.booksgames.loja.controllers;

import com.booksgames.loja.util.Disco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/imagem")
public class ImagemController {

    @Autowired
    private Disco disco;

    @PostMapping
    public void upload(@RequestParam MultipartFile imagem) {
        disco.salvarImagem(imagem);
    }
}
