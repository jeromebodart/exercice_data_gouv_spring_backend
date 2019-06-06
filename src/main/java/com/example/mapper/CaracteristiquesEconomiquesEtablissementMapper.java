package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.domain.etablissement.CaracteristiquesEconomiquesEtablissement;

@Mapper
public interface CaracteristiquesEconomiquesEtablissementMapper {
	   List<CaracteristiquesEconomiquesEtablissement> findAll();

	   CaracteristiquesEconomiquesEtablissement findOne(Long id);

	    void save(CaracteristiquesEconomiquesEtablissement player);

	    void update(CaracteristiquesEconomiquesEtablissement player);

	    void delete(Long id);
}
