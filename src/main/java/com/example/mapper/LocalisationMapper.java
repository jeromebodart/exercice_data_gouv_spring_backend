package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.domain.etablissement.Localisation;


@Mapper
public interface LocalisationMapper {
    List<Localisation> findAll();

    Localisation findOne(Long id);

    void save(Localisation player);

    void update(Localisation player);

    void delete(Long id);
}
