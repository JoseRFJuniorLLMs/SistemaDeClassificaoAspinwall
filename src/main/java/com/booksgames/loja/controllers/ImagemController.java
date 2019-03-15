package com.booksgames.loja.controllers;

import com.booksgames.loja.util.Disco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "*")
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
