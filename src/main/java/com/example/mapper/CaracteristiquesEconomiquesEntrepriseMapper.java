package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.domain.entreprise.CaracteristiquesEconomiquesEntreprise;

@Mapper
public interface CaracteristiquesEconomiquesEntrepriseMapper {
    List<CaracteristiquesEconomiquesEntreprise> findAll();

    CaracteristiquesEconomiquesEntreprise findOne(Long id);

    void save(CaracteristiquesEconomiquesEntreprise eco);

    void update(CaracteristiquesEconomiquesEntreprise eco);

    void delete(Long id);
}
