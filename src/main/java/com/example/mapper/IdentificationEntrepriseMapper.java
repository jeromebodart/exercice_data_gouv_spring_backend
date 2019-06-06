package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.domain.entreprise.IdentificationEntreprise;
@Mapper
public interface IdentificationEntrepriseMapper{
    List<IdentificationEntreprise> findAll();

    IdentificationEntreprise findOne(Long id);

    void save(IdentificationEntreprise player);

    void update(IdentificationEntreprise player);

    void delete(Long id);
}
