package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.domain.etablissement.Etablissement;

@Mapper
public interface EtablissementMapper {
    List<Etablissement> findAll();

    Etablissement findOne(Long id);

    void save(Etablissement player);

    void update(Etablissement player);

    void delete(Long id);
}
