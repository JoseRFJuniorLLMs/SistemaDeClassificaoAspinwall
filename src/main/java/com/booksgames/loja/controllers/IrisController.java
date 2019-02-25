package com.booksgames.loja.controllers;

import com.booksgames.loja.documents.Iris;
import com.booksgames.loja.documents.IrisType;
import com.booksgames.loja.services.IrisClassifierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
@CrossOrigin(origins = "*")
@RestController
public class IrisController {

    @Autowired
    IrisClassifierService irisClassifierService;

    @GetMapping(value = "/iris/classify/class")
    public IrisType classify(Iris iris) {
        return irisClassifierService.classify(iris);
    }

    @GetMapping(value = "/iris/classify/probabilities")
    public Map<IrisType, Float> classificationProbabilities(Iris iris) {
        return irisClassifierService.classificationProbabilities(iris);
    }

}
