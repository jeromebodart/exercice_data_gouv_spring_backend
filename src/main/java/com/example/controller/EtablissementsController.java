package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.etablissement.Etablissement;
import com.example.service.EtablissementService;

@RestController
@RequestMapping("/etablissements")
public class EtablissementsController {
	 @Autowired
	    private EtablissementService etablissementService;

	    @GetMapping
	    public List<Etablissement> index() {
	    	return etablissementService.findAll();
	    }
}
