package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.domain.etablissement.AdresseGeographique;

@Mapper
public interface AdresseGeographiqueMapper {
    List<AdresseGeographique> findAll();

    AdresseGeographique findOne(Long id);

    void save(AdresseGeographique player);

    void update(AdresseGeographique player);

    void delete(Long id);
}
